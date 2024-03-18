import java.io.BufferedReader;
import java.io.FileReader;

public interface Setup {
    String value2 = null;
    BufferedReader reader2 = null;

    String Start = value2.substring(0,1);
    String Option = value2.substring(1,2);
    String Gallery = value2.substring(2,3);
    String Exit = value2.substring(3,4);
}
