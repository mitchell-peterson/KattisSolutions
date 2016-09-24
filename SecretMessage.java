import java.io.*;
import java.util.*;
public class SecretMessage {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        while(cases-->0){
            StringBuilder text = new StringBuilder(in.readLine());
            int k = 1;
            while(k*k < text.length()) k++;
            for(int i = 0; i <= k*k; i++){
                if(i > text.length()) text.append("*");
            }
            char[][] message = new char[k][k];
            int pos = 0;
            for(int r = 0; r < k; r++){
                for(int c = 0; c < k; c++){
                    message[r][c] = text.charAt(pos);
                    pos++;
                }
            }
            char[][] transpose = new char[k][k];
            for(int r = 0; r < k; r++){
                for(int c = 0; c < k; c++){
                    transpose[c][k-r-1] = message[r][c];
                }
            }
            for(int r = 0; r < k; r++){
                for(int c = 0; c < k; c++){
                    if(transpose[r][c] != '*') System.out.print(transpose[r][c]);
                }
            }
            System.out.println("");
        }
    }
}
