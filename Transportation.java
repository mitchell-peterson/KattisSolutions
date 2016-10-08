import java.io.*;
import java.util.*;
public class Transportation {
	static final int SRC = 0;
	static final int SNK = 1;
	static int count;
	static Map<String, Integer> index = new HashMap<>();
	static Set<Integer>[] out;
	static Integer[] par;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int s = Integer.parseInt(input[0]); //states
		int r = Integer.parseInt(input[1]); //src -> states
		int f = Integer.parseInt(input[2]); //states -> sink
		int t = Integer.parseInt(input[3]); //transport companies
		out = new HashSet[s+s+t+t+2];
		par = new Integer[out.length];
		count = out.length;
		for(int i = 0; i < out.length; i++) out[i] = new HashSet<>();
		//src -> states
		input = br.readLine().split(" ");
		for(int j = 0; j < input.length; j++) out[SRC].add(getIndex(input[j]));
		//states -> sink
		input = br.readLine().split(" ");
		for(int j = 0; j < input.length; j++) out[getIndex(input[j])].add(SNK);
		for(int i = 1; i <= t; i++){ //for every transport
			input = br.readLine().split(" ");
			for(int j = 1; j < input.length; j++){
				int stateIdx = getIndex(input[j]);
				int transIdx = i*2;
				out[stateIdx].add(transIdx+1);//state --> transport
				out[transIdx].add(stateIdx+1);//transport --> state
			}
		}
		for(int i = 3; i < out.length; i+=2) out[i].add(i-1);
		while(true){
			Arrays.fill(par, null);
			if(!dfs(0)) break;
			int cur = SNK;
			while(cur != SRC){
				out[par[cur]].remove(cur);
				out[cur].add(par[cur]);
				cur = par[cur];
			}
		}
		System.out.println(out[SNK].size());
	}
	
	static boolean dfs(int start){
		if(start == 1) return true; //found sink
		for(int next : out[start]){
			if(par[next] == null){
				par[next] = start;
				if(dfs(next)) return true;
			}
		}
		return false;
	}
	
	static int getIndex(String name){
		Integer a = index.get(name);
		if(a == null){
			count -= 2;
			a = count;
			index.put(name, a);
		}
		return a;
	}
	
}