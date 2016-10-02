import java.io.*;
import java.util.*;
public class EasiestProblem {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = in.readLine();
            int n = Integer.parseInt(input);
            if(n == 0) break;
            int sumN = sum(input);
            for(int i = 11; i < 1000; i++){
                int iSum = sum("" + (i*n));
                if(sumN == iSum){
                    System.out.println(i); break;
                }
            }
        }

    }
    static int sum(String s){
        int out = 0;
        for(int i = 0; i < s.length(); i++){
            out += (s.charAt(i) - '0');
        }
        return out;
    }
}
