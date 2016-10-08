import java.io.*;
import java.util.*;

public class Squawk {
	static ArrayList<Integer>[] node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);//users
		int m = Integer.parseInt(input[1]);//edges
		int s = Integer.parseInt(input[2]);//infected users
		int t = Integer.parseInt(input[3]); //minutes
		node = new ArrayList[n];
		for(int i = 0; i < n; i++) node[i] = new ArrayList<>();
		for(int i = 0; i < m; i++){
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			node[a].add(b);
			node[b].add(a);
		}
		System.out.println(getSquawk(s, t));
	}
	
	static long getSquawk(int start, int time){
		long sent = 0;
		long[] squawks = new long[node.length];
		squawks[start] = 1; 
		for(int t = 0; t < time; t++){
			long[] nextSqk = new long[node.length];
			sent = 0;
			for(int i = 0; i < node.length; i++){
				if (squawks[i] == 0) continue;
 				for(int ngh : node[i]){
					nextSqk[ngh] = nextSqk[ngh] + squawks[i];
					sent += squawks[i];
				}
			}
			squawks = nextSqk;
		}
		return sent;
	}
}
