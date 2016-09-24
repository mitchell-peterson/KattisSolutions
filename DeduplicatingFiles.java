import java.awt.Point;
import java.io.*;
import java.util.*;
public class DeduplicatingFiles {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(in.readLine());
            if(n == 0) break;
            String files[] = new String[n];
            int[] hash = new int[n];
            for(int i = 0; i < n; i++){
                files[i] = in.readLine();
                byte h = 0;
                for(byte b : files[i].getBytes()){
                    h = (byte)(b ^ h);
                }
                hash[i] = h;
            }
            int uniques = 0; int collisions = 0;
            for(int i = 0; i < n; i++){
                boolean u = true;
                for(int j = i+1; j < n; j++){
                    if(hash[i] == hash[j]){
                        collisions++;
                        if(files[i].equals(files[j])){
                            u = false; collisions--;
                        }
                    }
                }
                if(u) uniques++;
            }
            System.out.println(uniques + " " +collisions);
        }
    }
}
