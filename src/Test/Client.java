package Test;

import java.io.IOException;
import java.net.*;

public class Client {
    private int port, locport;
    private InetAddress ip;
    private String host, msg;
    private Socket soc;
    private DatagramPacket pac;
    private DatagramSocket dsoc;
    private byte[] data;

    Client( int port) {
        this.port = port;
       // String str = "Hello !";
        data = new byte[1024];

//         data =  str.getBytes();

        try {
            data[0] = 'a';
            data[1] = 'b';
            data[2] = 'c';
            this.ip = InetAddress.getLocalHost();
//            System.out.println("Host: " + this.host.getHostAddress());
            host = ip.getHostAddress();
//            int p = port;
            System.out.println("Host: " + host + " port: " + port);

//            this.host = InetAddress.getByName(url);
//            String adr = host.getHostAddress();
//            System.out.println("Host: " + adr);

                soc = new Socket(host, this.port);
//            System.out.println("Client is run !");
            locport = soc.getLocalPort();
            if(locport != 0) {
                msg = "Client is run!  Host: " + host + " port: " + locport;
                data = msg.getBytes();
            } else {
                msg = "Client is run!  Host: " + host + " conectport: " + port;
                data = msg.getBytes();
            }



//                System.out.println("Port: " + locport);
//                System.out.println("Port: " + soc.getLocalPort());

            dsoc = new DatagramSocket(locport, ip );
            System.out.println(dsoc.isBound());
            System.out.println(dsoc.isConnected());
            System.out.println(data.length);
            System.out.println( (char)data[0]);
            System.out.println( (char)data[1]);
            System.out.println( (char)data[2]);

            System.out.println("dsoc: "+ dsoc.getLocalAddress().getHostAddress());


            pac = new DatagramPacket(data, data.length, ip, port);
            pac.setData(data);
            System.out.println(msg);
            dsoc.send(pac);
            System.out.println("packet send");


                dsoc.close();
                soc.close();
            } catch (IOException e) {
                e.getStackTrace();
                System.out.println("Server not runing");
            }




    }


    public static void main(String[] args) {
        System.out.println("__ Client __");
        new Client( 8080);
    }
}
