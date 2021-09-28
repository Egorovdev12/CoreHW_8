import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 12788;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            getResponse(in);

            sendMessage(out);

            getResponse(in);
            getResponse(in);

            sendMessage(out);

            getResponse(in);
            getResponse(in);
            getResponse(in);
            getResponse(in);
            getResponse(in);

            sendMessage(out);

            getResponse(in);
            getResponse(in);
            getResponse(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getResponse(BufferedReader in) throws IOException{
            String resp = in.readLine();
            System.out.println(resp);
    }

    public static void sendMessage(PrintWriter out){
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        out.println(message);
    }

}