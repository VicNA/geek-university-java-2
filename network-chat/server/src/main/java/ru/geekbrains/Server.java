package ru.geekbrains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int PORT = 8189;
    private static final Logger LOGGER = LogManager.getLogger(Server.class);

    private LinkedList<ClientHandler> clients = new LinkedList<>();

    private AuthService authService;
    private ExecutorService executor;

    public Server() {
//  Создание сервера сокета
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            LOGGER.info("Сервер запущен. Ожидаем подключение клиентов");

            authService = new SqlliteUtil();
            executor = Executors.newCachedThreadPool();

//          Ожидание подключении пользователей и создание клиентского обработчика
            while (true) {
                Socket socket = serverSocket.accept();
                LOGGER.info("Подключился новый клиент");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            authService.disconnect();
            LOGGER.info("Сервер завершил работу.");
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    //  Добавление пользователя в список и рассылка сообщения остальным пользователям
//  о новом пользователя в чате
    public synchronized void subscribe(ClientHandler client) {
        broadcastMessage("Пользователь " + client.getName() + " вошел в чат ");
        clients.add(client);
        broadcastClientList();
    }

    //  Удаление пользователя из списка и рассылка сообщения остальным пользователям
//  о выходе пользователя из чате
    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastMessage("Пользователь " + client.getName() + " вышел из чата");
        broadcastClientList();
    }

    //  Рассылка сообщения пользователям из списка
    public synchronized void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMessage(message);
        }
    }

    //  Рассылка команды-сообщения клиентам со списком пользоваетелей
    public synchronized void broadcastClientList() {
        StringBuilder sb = new StringBuilder(clients.size() * 10);
        sb.append("/clients_list ");
        for (ClientHandler client : clients) {
            sb.append(client.getName()).append(" ");
        }
        broadcastMessage(sb.toString());
    }

    //  Отправка личных сообщений
    public synchronized void sendPersonalMessage(ClientHandler sender, String receiverName, String message) {
        if (sender.getName().equalsIgnoreCase(receiverName)) {
            sender.sendMessage("Нельзя отправлять личные сообщения самому себе");
            return;
        }

        for (ClientHandler client : clients) {
            if (client.getName().equalsIgnoreCase(receiverName)) {
                client.sendMessage("от " + sender.getName() + ": " + message);
                sender.sendMessage("пользователю " + receiverName + ": " + message);
                return;
            }
        }

        sender.sendMessage("Пользователь " + receiverName + " не в сети");
    }

    //  Проверка, занятно ли указанное имя пользователя
    public synchronized boolean isNameBusy(String userName) {
        for (ClientHandler client : clients) {
            if (userName.equalsIgnoreCase(client.getName())) {
                return true;
            }
        }
        return false;
    }
}
