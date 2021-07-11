package ru.geekbrains;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;

    private String userName;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String inputMessage = in.readUTF();
                        if (inputMessage.startsWith("/auth ")) { // /auth bob
                            userName = inputMessage.split("\\s+", 2)[1];
                            if (server.nameAvailable(userName)) {
                                server.subscribe(this);
                                sendMessage("/authok");
                                break;
                            } else {
                                sendMessage("/autnot");
                            }
                        } else {
                            sendMessage("SERVER: Вам необходимо авторизоваться");
                        }
                    }
                    while (true) {
                        String inputMessage = in.readUTF();
                        if (inputMessage.equals("/exit")) {
                            out.writeUTF("/exit");
                            break;
                        }
                        if (inputMessage.startsWith("/")) {
                            continue;
                        }
                        server.broadcastMessage(userName + ": " + inputMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    server.unsubscribe(this);
                    try {
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        return userName;
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
