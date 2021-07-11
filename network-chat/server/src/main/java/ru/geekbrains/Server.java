package ru.geekbrains;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    private LinkedList<ClientHandler> clients = new LinkedList<>();

    public Server() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен. Ожидаем подключение клиентов");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключился новый клиент");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastMessage(client.getUserName() + " вошел в чат ");
        // Сделайте так, чтобы при выполнении этого метода сервер сообщал всем клиентам
        // что в чат зашел клиент (+его имя указывал)
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastMessage(client.getUserName() + " вышел из чата");
        // Сделайте так, чтобы при выполнении этого метода сервер сообщал всем клиентам
        // что из чата вышел клиент (+его имя указывал)
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMessage(message);
        }
    }

    public synchronized boolean nameAvailable(String userName) {
        for (ClientHandler client : clients) {
            if (userName.equals(client.getUserName())) {
                return false;
            }
        }
        return true;
    }
}
