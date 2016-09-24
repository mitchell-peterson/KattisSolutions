import java.io.*;
import java.util.*;
public class SpeedLimit {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(in.readLine());
            if(n == -1) break;
            int hours = 0; int miles = 0;
            for(int i = 0; i < n; i++){
                String input[] = in.readLine().split(" ");
                int mph = Integer.parseInt(input[0]);
                int time = Integer.parseInt(input[1]);
                miles += (time-hours)*mph;
                hours = time;
            }         
            System.out.println(miles + " miles");
        }
    }
}
