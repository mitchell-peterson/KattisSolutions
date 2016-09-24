import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class SimpleAddition {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(in.readLine());
        BigInteger b = new BigInteger(in.readLine());
        System.out.println(a.add(b));
    }
}
