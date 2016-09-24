import java.io.*;
import java.util.*;
public class UnionFind {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        String line[] = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);
        Union set = new Union(n);
        for(int i = 0; i < q; i++){
            line = in.readLine().split(" ");
            if(line[0].equals("=")) set.union(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            else out.write((set.find(Integer.parseInt(line[1])) == set.find(Integer.parseInt(line[2])) ? "yes\n" : "no\n").getBytes());
        }
        out.flush();
    }
    static class Union{
        int a[];
        Union(int i){
            a = new int[i];
            for(int j = 0; j < i; j++){
                a[j] = j;//Put everything initially in it's own set
            }
        }
        int find(int i){
            if(a[i] == i) return i;//if we are at parent return
            else return a[i] = find(a[i]);//otherwise, find and update actual parent
        }
        void union(int x, int y){
            a[find(y)] = find(x);
        }
    }
}