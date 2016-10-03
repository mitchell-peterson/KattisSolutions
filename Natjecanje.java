import java.io.*;

public class Natjecanje {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[]  line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int r = Integer.parseInt(line[2]);
        line = in.readLine().split(" ");
        int[] dmg = new int[n+1];
        for(int i = 0; i < s; i++) dmg[Integer.parseInt(line[i])]++; //mark them as damaged
        line = in.readLine().split(" ");
        for(int i = 0; i < r; i++){
            int num = Integer.parseInt(line[i]);
            for(int d = -1; d <= 1 && num+d < dmg.length; d++){ //look one before, this one, and the next one
                if(dmg[num+d] == 1){ // if this one is damaged
                    dmg[num+d]--; //mark as undamaged
                    s--; //how many left damaged
                    break;
                }
            }
        }
        System.out.println(s);
        
    }
}