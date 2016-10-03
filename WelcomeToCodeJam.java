import java.io.*;

public class WelcomeToCodeJam {
    static final char[] goal = "welcome to code jam".toCharArray();
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        for(int caseCt = 1; caseCt <= tc; caseCt++){
            char[] test = in.readLine().toCharArray();
            System.out.printf("Case #%d: %04d" + '\n', caseCt, check(0, 0, test));
        }
    }
    
    //i = current choice, g = letter needed
    static int check(int i, int g, char[] test){
        if(g == goal.length) return 1; //if entire word matches
        else if(i == test.length) return 0; //if out of letters to try
        int ct = check(i+1, g, test); //ignore letter
        if(test[i] == goal[g]) ct += check(i+1, g+1, test); //use letter 
        return ct;
    }
}