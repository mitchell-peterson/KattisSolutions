import java.io.*;
import java.util.*;
public class MovieCollection {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        while(cases-->0){
            String input[] = in.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            BIT b = new BIT(m+r);
            int stackPos[] = new int[m];
            for(int i = 0; i < m; i++){
                stackPos[i] = i+r;
                b.update(1, stackPos[i]);
            }
            input = in.readLine().split(" ");
            for(int i = 0; i < r; i++){
                int movieIdx = Integer.parseInt(input[i])-1;
                System.out.print(b.query(stackPos[movieIdx]-1) + " ");
                b.update(-1, stackPos[movieIdx]);
                stackPos[movieIdx] = r-i-1;
                b.update(1, stackPos[movieIdx]);
            }
            System.out.println("");
        }
    }
    static class BIT{
        //Binary Index Tree, or Fenwick Tree 84 887
        int a[];
        BIT(int i){
            this.a = new int[i+1];
        }
        void update(int val, int pos){
            while(pos < a.length && pos > 0){
                a[pos] += val;
                pos = pos + (pos & (-pos));
            }
        }
        int query(int to){
            int sum = 0;
            while(to > 0){
                sum += a[to];
                to = to - (to & (-to));
            }
            return sum;
        }
        int query(int from, int to){
            return query(from) - query(to);
        }
    }
}
