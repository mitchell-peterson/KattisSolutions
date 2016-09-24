import java.io.*;
import java.util.*;
public class Ladder {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input[] = in.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int v = Integer.parseInt(input[1]);
        System.out.println((int)Math.ceil(h/Math.sin(v*Math.PI/180)));
    }
}
