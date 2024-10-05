import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChatterServer {

    private static final int PORT = 8971;

    private static Map<String, ClientHandler> clientHandlers = new HashMap<>();

    public ChatterServer(){
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server is running on port " + PORT);

            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                new Thread(new ClientHandler(clientSocket, this)).start();
            }
        }catch(IOException e){
            System.out.println("Server failed to start on port " + PORT);
            e.printStackTrace();
        }
    }

    public synchronized void registerClient(String clientName, ClientHandler handler) {
        clientHandlers.put(clientName, handler);
        System.out.print("Client " + clientName + " has joined to the server");
    }

    public synchronized void removeClient(String clientName) {
        clientHandlers.remove(clientName);
        System.out.println("Client disconnected: " + clientName);
    }

    public static void main(String[] args){
            ChatterServer server = new ChatterServer();

    }
}
