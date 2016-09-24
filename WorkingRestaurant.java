import java.io.*;
import java.util.*;
public class WorkingRestaurant {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(in.readLine());
            if(n == 0) break;
            int pile1 = 0;
            int pile2 = 0;
            for(int i = 0; i < n; i++){
                String input[] = in.readLine().split(" ");
                if(input[0].equals("DROP")){
                    pile2 += Integer.parseInt(input[1]);
                    System.out.println("DROP 2 " + Integer.parseInt(input[1]));
                }
                else{
                    int request = Integer.parseInt(input[1]);
                    if(pile1 == 0){
                        System.out.println("MOVE 2->1 " + pile2);
                        pile1 += pile2; pile2 = 0;
                    }
                    if(request <= pile1){
                        System.out.println("TAKE 1 " + request);
                        pile1 -= request;
                    }
                    else{
                        System.out.println("TAKE 1 " + pile1); 
                        request -= pile1; pile1 = 0;
                        System.out.println("MOVE 2->1 " + pile2);
                        pile1 += pile2; pile2 = 0;
                        System.out.println("TAKE 1 " + request);
                        pile1 -= request;
                    }
                }
            }
            System.out.println("");
        }
    }
    static class Stack{
        int n; boolean sorted;
        Stack(int n){
            this.n = n; sorted = false;
        }
    }
}
