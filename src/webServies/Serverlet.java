package webServies;

import utill.Init;
import utill.RequesrImpl;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class Serverlet {
    public static void main(String[] args) {
        try {
            serverStart(new Request(),new Response());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void serverStart(Request re,Response res) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Integer.valueOf(Init.server_port));
        System.out.println("服务器启动了=======");

        while (true){
            Socket s = serverSocket.accept();
//            RequesrImpl rer = new RequesrImpl(s);
//            System.out.println(rer.getFile());
//            System.out.println(rer.getMethod());
//            System.out.println(rer.getProtocol());
//            System.out.println(rer.getBody());
//            Map<String, String> head = rer.getHead();
//            Set<String> strings = head.keySet();
//            strings.forEach(o->{
//
//                System.out.println(o+":"+head.get(o));
//            });
            if (s.isConnected()){
                new Thread(()->{
                    try {
                        res.url=re.getUrl(s);
                        res.write(s.getOutputStream());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
