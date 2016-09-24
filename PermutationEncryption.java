import java.io.*;
import java.util.*;
public class PermutationEncryption {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line[] = in.readLine().split(" ");
            if(line.length == 1) break;
            int len = Integer.parseInt(line[0]);
            int perms[] = new int[len];
            for(int i = 0; i < len; i++){
                perms[i] = Integer.parseInt(line[i+1])-1;//SUBTRACT 1 FOR INDEXING
            }
            StringBuilder text = new StringBuilder(in.readLine());
            if(text.length() % perms.length != 0){
                while(text.length() % perms.length != 0) text.append(" ");
            }
            StringBuilder cipher = new StringBuilder();
            int offset = 0;
            for(int i = 0; i < text.length(); i+=perms.length){
                for(int j = 0; j < perms.length; j++){
                    cipher.append(text.charAt(perms[j]+offset));
                }
                offset += perms.length;//SUBTRACT 1 FOR INDEXING
            }
            System.out.println("'" + cipher + "'");
        }

        
    }
}
