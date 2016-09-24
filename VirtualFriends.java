import java.io.*;
import java.util.*;
public class VirtualFriends {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        while(cases-->0){
            int f = Integer.parseInt(in.readLine());
            UnionFind set = new UnionFind(f*2);
            HashMap<String, Integer> fID = new HashMap<>();
            int counter = 0;
            for(int i = 0; i < f; i++){
                String input[] = in.readLine().split(" ");
                if(!fID.keySet().contains(input[0])) fID.put(input[0], counter++);
                if(!fID.keySet().contains(input[1])) fID.put(input[1], counter++);
                System.out.println(set.union(fID.get(input[0]), fID.get(input[1])));
            }                        
        }
    }
    static class UnionFind{
        int a[]; int sum[];
        UnionFind(int i){
            a = new int[i]; sum = new int[i];
            for(int j = 0; j < i; j++){
                a[j] = j;//Put everything initially in it's own set
                sum[j] = 1;
            }
        }
        int find(int i){
            if(a[i] == i) return i;//if we are at parent return
            else return a[i] = find(a[i]);//otherwise, find and update actual parent
        }
        int union(int x, int y){
            int findX = find(x);
            int findY = find(y);
            if(findX != findY) sum[findX] += sum[findY];
            a[findY] = findX;//Change parent of Y to X's parent
            return sum[findX];
        }
    }
}