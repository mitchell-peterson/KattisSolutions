import java.io.*;
import java.util.*;
public class EngineeringEnglish {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        StringBuilder out = new StringBuilder();
        while(in.hasNext()){
            String cur = in.next().toLowerCase();
            if(!set.add(cur)) out.append(". ");
            else out.append(cur).append(" ");
        }
        System.out.println(out);
    }
}
