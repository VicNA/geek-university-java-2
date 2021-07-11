package ru.geekbrains;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;

    private String name;
    private DataInputStream in;
    private DataOutputStream out;

//  Получение сокета от сервера, создание потоков in/out,
//  запуск в отдельном потоке чтения данных получаемых от пользователя
    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> readMessages()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//  Обработка входящих данных получаемых от пользователя
    private void readMessages() {
        try {
            while (!authentication(in.readUTF())) ;
            while (readMessage(in.readUTF())) ;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Клиент " + name + " отключился");
            server.unsubscribe(this);
            closeConnection();

        }
    }

//  Обработка сообщений пользователя на наличие внутренних комманд
//  и рассылка сообщения другим пользователям
    private boolean readMessage(String inputMessage) {
        if (inputMessage.startsWith("/")) {
            if (inputMessage.equals("/exit")) {
                sendMessage("/exit");
                return false;
            }
            if (inputMessage.startsWith("/w ")) {
                String[] tokens = inputMessage.split("\\s+", 3);
                server.sendPersonalMessage(this, tokens[1], tokens[2]);
            }
            return true;
        }
        server.broadcastMessage(name + ": " + inputMessage);
        return true;
    }

//  Обработка сообщения об авторизации
    private boolean authentication(String message) throws IOException {
        if (message.startsWith("/auth ")) {
            String[] tokens = message.split("\\s+");

            if (tokens.length == 1) {
                sendMessage("SERVER: Вы не указали имя пользователя");
                return false;
            }

            if (tokens.length > 2) {
                sendMessage("SERVER: Имя пользователя не должен содержать пробелы");
                return false;
            }

            String userName = tokens[1];
            if (server.isNameBusy(userName)) {
                sendMessage("SERVER: Данное имя пользователя уже занято");
                return false;
            }

            name = userName;
            sendMessage("/authok " + name);
            server.subscribe(this);
            return true;
        } else {
            sendMessage("SERVER: Вам необходимо авторизоваться");
            return false;
        }
    }

//  Полуение имя пользователя
    public String getName() {
        return name;
    }

//  Отправка сообщения пользователю
    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//  Закрытие подключения сокета и потоков данных
    private void closeConnection() {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
