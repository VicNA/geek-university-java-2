package ru.geekbrains;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientController {

    @FXML
    private TextArea chatArea;
    @FXML
    private TextField messageField, userNameField;
    @FXML
    private HBox authPanel, msgPanel;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    public void connect(ActionEvent actionEvent) {
        createConnect();
        createThreadChat();
        try {
            out.writeUTF("/auth " + userNameField.getText());
//            userNameField.clear();
        } catch (IOException e) {
            showError("Невозможно отправить запрос авторизации на сервер");
        }
    }

    public void createConnect() {
        if (socket != null && !socket.isClosed()) {
            return;
        }
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            showError("Невозможно подключиться к серверу");
        }
    }

    private void createThreadChat() {
        new Thread(() -> {
            try {
                tryToAuth();
                runChat();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                msgPanel.setVisible(false);
                msgPanel.setManaged(false);
                authPanel.setVisible(true);
                authPanel.setManaged(true);
            }
        }).start();
    }

    private void tryToAuth() throws IOException {
        while (true) {
            String inputMessage = in.readUTF();
            if (inputMessage.equals("/authok")) {
                msgPanel.setVisible(true);
                msgPanel.setManaged(true);
                authPanel.setVisible(false);
                authPanel.setManaged(false);
                break;
            }
            if (inputMessage.equals("/autnot")) {
                System.out.println("Это имя занято");
                continue;
            }
            chatArea.appendText(inputMessage + "\n");
        }
    }

    private void runChat() throws IOException {
        while (true) {
            String inputMessage = in.readUTF();
            if (inputMessage.equals("/exit")) {
                chatArea.appendText(userNameField.getText() + " вышел из чата");
                break;
            }
            chatArea.appendText(inputMessage + "\n");
        }
    }

    public void sendMessage(ActionEvent actionEvent) {
        try {
            out.writeUTF(messageField.getText());
            messageField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitApplication() {
        try {
            out.writeUTF("/exit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showError(String message) {
        new Alert(Alert.AlertType.ERROR, message, ButtonType.OK).showAndWait();
    }
}
