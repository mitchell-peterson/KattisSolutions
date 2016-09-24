import java.io.*;
import java.util.*;
public class Artichokes {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(),
        c = sc.nextInt(), d = sc.nextInt(), n = sc.nextInt();
        double max = Double.MIN_VALUE; double maxD = Double.MIN_VALUE;
        for(int k = 1; k <= n; k++){
            double temp = p*(Math.sin((double)a*k+b)+Math.cos((double)c*k+d)+2);
            if(temp > max) max = temp;
            else if(max - temp > maxD) maxD = max - temp;
        }
        if(maxD <0) maxD = 0;
        System.out.print(maxD);
    }
}
