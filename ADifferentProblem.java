import java.io.*;
import java.util.*;
public class ADifferentProblem {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long a = in.nextLong(); long b = in.nextLong();
            System.out.println(a < b ? b-a : a-b);
        }
    }
}
