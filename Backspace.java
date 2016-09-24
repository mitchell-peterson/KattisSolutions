import java.util.*;
import java.io.*;
public class Backspace {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '<'){
                output.deleteCharAt(output.length()-1);
            }
            else output.append(input.charAt(i));
        }
        System.out.println(output);
    }
}
