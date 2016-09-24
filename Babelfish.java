import java.util.*;
public class Babelfish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dic = new HashMap<>();
        while(true){
            Scanner line = new Scanner(sc.nextLine());
            if(line.hasNext()){
                String temp = line.next();
                dic.put(line.next(), temp);
            }
            else{
                break;
            }
        }
        while(sc.hasNext()){
            String word = sc.nextLine();
            if(dic.containsKey(word)){
                System.out.println(dic.get(word));
            }
            else{
                System.out.println("eh");
            }
        }
    }
}
