import java.util.*;
import java.io.*;
public class Bela {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line[] = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]); char trump = line[1].charAt(0);
        int cards = n*4; int score = 0;
        for(int i = 0; i < cards; i++){
            String card = in.readLine();
            char curSuit = card.charAt(1); 
            char rank = card.charAt(0);
            if(rank == 'A') score += 11;
            else if(rank == 'K') score += 4;
            else if(rank == 'Q') score += 3;
            else if(rank == 'J') score += trump == curSuit ? 20 : 2;
            else if(rank == 'T') score += 10;
            else if(rank == '9') score += trump == curSuit ? 14 : 0;
        }
        System.out.println(score);
    }
}