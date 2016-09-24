import java.util.*;
public class Babel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dic = new HashMap<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(line.equals("")) break;
            String[] temp = line.split(" ");
            dic.put(temp[1], temp[0]);
        }
        while(sc.hasNextLine()){
            String word = sc.nextLine();
            System.out.println(dic.containsKey(word) ? dic.get(word) : "eh");
        }
    }
}
