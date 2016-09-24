import java.io.*;
import java.util.*;
public class MinSpanTree {
    static PriorityQueue<Edge> q; static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line[] = in.readLine().split(" ");
            int n = Integer.parseInt(line[0]); int m = Integer.parseInt(line[1]);
            if(n == 0 && m == 0) break;
            
            q = new PriorityQueue<>(); parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
            for(int i = 0; i < m; i++){
                line = in.readLine().split(" ");
                q.add(new Edge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
            }
            
            ArrayList<Edge> used = new ArrayList<>();
            while(!q.isEmpty()){
                Edge e = q.remove();
                if(find(e.a) == find(e.b)) continue;//if they are already in the same set
                union(e.a, e.b);
                used.add(e);
            }
            
            if(used.size() != n-1) System.out.println("Impossible");
            else{
                int sum = 0; ArrayList<Point> sorted = new ArrayList<>();
                for(Edge e : used){
                    sum += e.cost; sorted.add(new Point(e.a, e.b));
                }
                System.out.println(sum);
                Collections.sort(sorted);
                for(Point p : sorted) System.out.println(p.x + " " + p.y);
            }
        }
    }
    static class Edge implements Comparable<Edge>{
        int a, b, cost;
        Edge(int x, int y, int c){
            this.a = x; this.b = y; this.cost = c;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    
    static class Point implements Comparable<Point>{
        int x, y;
        Point(int a, int b){
            if(a < b){
                this.x = a; this.y = b;
            }
            else{
                this.x = b; this.y = a;
            }
        }
        @Override
        public int compareTo(Point o) {
            if(this.x == o.x){
                return this.y - o.y;
            }
            else return this.x - o.x;
        }
        
    }
    
    static int find(int x){
        if(parent[x] == x) return x;
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    static void union(int x, int y){
        parent[find(x)] = find(y);
    }
}
