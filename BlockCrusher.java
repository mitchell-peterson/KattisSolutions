import java.io.*;
import java.util.*;
public class BlockCrusher {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line[] = in.readLine().split(" ");
            int h = Integer.parseInt(line[0]); int w = Integer.parseInt(line[1]);
            if(h == 0 && w == 0) break;
            PriorityQueue<Node> q = new PriorityQueue<>();
            Node[][] graph = new Node[h][w];
            for(int i = 0; i < h; i++){
                char cur[] = in.readLine().toCharArray();
                for(int j = 0; j < w; j++){
                    Node n = new Node(cur[j]-'0', i, j);
                    graph[i][j] = n;
                }
            }
            for(int i = 0; i < w; i++){
                graph[0][i].visited = true; 
                graph[0][i].pRow = 0; graph[0][i].pCol = i;
                q.add(graph[0][i]);
            }
            //changes in row and col for going clockwise around neighbors starting top left
            int dr[] = {-1, -1, -1, 0, 1, 1, 1, 0};
            int dc[] = {-1, 0, 1, 1, 1, 0, -1, -1};
            outer: while(true){
                Node n = q.remove();
                if(n.row == h-1){//if we are at the end of the block make all points = 0;
                    Integer row = n.row; Integer col = n.col;
                    while(true){
                        n = graph[row][col];
                        n.cost = 0;
                        if(row == 0) break outer;
                        row = n.pRow; col = n.pCol;
                    }
                }
                for(int i = 0; i < dc.length; i++){
                    if(n.row + dr[i] >= 0 && n.row + dr[i] < h &&
                       n.col + dc[i] >= 0 && n.col + dc[i] < w){
                        //If this neighbor is within the bounds and not visited
                        if(!graph[n.row+dr[i]][n.col+dc[i]].visited){
                            Node nbr = graph[n.row+dr[i]][n.col+dc[i]];
                            nbr.cost += n.cost; nbr.visited = true;
                            nbr.pRow = n.row; nbr.pCol = n.col;
                            q.add(nbr);
                        }
                    }
                }
            }
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    System.out.print(graph[i][j].cost == 0 ? " " : graph[i][j].weight);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    static class Node implements Comparable<Node>{
        int cost; int row; int col; 
        boolean visited = false; int weight;
        Node(int w, int x, int y){
            this.cost = w; this.weight = w; this.row = x; this.col = y;
        }
        Integer pRow = null; Integer pCol = null;
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
