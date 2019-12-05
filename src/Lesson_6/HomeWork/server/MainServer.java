package Lesson_6.HomeWork.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
            server = new ServerSocket(8189);
            System.out.println("Server started");
            //после запуска сервер встает на паузу до момента подключения клиента
            while (true) {
                socket = server.accept();
                //clients.add(new ClientHandler(this, socket));
                //вызов метода добавления клиента в вектор клиентов
                clientLogIn(new ClientHandler(this,socket));
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
        }
    }

    public void broadCastMsg(String msg) {
        for (ClientHandler o: clients) {
            o.sendMsg("- " + ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)) + ": " + msg);
        }
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
