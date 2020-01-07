package Lesson_6.HomeWork.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    TextArea msgArea;

    @FXML
    TextField msgSendInput;

    @FXML
    Button msgSendButton;

    @FXML
    HBox upperPanel;

    @FXML
    HBox msgSendField;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADDRESS = "localhost";
    final int PORT = 8585;

    private boolean isAuthorised;

    public void setAuthorised(boolean isAuthorised) {
        this.isAuthorised = isAuthorised;
        if (!isAuthorised) {
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            msgSendField.setVisible(false);
            msgSendField.setManaged(false);
        } else {
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            msgSendField.setVisible(true);
            msgSendField.setManaged(true);
        }
    }

    public void sendMSGToItem(ActionEvent actionEvent) {
        try {
            out.writeUTF(msgSendInput.getText());
            msgSendInput.clear();
            msgSendInput.requestFocus();
        } catch (IOException e) {
            msgArea.appendText("You're logged out! \n");
            e.printStackTrace();
        }
    }

    public void Dispose() {
        System.out.println("Exit message sent to server");
        try {
            if (out != null) {
                out.writeUTF("/end");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/authOk")) {
                            setAuthorised(true);
                            break;
                        } else {
                            msgArea.appendText(str + "\n");
                        }
                    }

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/ServerClosed")) break;
                        msgArea.appendText(str + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setAuthorised(false);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryAuth(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            connect();
        }
        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
