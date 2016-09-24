import java.io.*;
import java.util.*;
public class Pot {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int out = 0;
        for(int i = 0; i < n; i++){
            String input = in.readLine();
            int base = Integer.parseInt(input.substring(0, input.length()-1));
            int pow = Integer.parseInt(input.substring(input.length()-1));
            out += Math.pow(base, pow);
        }
        System.out.println(out);
    }
}
