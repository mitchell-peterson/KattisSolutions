import java.util.*;
import java.io.*;

public class Tray {
	static int[][] shelf;
	static int wid;
	static Set<Integer[][]> check;
	static Map<String, Long> mem = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		wid = Integer.parseInt(line[0]);
		int n = Integer.parseInt(line[1]);
		shelf = new int[3][wid];
		if(n!=0) line = br.readLine().split(" ");
		for (int i = 0; i<n; i++) {
			double x = Double.parseDouble(line[2*i]);
			double y = Double.parseDouble(line[2*i+1]);
			shelf[(int) Math.floor(y)][(int) Math.floor(x)] = 2;
		}
		long out = recur(0,0);
		System.out.println(out);
	}

	static boolean check(int r, int c, boolean side) {
		if (r < 0 || r >= 3 || c < 0 || c >= wid || shelf[r][c] != 0) return false;
		if (side) c++;
		else r++;
		if (r < 0 || r >= shelf.length || c < 0 || c >= shelf[0].length || shelf[r][c] != 0) return false;
		return true;
	}

	private static long recur(int r, int c) {
		String hash = hash();
		Long out = mem.get(hash);
		if(out == null){
			if (r == shelf.length) {
				r = 0;
				c++;
			}
			if (c == shelf[0].length){
				return 1;
			}
			out = 0L;
			if (shelf[r][c] > 0)
				out += recur(r + 1, c);
			else {
				if (check(r, c, true)) {
					shelf[r][c] = 1;
					shelf[r][c + 1] = 1;
					out += recur(r + 1, c);
					shelf[r][c] = 0;
					shelf[r][c + 1] = 0;
				}
				if (check(r, c, false)) {
					shelf[r][c] = 1;
					shelf[r+1][c] = 1;
					out += recur(r + 1, c);
					shelf[r][c] = 0;
					shelf[r+1][c] = 0;
				}
				shelf[r][c]= 1;
				out+= recur(r+1,c);
				shelf[r][c] = 0;
			}
			mem.put(hash, out);
		}
		return out;
	}
	
	static void printShelf(){
		for(int i = 0; i < shelf.length; i++){
			for (int j = 0; j < shelf[0].length; j++){
				System.out.print(shelf[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static String hash(){
		StringBuilder out = new StringBuilder();
		for(int i = 0; i < shelf.length; i++){
			for(int j = 0; j < shelf[0].length; j++){
				out.append(shelf[i][j]+"");
			}
		}
		return out.toString();
	}
}
