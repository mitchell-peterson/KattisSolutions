import java.io.*;
import java.util.*;
public class CountingSubseq {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        while(cases-->0){
            in.readLine();
            int n = Integer.parseInt(in.readLine());
            String input[] = in.readLine().split(" ");
            HashMap<Long, Integer> map = new HashMap<>();
            long sum = 0; int out = 0;
            for(int i = 0; i < n; i++){
                Integer val = map.get(sum);
                if(val == null) map.put(sum, 1);
                else map.put(sum, val+1);
                sum += Integer.parseInt(input[i]);
                val = map.get(sum-47);
                if(val != null) out += val;
            }
            System.out.println(out);
        }
    }
}
