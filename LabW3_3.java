package labw3_3;

import java.io.*;
import java.net.*;

public class LabW3_3 {

    static BufferedReader in = null, reader;
    static BufferedWriter out = null;
    static ServerSocket server = null;
  

    static class ServerS {

        ServerS( Socket clientSocket) throws IOException {
            try {
                server = new ServerSocket(8030); // серверсокет прослушивает порт 8030
                System.out.println("Server is open"); // сообщить о запуске
                clientSocket = server.accept(); // ждать подключения
                try { // создать сокет для общения с клиентом можно перейти
                    //принимать сообщения
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // отсылать сообщения
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    String word = in.readLine();
                    System.out.println(word);
                    out.write("Message to server : " + word + "\n");
                    out.flush();
                } finally {
                    clientSocket.close();//закрыть сервер
                    // закрыть потоки
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server closed!");
                server.close();
            }
        }
    }

    static class ClientS {

        ClientS( Socket clientSocket) throws IOException {
            try {
                // адрес - локальный хост, порт - 8030, такой же как у сервера
                clientSocket = new Socket("localhost", 8030);
                reader = new BufferedReader(new InputStreamReader(System.in));
                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать сообщения на сервер
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                String word = "Something information";
                out.write(word + "\n"); // отправляем сообщение на сервер
                out.flush();
            } finally {
                clientSocket.close();
                in.close();
                out.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
         Socket clientSocket = null;
        ServerS s = new ServerS(clientSocket);
        ClientS s1 = new ClientS(clientSocket);
    }
}
