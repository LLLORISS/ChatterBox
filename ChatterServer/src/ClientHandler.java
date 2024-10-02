import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket clientSocket = null;

    private PrintWriter out;
    private BufferedReader in;
    private String clientName; //to future change

    public ClientHandler(Socket socket){
        this.clientSocket = socket;
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

    public String getClientName() {
        return clientName;
    }

}
