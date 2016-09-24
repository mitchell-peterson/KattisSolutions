import java.util.*;
import java.io.*;
public class Ptice {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char Adrian[] = {'A','B','C','A','B','C','A','B','C','A','B','C'};
        char Bruno[] =  {'B','A','B','C','B','A','B','C','B','A','B','C'};
        char Goran[] =  {'C','C','A','A','B','B','C','C','A','A','B','B'};
        int n = Integer.parseInt(in.readLine());
        String input = in.readLine();
        int scores[] = new int[3];
        for(int i = 0; i < n; i++){
            if(input.charAt(i)==Adrian[i%12]) scores[0]++;
            if(input.charAt(i)==Bruno[i%12]) scores[1]++;
            if(input.charAt(i)==Goran[i%12]) scores[2]++;
        }
        int max = -1; 
        for(int i : scores) if(i > max) max = i;
        System.out.println(max);
        if(scores[0]==max)System.out.println("Adrian");
        if(scores[1]==max)System.out.println("Bruno");
        if(scores[2]==max)System.out.println("Goran");
    }
}
