import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Server server;

    private Socket clientSocket = null;
    private static int clients_count = 0;

    public ClientHandler(Socket socket, Server Server){
        try{
            clients_count++;
            this.server = server;
            this.clientSocket = socket;
        }
        catch(Exception e){

        }
    }

    @Override
    public void run(){
        try{
            while(true){



                break;
            }

            Thread.sleep(100);
        }
        catch(Exception e){

        }
    }
}
