import java.io.*;
import java.util.*;
public class Pet {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int scores[] = new int[5];
        int max = -1;
        for(int i = 0; i < 5; i++){
            String line[] = in.readLine().split(" ");
            for(int j = 0; j < 4; j++) scores[i] += Integer.parseInt(line[j]);
            if(scores[i] > max) max = scores[i];
        }
        for(int i = 0; i < 5; i++) if(scores[i] == max) System.out.println(i+1 + " " + scores[i]);
    }
}
