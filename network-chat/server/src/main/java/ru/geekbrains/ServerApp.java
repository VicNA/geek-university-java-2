package ru.geekbrains;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerApp {

    private static LinkedList<ThreadClientSocket> clients = new LinkedList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен. Ожидаем подключение клиентов");

            int clientCounter = 0;
            String clientName;
            while (true) {
                Socket socket = serverSocket.accept();
                clientName = "Клиент" + ++clientCounter;
                clients.add(new ThreadClientSocket(clientName, socket));
                System.out.println("Подключился клиент под именем " + clientName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ThreadClientSocket implements Runnable {

        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;
        private String client;


        public ThreadClientSocket(String client, Socket socket) throws IOException {
            this.client = client;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    if (sb.append(in.readUTF()).toString().equals("/exit")) {
                        out.writeUTF(sb.toString());
                        System.out.println("Клиент под именем " + client + " завершил подключение");
                        break;
                    }

                    System.out.println(client + ": " + sb);
                    for (ThreadClientSocket clientSocket : ServerApp.clients) {
                        clientSocket.send(client + ": " + sb);
                    }
                    sb.setLength(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    socket.close();
                    ServerApp.clients.remove(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void send(String message) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
