import java.io.*;
import java.util.*;
public class Pivot {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] a = new int[n]; 
        int[] min = new int[n]; int[] max = new int[n];
        String[] line = in.readLine().split(" ");
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(line[i]);
        }
        int upper = a[0]; int lower = a[n-1];
        for(int i = 0; i < n; i++){
            if(a[i] > upper) upper = a[i];
            max[i] = upper;
        }
        for(int i = n-1; i >= 0; i--){
            if(a[i] < lower) lower = a[i];
            min[i] = lower;
        }
        int out = 0;
        for(int i = 0; i < n; i++){
            if(a[i] <= min[i] && a[i] >= max[i]) out++;
        }
        System.out.println(out);
    }
}
