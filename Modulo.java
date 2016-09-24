import java.util.*;
import java.io.*;
public class Modulo {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean visited[] = new boolean[42];
        int count = 0;
        for(int i = 0; i < 10; i++){
            int cur = Integer.parseInt(in.readLine())%42;
            if(!visited[cur]){
                visited[cur] = true; count++;
            }
        }
        System.out.println(count);
    }
}
