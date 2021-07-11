package ru.geekbrains;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    @FXML
    private TextArea chatArea;
    @FXML
    private TextField messageField;


    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread readMessageTread = new Thread(() -> {
                StringBuilder sb = new StringBuilder();
                try {
                    while (true) {
                        if (sb.append(in.readUTF()).toString().equals("/exit")) break;
                        chatArea.appendText(sb + "\n");
                        sb.setLength(0);
                    }
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
                }
            });
            readMessageTread.start();

        } catch (IOException e) {
            System.out.println("Невозможно подключится к серверу");
            System.exit(0);
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

    public void createConnection(ActionEvent actionEvent) {
        // я не знаю как продупблировать окно
    }
}
