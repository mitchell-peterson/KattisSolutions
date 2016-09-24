import java.util.*;
public class Natjecanje {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int s = sc.nextInt(); int r = sc.nextInt();
        int[] teams = new int[n]; 
        for(int i = 0; i < s; i++) teams[sc.nextInt()-1]--;
        for(int i = 0; i < r; i++) teams[sc.nextInt()-1]++;
        for(int i = 0; i < n; i++){
            if(teams[i] == -1){
                if(i-1 >= 0 && teams[i-1] == 1){
                    teams[i]++; teams[i-1]--;
                }
                else if(i+1 < n && teams[i+1] == 1){
                    teams[i]++; teams[i+1]--;
                }
                
            }
        }
        int count = 0;
        for(int i : teams) if(i == -1) count++;
        System.out.println(count);
    }
}
