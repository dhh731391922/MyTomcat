package utill;

import java.util.Map;

public interface Request {
    public String getMethod();
    String getFile();
    String getProtocol();
    Map<String,String> getHead();
    Map<String,String> getBody();
}
