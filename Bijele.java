import java.util.*;
import java.io.*;
public class Bijele {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] key = {1, 1, 2, 2, 2, 8};
        String input[] = in.readLine().split(" ");
        for(int i = 0; i < 6; i++) System.out.print(key[i]-Integer.parseInt(input[i]) + " ");
    }
}
