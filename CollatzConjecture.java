import java.io.*;
import java.util.*;
public class CollatzConjecture {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input[] = in.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            if(A == 0 && B == 0)break;
            long a = A; long b = B;
            HashMap<Long, Integer> visited = new HashMap<>();
            int stepsA = 0; int stepsB = 0;
            while(true){
                if(!visited.keySet().contains(a)) visited.put(a, stepsA);
                if(a == 1) break;
                if(a%2 != 0){
                    a = (a*3+1); stepsA++;
                }
                else{
                    a = (a/2); stepsA++;
                }
            }
            while(true){
                if(visited.keySet().contains(b)) break;
                if(b%2 != 0){
                    b = (b*3+1); stepsB++;
                }
                else{
                    b = (b/2); stepsB++;
                }
            }
            BufferedOutputStream out = new BufferedOutputStream(System.out);
            out.write((A + " needs " + visited.get(b) + " steps, " + B + " needs " + stepsB + " steps, they meet at " + b + "\n").getBytes());
            out.flush();
        }
    }
}
