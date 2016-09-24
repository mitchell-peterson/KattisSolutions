import java.io.*;
import java.util.*;
public class ReversedBinaryNumbers {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String s = Integer.toBinaryString(n);
        StringBuilder out = new StringBuilder();
        for(int i = s.length()-1; i >=0; i--) out.append(s.charAt(i));
        System.out.println(Integer.parseInt(out.toString(), 2));
    }
}
