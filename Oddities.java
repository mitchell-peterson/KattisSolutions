import java.io.*;
import java.util.*;
public class Oddities {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        while(n-->0){
            int x = Integer.parseInt(in.readLine());
            System.out.println(x%2==0?x + " is even" : x+" is odd");
        }
    }
}
