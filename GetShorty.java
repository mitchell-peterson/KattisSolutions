import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class GetShorty {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line[] = in.readLine().split(" ");
            int n = Integer.parseInt(line[0]); int m = Integer.parseInt(line[1]);
            if(n == 0 && m == 0) break;
            Node[] graph = new Node[n]; 
            for(int i = 0; i < m; i++){
                line = in.readLine().split(" ");
                int x = Integer.parseInt(line[0]); int y = Integer.parseInt(line[1]);
                double f = Double.parseDouble(line[2]);
                if(graph[x] == null) graph[x] = new Node();
                if(graph[y] == null) graph[y] = new Node();
                graph[x].connections.put(y, f);
                graph[y].connections.put(x, f); 
            }
            PriorityQueue<Point> q = new PriorityQueue<>();
            Point start = new Point(0, 1.0); q.add(start);
            while(true){
                Point cur = q.remove();
                if(cur.num == n-1){
                    System.out.printf("%.4f\n", cur.cost);
                    break;
                }
                if(graph[cur.num].visited) continue;
                for(Entry<Integer, Double> e : graph[cur.num].connections.entrySet()){
                    int k = e.getKey(); double v = e.getValue();
                    if((cur.cost * v) > graph[k].cost && !graph[k].visited){
                        Point point = new Point(k, cur.cost*v);
                        graph[k].cost = cur.cost*v;
                        q.add(point);
                    }
                }
                graph[cur.num].visited = true;
            }
        }
        
    }
    static class Point implements Comparable<Point>{
        int num; Double cost = Double.MIN_VALUE;
        Point(int n, double d){
            this.num = n; cost = d;
        }

        @Override
        public int compareTo(Point o) {
            if(this.cost < o.cost) return 1;
            else if(this.cost > o.cost) return -1;
            else return 0;
        }
    }
    static class Node{
        boolean visited = false;
        double cost = Double.MIN_VALUE;
        HashMap<Integer, Double> connections = new HashMap<>();
    }
}
