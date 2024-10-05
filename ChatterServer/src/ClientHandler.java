import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket clientSocket;
    private ChatterServer server;

    private PrintWriter out;
    private BufferedReader in;
    private String clientName; //to future change

    public ClientHandler(Socket socket, ChatterServer server){
        this.clientSocket = socket;
        this.server = server;
    }

    @Override
    public void run(){
        try{
           out = new PrintWriter(clientSocket.getOutputStream());
           in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


           out.println("Enter your name: ");
           clientName = in.readLine();

           server.registerClient(clientName,this);


        }
        catch(Exception e){

        }
        finally{
            try{
                server.removeClient(clientName);
                clientSocket.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public String getClientName() {
        return clientName;
    }

}
