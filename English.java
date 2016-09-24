import java.io.File;
import java.util.*;
public class English {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> seen = new HashSet<>();
        String output = "";
        while(sc.hasNext()){
            String word = sc.next().toLowerCase();
            if(seen.contains(word)) output += ". ";
            else{
                seen.add(word);
                output += word + " ";
            }
        }
        System.out.println(output);
    }
}
