package labw3_2;

import java.io.*;
import java.net.*;

public class LabW3_2 {

    public static void main(String[] args) throws IOException {
        //создать сервер
        BufferedReader in = null, reader;
        BufferedWriter out = null;
        ServerSocket server = null;
        Socket clientSocket;
        try {
            server = new ServerSocket(8030); // серверсокет прослушивает порт 8030
            System.out.println("Server is open"); // сообщить о запуске
            clientSocket = new Socket("localhost", 8030);
            try {
                reader = new BufferedReader(new InputStreamReader(System.in));
                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать сообщения на сервер
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                String word = reader.readLine();//считать то что записано в консоль
                out.write(word + "\n"); // отправить сообщение на сервер
                out.write("Message to server : " + word + "\n");
                out.flush();
            } finally {
                clientSocket.close();//закрыть сервер
                // закрыть потоки
                in.close();
                out.close();
            }
        } finally {
            //закрыть сервер
            System.out.println("Server closed");
            server.close();
        }
    }
}
