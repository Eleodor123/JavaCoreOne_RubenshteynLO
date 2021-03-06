package Lesson_6.HomeWork.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Vector;

public class MainServer {

    private Vector<ClientHandler> clients;

    public MainServer() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;
        try {
            AuthService.connect();
            server = new ServerSocket(8585);
            System.out.println("Server started");
            //после запуска сервер встает на паузу до момента подключения клиента
            while (true) {
                socket = server.accept();
                //clients.add(new ClientHandler(this, socket));
                //вызов метода добавления клиента в вектор клиентов
                new ClientHandler(this,socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void broadCastMsg(String msg) {
        for (ClientHandler client: clients) {
            client.sendMsg("- " + ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)) + ": " + msg);
        }
    }

    public void whisperMsg(ClientHandler from, String to, String msg)
    {

        for (ClientHandler client: clients) {
            if(client.getNick().equals(to)) {
                client.sendMsg(from.getNick() + " whispers: " + msg);
                break;
            }
        }
        from.sendMsg("Whispers: " + to + " " + msg);
    }

    //добавление клиента в вектор
    public void clientLogIn(ClientHandler clientHandler) {
        System.out.println("Client logged in");
        clients.add(clientHandler);
    }
    //удаление клиента из вектора
    public void clientLogOut(ClientHandler clientHandler) {
        System.out.println("Client logged out");
        clients.remove(clientHandler);
    }


}
