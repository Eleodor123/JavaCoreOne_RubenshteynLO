package Lesson_6.HomeWork.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private MainServer server;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public MainServer getServer() {
        return server;
    }

    public void setServer(MainServer server) {
        this.server = server;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    private String nick;

    public ClientHandler(MainServer server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    //авторизация
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.startsWith("/auth")) {
                            String[] tokens = msg.split(" ");
                            String newNick = AuthService.getNickByLoginPass(tokens[1], tokens[2]);
                            if (newNick != null) {
                                sendMsg("/authOk");
                                nick = newNick;
                                server.clientLogIn(ClientHandler.this);
                                break;
                            } else {
                                sendMsg("Error in login or password!");
                            }
                        }
                    }
                    //общение с клиентом
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.equals("/end")) {
                            out.writeUTF("/ServerClosed");
                            break;
                        }
                        if (msg.startsWith("/w")) {
                            String to = msg.split(" ")[1];
                            String msgText = msg.split(" ")[2];
                            server.whisperMsg(this,to,msgText);
                        } else {
                            server.broadCastMsg(msg);
                        }
                        System.out.println(nick + ": " + ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)) + ": " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //вызов метода удаления клиента из вектора клиентов
                    server.clientLogOut(ClientHandler.this);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
