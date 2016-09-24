import java.awt.Point;
import java.io.*;
import java.util.*;
public class Keyboarding {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        char[][] keyboard = new char[r][c];
        for(int i = 0; i < r; i++){
            String temp = sc.next();
            for(int j = 0; j < c; j++){
                keyboard[i][j] = temp.charAt(j);
            }
        }
        String word = sc.next() + "*";
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};        
        int[][][][] graph = new int[r][c][4][2];//r,c, direction(NESW), next x,y in that direction
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                for(int d = 0; d < 4; d++){//for each direction
                    int nr = i, nc = j;
                    while(nr < r && nc < c && nr >= 0 && nc >=0 && 
                        keyboard[i][j] == keyboard[nr][nc]){
                        
                            nr += dir[d][0]; 
                            nc += dir[d][1];
                    }
                    if((nr < r && nc < c && nr >= 0 && nc >=0)){
                        graph[i][j][d][0] = nr; graph[i][j][d][1] = nc;
                    }
                    else {
                        graph[i][j][d][0] = i; graph[i][j][d][1] = j;
                    }
                }
            }
        }
        int test = 0;
        System.out.println(bfs(word, keyboard, graph));
    }
    public static int bfs(String word, char[][] keyboard, int[][][][] graph){
        boolean visited[][][] = new boolean[keyboard.length][keyboard[0].length][word.length()];
        ArrayList<Loc> toSearch = new ArrayList<>();
        toSearch.add(new Loc(0,0,0)); visited[0][0][0] = true;
        int moves = 0;
        while(!toSearch.isEmpty()){
            ArrayList<Loc> nextSearch = new ArrayList<>();
            for(Loc l : toSearch){
                if(keyboard[l.r][l.c] == word.charAt(l.k)){
                    if(l.k+1 == word.length()) return moves+1;
                    nextSearch.add(new Loc(l.r, l.c, l.k+1));
                    visited[l.r][l.c][l.k+1] = true;
                }
                for(int d = 0; d < 4; d++){
                    if(visited[graph[l.r][l.c][d][0]][graph[l.r][l.c][d][1]][l.k]) continue;
                    nextSearch.add(new Loc(graph[l.r][l.c][d][0], graph[l.r][l.c][d][1], l.k));
                    visited[graph[l.r][l.c][d][0]][graph[l.r][l.c][d][1]][l.k] = true;
                }
            }
            moves++;
            toSearch = nextSearch;
        }
        return moves;
    }
}

class Loc{
    int r, c, k;
    Loc(int r, int c, int k){
        this.r = r; this.c = c; this.k = k;
    }
}