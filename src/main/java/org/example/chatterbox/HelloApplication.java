package org.example.chatterbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Database.ChatterDB;

public class HelloApplication extends Application {

    private static final String SERVER_ADRESS = "192.168.0.110";
    private static final int SERVER_PORT = 8971;

    @Override
    public void start(Stage stage) {

        try(Socket socket = new Socket(SERVER_ADRESS, SERVER_PORT)){
            System.out.println("Connected to the chat server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            new Thread(() -> {
                try{
                    String serverMessage;
                    while((serverMessage = in.readLine()) != null){
                        System.out.println(serverMessage);
                    }
                }
                catch(IOException e){
                    System.out.println("Connection closed");
                    e.printStackTrace();
                }
            }).start();

            System.out.print("Enter your name: ");
            String clientName = scanner.nextLine();
            out.println(clientName);

            //Приклад підключення sql
            try(Connection connection = ChatterDB.getConnection()) {
                System.out.println("Success");
            }
            catch(SQLException e){

            }

        }
        catch(IOException e){
            System.out.println("Failed to connect to the server");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}