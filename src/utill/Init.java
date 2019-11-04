package utill;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Init {
    public static String server_port;
    public static String path;
    public static String indexPage;
    static {
        Properties pr = new Properties();
        try {
            pr.load(new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"conf.properties"));
            server_port=pr.getProperty("server_port");
            path=pr.getProperty("path");
            indexPage=pr.getProperty("indexPage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
