import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Playground {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factoral(202000).toString().length());
        //System.out.println(factoral(Integer.parseInt(in.readLine())));
    }
    static BigInteger factoral(int a){
        BigInteger out = new BigInteger("1");
        BigInteger dec = new BigInteger("1");
        BigInteger mult = new BigInteger(a+"");
        while(a-->0) {
            out = out.multiply(mult);         
            mult = mult.subtract(dec);
        }
        return out;
        
    }
}
