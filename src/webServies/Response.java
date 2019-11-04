package webServies;

import java.io.*;

public class Response {

    public String url;

    public void write(String s,OutputStream out) throws Exception{
        out.write("HTTP/1.1 200 OK\n".getBytes());

        out.write("Content-Type:text/html;charset=gbk\n".getBytes());
        out.write("\n".getBytes());
        out.write(s.getBytes());
        out.flush();
        out.close();
    }
    public void write(OutputStream out) throws Exception{
        InputStream inputStream1 = new FileInputStream("D:\\bruip\\" +url);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream1,"gbk"));
        out.write("HTTP/1.1 200 OK\n".getBytes());

        out.write("Content-Type:text/html;charset=gbk\n".getBytes());
        out.write("\n".getBytes());
        String  s2 ;
        while ((s2= br1.readLine())!=null)
        {

            out.write(s2.getBytes("gbk"));
        }
        out.flush();
        out.close();
    }

}
