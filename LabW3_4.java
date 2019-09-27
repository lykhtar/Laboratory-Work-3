package labw3_4;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class LabW3_4 {

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
            //       clientSocket = server.accept();
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            try {
                if (clientSocket.isConnected() == true) {
                    int rand = 1 + (int) (Math.random() * 5);//рандомное число от 1 до 5
                    BufferedReader br;
                    String[] s = null;
                    br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\КПО\\LabW3_3\\Sonet.txt")));
                    String tmp = "\n";
                    while ((tmp = br.readLine()) != null) {
                        for (int i = 1; i < 5; i++) {
                            s[i] = tmp;// вывести полученне строки 
                        }
                    }
                    //вывод строки
                    for (int i = 1; i < 5; i++) {
                        System.out.println(s[rand]);
                    }
                }
                out.flush();
            } finally {
                clientSocket.close();//закрыть сервер
            }
        } finally {
            //закрыть сервер
            System.out.println("Server closed");
            server.close();
        }
    }
}
