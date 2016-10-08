import java.io.*;
import java.util.*;

public class Rings2 {
	static int[][] grid;
	static final int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
		grid = new int[rows+2][cols+2];
		for(int r = 0; r < rows; r++){
			char[] line = br.readLine().toCharArray();
			for(int c = 0; c < cols; c++){
				if(line[c] == 'T') grid[r+1][c+1] = Integer.MAX_VALUE;
			}
		}
		ArrayList<int[]> start = new ArrayList<>();
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[0].length; c++){
				if(grid[r][c] == 0) start.add(new int[]{r,c});
			}
		}
		int rings = search(start);
		int size = rings > 10 ? 3 : 2;
		for(int r = 1; r <= rows; r++){
			for(int c = 1; c <= cols; c++){
				System.out.print(getSq(r,c,size));
			}
			System.out.println();
		}
	}
	
	static String getSq(int x, int y, int size){
		String out = "";
		if(grid[x][y] > 0)  out = out + grid[x][y];
		while(out.length() < size) out = "." + out;
		return out;
	}
	
	static int search(ArrayList<int[]> cur){
		int step = 0;
		while(!cur.isEmpty()){
			step++;
			ArrayList<int[]> next = new ArrayList<>();
			for(int[] loc : cur){
				for(int[] d : dir){
					int ny = loc[0]+d[0];
					int nx = loc[1]+d[1];
					if(ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length) continue;
					if(grid[ny][nx] > step){
						grid[ny][nx] = step;
						next.add(new int[]{ny, nx});
					}
				}
			}
			cur = next;
		}
		return step;
	}
}
