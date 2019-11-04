package utill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RequesrImpl implements Request{
    private Socket socket;
    private String method;
    private String url;
    private String protocol;
    private Map<String, String> head;
    private Map<String, String> body;

    public RequesrImpl(Socket s){
        this.socket=s;
        head=new HashMap<>();
        body=new HashMap<>();
        getInfos();
    }

    private void getInfos() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line1 = br.readLine();
            String[] s = line1.split(" ");
            method=s[0];
            String substring = s[1].substring(1);
            if (method.equals("GET")&&substring.contains("?")){
                String[] split = substring.split("[?]");
                url=split[0];
                String[] split1 = split[1].split("&");
                for (int i=0;i<split1.length;i++){
                    String[] split2 = split1[i].split("=");
                    for (int j=0;j<split2.length;j++){
                        body.put(split2[0],split2[1]);
                    }
                }
            }else {
                url=substring;

            }
            protocol=s[2];
            String t;
            if (method.equals("GET")){
                while ((t=br.readLine()).length()!=0){
                    String[] split = t.split(": ");

                    head.put(split[0],split[1]);
                }
            }else {
                while ((t=br.readLine()).length()!=0){
                    String[] split = t.split(": ");

                    head.put(split[0],split[1]);
                }
                while ((t=br.readLine())!=null){
                    String[] split = t.split("&");
                    for (int i=0;i<split.length;i++){
                        String[] split1 = split[i].split("=");
                        body.put(split1[0],split1[1]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getFile() {
        return url;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public Map<String, String> getHead() {
        return head;
    }

    @Override
    public Map<String, String> getBody() {
        return body;
    }
}
