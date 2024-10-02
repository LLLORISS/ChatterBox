import java.net.ServerSocket;
import java.io.IOException;

public class Server {

    private static final int PORT = 8971;

    public Server(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("The server is running on port " + PORT);
        }
        catch(IOException e){
            System.out.println("Server failed to start on port " + PORT);
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
            Server server = new Server();

    }
}
