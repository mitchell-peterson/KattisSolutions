import java.io.*;
import java.util.*;
public class AlmostUnionFind {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input[] = in.readLine().split(" ");
        UnionFind u = new UnionFind(Integer.parseInt(input[0]));
        int m = Integer.parseInt(input[1]);
        for(int i = 0; i < m; i++){
            input = in.readLine().split(" ");
            int cmd = Integer.parseInt(input[0]);
            if(cmd == 1){//union
                u.union(Integer.parseInt(input[1])-1, Integer.parseInt(input[2])-1);
            }
            else if(cmd == 2){//move
                u.move(Integer.parseInt(input[1])-1, Integer.parseInt(input[2])-1);
            }
            else{//print
                System.out.println(u.size(Integer.parseInt(input[1])-1));
            }
        }
    }
    static class UnionFind{
        int a[]; int[] size; 
        UnionFind(int i){
            a = new int[i]; size = new int[i];
            for(int j = 0; j < i; j++){
                a[j] = j;//Put everything initially in it's own set
                size[j] = 1;
            }
        }
        int find(int i){
            if(a[i] == i) return i;//if we are at parent return
            else return a[i] = find(a[i]);//otherwise, find and update actual parent
        }
        void union(int x, int y){
            int findX = find(x);
            int findY = find(y);
            if(findX != findY){
                size[findX] += size[findY];
                size[findY] = 0;
            }
            a[findY] = findX;//Change parent of Y to X's parent
            //return size[findX];
        }
        void move(int x, int y){
            int findX = find(x);
            int findY = find(y);
            if(findX != findY){
                size[findY]++;
                size[findX]--;
                a[x] = findY;
            }
        }
        int size(int x){
            return size[find(x)];
        }
    }
}
