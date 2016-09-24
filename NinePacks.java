import java.io.*;
import java.util.*;

public class NinePacks {
	static int MAX_TOT = 100001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] hotdogs = make_array(br.readLine().split(" "));
		int[] buns = make_array(br.readLine().split(" "));
		if(hotdogs.length == 0 || buns.length == 0){
			System.out.println("impossible");
			System.exit(0);
		}
		Integer[] htPack = splitPar(hotdogs);
		Integer[] bPack = splitPar(buns);
		Integer least = Integer.MAX_VALUE;
		for(int i = 1; i < MAX_TOT; i++){
			if(htPack[i] == null || bPack[i] == null) continue;
			//System.out.printf("%d hd to %d buns\n", htPack[i], bPack[i]);
			least = Math.min(least, htPack[i] + bPack[i]);
		}
		System.out.println(least == Integer.MAX_VALUE ? "impossible" : least);	
	}
	
	static int[] make_array(String[] data){
		int[] arr = new int[Integer.parseInt(data[0])];
		for(int i = 1; i <= arr.length; i++){
			arr[i-1] = Integer.parseInt(data[i]);
		}
		return arr;	
	}
	
	static Integer[] splitPar(int[] arr){
		Integer[][] dp = new Integer[arr.length][MAX_TOT];
		dp[0][0] = 0;
		dp[0][arr[0]] = 1;
		for(int pack = 0; pack < arr.length-1; pack++){
			for(int tot = 0; tot < MAX_TOT; tot++){
				if(dp[pack][tot] == null) continue;
				if(dp[pack+1][tot] == null || dp[pack][tot] < dp[pack+1][tot] )
					dp[pack+1][tot] = dp[pack][tot];
				int newTot = tot + arr[pack+1];
				if(dp[pack+1][newTot] == null || dp[pack+1][newTot] > dp[pack][tot])
					dp[pack+1][newTot] = dp[pack][tot]+1;
			}
		}
		return dp[arr.length-1];
	}
}
