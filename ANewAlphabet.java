import java.io.*;
import java.util.*;

public class ANewAlphabet {
	static String[] dict = {
			"@","8","(","|)","3","#","6","[-]",
			"|", "_|", "|<", "1", "[]\\/[]",
			"[]\\[]", "0", "|D", "(,)", "|Z", "$",
			"']['", "|_|", "\\/", "\\/\\/", "}{", "`/", "2"
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String out = "";
		for(char c : line.toCharArray()){
			if(c >= 'A' && c <= 'Z')
				c = Character.toLowerCase(c);
			if(c >= 'a' && c <= 'z')
				out += dict[c-'a'];
			else out += (c+"");
		}
		System.out.println(out);
	}
}
