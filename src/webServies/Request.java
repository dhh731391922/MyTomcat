package webServies;

import utill.Init;

import java.io.*;
import java.net.Socket;

public class Request {



    public String getUrl(Socket s)throws Exception{
        InputStream is = s.getInputStream();
        InputStreamReader isr  = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String  lines = br.readLine();

        String[] ss = lines.split(" ");
        ss[1] =ss[1].substring(1);
        return ss[1];

    }
}
