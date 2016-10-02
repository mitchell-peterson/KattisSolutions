import java.io.*;
import java.util.*;
public class BirdWire {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int l = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);
        int[] birds = new int[n];
        for(int i = 0; i < n; i++){
            birds[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(birds);
        int curPos = 6; int out = 0;
        for(int i = 0; i < n; i++){
            while(true){
                if(birds[i]-curPos >= d){
                    out++; curPos += d;
                }
                else {
                    curPos = birds[i]+d; break;
                }
            }
        }
        while(curPos <= l-6){
            out++; curPos += d;
        }
        System.out.println(out);
    }
}
