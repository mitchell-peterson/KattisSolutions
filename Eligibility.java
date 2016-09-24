import java.io.*;
import java.util.*;
public class Eligibility {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            String line[] = in.readLine().split(" ");
            if(Integer.parseInt(line[1].substring(0,4))>=2010)
                System.out.println(line[0]+" eligible");
            else if(Integer.parseInt(line[2].substring(0,4))>=1991)
                System.out.println(line[0]+" eligible");
            else if(Integer.parseInt(line[3]) >= 41)
                System.out.println(line[0]+" ineligible");
            else 
                System.out.println(line[0] + " coach petitions");
        }
    }
}
