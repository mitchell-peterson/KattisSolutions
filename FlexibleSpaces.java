import java.io.*;
import java.util.*;
public class FlexibleSpaces {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line[] = in.readLine().split(" ");
        int width = Integer.parseInt(line[0]);
        int walls = Integer.parseInt(line[1]);
        int prev[] = new int[walls];
        line = in.readLine().split(" ");
        TreeSet<Integer> parts = new TreeSet<>();
        parts.add(width);
        for(int i = 0; i < walls; i++){
            int cur = Integer.parseInt(line[i]);
            parts.add(cur);
            parts.add(width-cur);
            for(int j = i-1; j >= 0; j--){
                parts.add(cur-prev[j]);
            }
            prev[i] = cur;
        }
        for(int i : parts) System.out.print(i + " ");
    }
}
