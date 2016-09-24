import java.io.*;
import java.util.*;

public class QuickEstimate {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases  = Integer.parseInt(br.readLine());
		for(int i = 0; i < cases; i++){
			String line = br.readLine();
			int first = 0;
			while(first < line.length() && line.charAt(first) == '0') first++;
			System.out.println(Math.max(line.length()-first, 1));
		}
	}
}
