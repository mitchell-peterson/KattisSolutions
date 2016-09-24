import java.awt.Point;
import java.util.*;
import java.io.*;
public class CoastLength {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        n = Integer.parseInt(input[0]); m = Integer.parseInt(input[1]);
        map = new int[n+2][m+2];
        visited = new boolean[n+2][m+2];
     for(int r = 1; r <= n; r++){
            String line = in.readLine();
            for(int c = 1; c <= line.length(); c++){
                map[r][c] = line.charAt(c-1) - '0';
            }
        }
        visited[0][0] = true;
        System.out.println(dfs(0,0));
    }
    static int dfs(int r, int c){
        int coast = 0;
        for(int i = 0; i < 4; i++){
            if(r+dr[i] < n+2 && r+dr[i] > -1 && c+dc[i] < m+2 && c+dc[i] > -1){
                if(map[r+dr[i]][c+dc[i]] == 1) coast++;
                else if(!visited[r+dr[i]][c+dc[i]]){  
                    visited[r+dr[i]][c+dc[i]] = true;
                    coast += dfs(r+dr[i], c+dc[i]);
                }
            }
        }
        return coast;
    }
}
