import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    
    public void run() throws IOException, UnknownHostException{
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(20000);
        while(true){
            System.out.println("Server is listening on port: "+port);
            Socket acceptedConnection = socket.accept();
            System.out.println("Connected to "+acceptedConnection.getRemoteSocketAddress());
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
            toClient.println("Hello World from the server");
        }
    }
    //this function sets up a server that listens on port 8010, accepts incoming connections, sends a simple "Hello World" message to each connecting client, and continues to listen for new connections indefinitely.








    public static void main(String[] args){
        Server server = new Server();
        try{
            server.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}