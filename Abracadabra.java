import java.util.*;
import java.io.*;
public class Abracadabra {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for(int i = 1; i <= n; i++) System.out.println(i + " Abracadabra");
    }
}
