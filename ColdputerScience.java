import java.util.*;
import java.io.*;
public class ColdputerScience {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
        String list[] = in.readLine().split(" ");
        int count = 0;
        for (String list1 : list) if (Integer.parseInt(list1) < 0) count++;          
        System.out.println(count);
    }
}
