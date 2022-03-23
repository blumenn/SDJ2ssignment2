package socketsuppercase.server.networking;

import socketsuppercase.server.model.TextManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {

    private TextManager textManager;

    public SocketServer(TextManager textManager) {
        this.textManager = textManager;
    }

    public void startServer() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);
            List<SocketHandler> handlers = new ArrayList<SocketHandler>();
            while (true) {
                Socket socket = welcomeSocket.accept();
                SocketHandler handler = new SocketHandler(socket, textManager);
                handlers.add(handler);
                System.out.println("handlers:" + handlers.size());
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
