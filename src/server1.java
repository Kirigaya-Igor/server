import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server1 {
    public static void main(String[] argS) throws IOException {
        ServerSocket serverSocket = new ServerSocket( 23 );

        try (
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ){
            System.out.println("new conection from : " + clientSocket.getRemoteSocketAddress().toString());
            String inputLine;

            while ((inputLine = in.readLine()) != null){
                System.out.println("read from client: " + inputLine);
                out.println(Integer.valueOf(inputLine) + 1);
                System.out.println("wrout to client: " + (Integer.valueOf(inputLine) + 1));
            }
            System.out.println("client has been disconnected");
        }catch (Throwable cause) {
            System.out.println("conection error: " + cause.getMessage());
        }


    }

}
