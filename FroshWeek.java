import java.io.*;
import java.util.*;
public class FroshWeek {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int a[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        BIT bit = new BIT(n);
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(in.readLine());
            map.put(a[i], i);
            bit.update(1, i+1);//Update all bit indexes with 1 except for 0
        }
        Arrays.sort(a); long inversions = 0;
        for(int i = 0; i < a.length; i++){
            inversions += bit.query(map.get(a[i]));
            bit.update(-1, map.get(a[i])+1);
        }
        System.out.println(inversions);
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
