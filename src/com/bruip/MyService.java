package com.bruip;

import utill.RequesrImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyService {
    //建立一个TCP服务
    //2.接收客户端信息
    //3.1.http请求的数据
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("服务器启动了=======");
        //  1.搭建TCP
       while (true){
           try {


               //这个就是监听作用：
               //2.
               Socket socket =  serverSocket.accept();
               if (socket != null){
                  new Thread(()->{
                      System.out.println("连接成功;=========");
                      RequesrImpl re = new RequesrImpl(socket);
                      System.out.println(re.getFile()+"aaaaaaaaaaaaaa");
//                      InputStream inputStream = null;
//                      try {
//                          inputStream = socket.getInputStream();
//                          InputStreamReader isr  = new InputStreamReader(inputStream);
//                          BufferedReader br = new BufferedReader(isr);
//
//                          String  lines = br.readLine();
//                            String aa;
//                          String[] s = lines.split(" ");
//                          s[1] =s[1].substring(1);
//                          while ((aa=br.readLine())!=null)
//                              System.out.println(aa);
//
//
//                          InputStream inputStream1 = new FileInputStream("D:\\bruip\\" +s[1]);
//                          System.out.println("aaaaaaaaaaaaaaaaa");
//                          BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream1,"gbk"));
//                          OutputStream bw = socket.getOutputStream();
////            BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(outputStream));
//                          String  s2 ;
//                          //  返回也是HTTP格式：
//                          // 第一行 HTTP 格式
//                          //第二行 响应头；
//                          // 第三行 ： 空行
//                          //第四行 ： 响应体；
//
//                          bw.write("HTTP/1.1 200 OK\n".getBytes());
//
//                          bw.write("Content-Type:text/html;charset=gbk\n".getBytes());
//                          bw.write("\n".getBytes());
//
//
//                          while ((s2= br1.readLine())!=null)
//                          {
//
//                              bw.write(s2.getBytes("gbk"));
//                          }
//                          bw.flush();
//                          bw.close();
//                      } catch (IOException e) {
//                          e.printStackTrace();
//                      }

                  }).start();
               }
               //3 接收客户端的数据；
               //  http请求的数据，
               // 请求行   请求头  空行  请求体；


               // 接受的时候，准备流；



//               while ((lines =br.readLine())!= null)
//            {
//                System.out.println(lines);
//            }

           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
}
