import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.invoke.SwitchPoint;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 12788;

        while (true) {
            try (ServerSocket myServerSocket = new ServerSocket(port);
                 Socket clientSocket = myServerSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                System.out.println("Registered a new connection");
                out.println(String.format("Introduce yourself: "));
                String name = in.readLine();

                if (!name.equals("")){
                    out.println(String.format("Hello, " + name + ", your port is " + clientSocket.getPort()));
                }
                out.println(String.format("You are 18 or older? (y/n)"));
                String ans = in.readLine();

                if (ans.equals("y")){
                    out.println("Access allowed");
                }

                if (ans.equals("n")){
                    out.println("Access denied");
                    myServerSocket.close();
                    clientSocket.close();
                }

                out.println("What are you want?\n" +
                        "1. Cat memes\n" +
                        "2. Memes with funny yellow dog\n" +
                        "3. See something terrible and monstrous\n"
                );

                ans = in.readLine();

                switch (ans){
                    case "1":
                        out.println("https://vk.com/catism");
                        break;
                    case "2":
                        out.println("https://vk.com/shibeposting");
                        break;
                    case "3":
                        out.println("https://market.yandex.ru/product--prata-s-iazyk-programmirovaniia-c-6-e-izd/617625177?clid=703&cpa=0");
                        break;
                    default:
                        out.println("Incorrect response");
                        break;
                }

                out.println("Enjoy!");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}