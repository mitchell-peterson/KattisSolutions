import java.io.*;
import java.util.*;
public class VivoParc {
    static Node graph[];
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        graph = new Node[n];
        for(int i = 1; in.ready(); i++){
            String line[] = in.readLine().split("-");
            int x = Integer.parseInt(line[0]) - 1; int y = Integer.parseInt(line[1]) - 1;
            if(graph[x] == null) graph[x] = new Node(x);
            if(graph[y] == null) graph[y] = new Node(y);
            graph[x].connections.add(y); graph[y].connections.add(x);
        }
        color(0);
        for(Node end : graph){
            System.out.println((end.num+1) + " " + (end.color+1));
        }
    }
    static boolean color(int n){
        boolean used[] = new boolean[4];
        for(int nbr : graph[n].connections){
            if(graph[nbr].color != null) used[graph[nbr].color] = true;
        }
        for(int i = 0; i < 4; i++){
            if(!used[i]){
                graph[n].color = i;
                if(n == graph.length-1 || color(n+1)) return true;
            }
        }
        graph[n].color = null;
        return false;
    }
    static class Node{
        Integer color = null; int num;
        Node(int n){
            this.num = n;
        }
        HashSet<Integer> connections = new HashSet<>();
    }
}
