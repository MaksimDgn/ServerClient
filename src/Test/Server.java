package Test;

import java.io.IOException;
import java.net.*;

public class Server extends Thread {
    private int port;
    private InetAddress ip ;
    private String host;
//    private Socket socket;
    private ServerSocket servsSoc;
    private SocketAddress socAddr;
    private DatagramSocket dsoc;
    private DatagramPacket pac;

    Server(  int port) {
        this.port = port;
        byte[] data = new byte[1024];
        try {
            this.ip = InetAddress.getLocalHost();
            host = this.ip.getHostAddress();

//            System.out.println("ip: " + this.ip.getHostAddress());
//            System.out.println(host);

            servsSoc = new ServerSocket(port);


//            socAddr = InetSocketAddress.createUnresolved(host, port);
//            System.out.println("Socket Address:" + socAddr.toString());


            System.out.println("Server run... ip: " + host + " port: " + port);
            servsSoc.accept();

//            System.out.println("Server run... ip: " + dsoc.getInetAddress());
//            System.out.println("Port: " + dsoc.getLocalPort());
//            System.out.println("address: " + servsSoc.getInetAddress().getHostName());


//            servsSoc.bind(socAddr);

            dsoc = new DatagramSocket(port);

            pac = new DatagramPacket(data, data.length );

            dsoc.receive(pac);
            System.out.println("--DatagramPacket--");
                data = pac.getData();

                if (data.length != 0) {
                    System.out.println("    data.length: " + data.length);
                    for (int i = 0; i < data.length; i++) {
                        if (data[i] != 0)
                        System.out.print((char)data[i]);
                    }
                }


            dsoc.close();
            servsSoc.close();

            System.out.println("");
            System.out.println("Server close.");

        } catch (InternalError e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void run() {
//        new Server(8080);
//    }

    public static void main(String[] args) {
        System.out.println("--= Server =--");
//        Thread s = new Server("127.0.1.1",8080);
       // Thread s = new Server(8080);
       // s.start();
        new Server(8080);
    }
}
