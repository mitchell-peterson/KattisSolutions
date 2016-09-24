import java.math.BigInteger;
import java.util.*;
public class MinScalarProduct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int c = 0;
        while(++c <= cases){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0; i < n; i++) a[i] = in.nextInt();
            for(int i = 0; i < n; i++) b[i] = in.nextInt();
            Arrays.sort(a); Arrays.sort(b);
            BigInteger sum = BigInteger.ZERO;
            for(int i = 0; i < n; i++){
                sum = sum.add( new BigInteger(""+ a[i]).multiply(new BigInteger(""+b[n -1 -i])));
            }
            System.out.println("Case #" + c + ": " + sum);
        }
    }
}