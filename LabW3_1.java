package labw3_1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class LabW3_1 {

    public static void main(String[] args) throws UnknownHostException, IOException {
        //задать переменную ip, массив ipList со списком ip и массив с ip активных компьютеров
        String ip;
        ArrayList<String>ipList =  new ArrayList<>();
        ArrayList<String> reachableList = new ArrayList<>();
        //задать список ip адресов
        for (int i = 0; i < 100; i++) {
            ip = "192.168.0." + i;
            ipList.add(ip);
        }
        //для каждого ip 
        for (String ip1 : ipList) {
            InetAddress a = InetAddress.getByName(ip1);
            if (a.isReachable(2000)) {
                reachableList.add(ip1);
            }
        }
        //вывести список ip
        System.out.println("reachable hosts:");
        reachableList.forEach((reachable) -> {
            System.out.println(reachable);
        });

    }
}
