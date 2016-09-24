import java.io.*;
import java.util.*;
public class Everywhere {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        while(cases-->0){
            int n = Integer.parseInt(in.readLine());
            HashSet<String> visited = new HashSet<>();
            for(int i = 0; i < n; i++) visited.add(in.readLine());
            System.out.println(visited.size());
        }
    }
}
