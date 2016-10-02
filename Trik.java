import java.io.*;
import java.util.*;
public class Trik {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        boolean cups[] = {true, false, false};
        int idx = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'A'){
                if(idx == 0) idx = 1;
                else if(idx == 1) idx = 0;
            }
            else if(input.charAt(i) == 'B'){
                if(idx == 1) idx = 2;
                else if(idx == 2) idx = 1;
            }
            else if(input.charAt(i) == 'C'){
                if(idx == 2) idx = 0;
                else if(idx == 0) idx = 2;
            }
        }
        System.out.println(idx+1);
    }
}
