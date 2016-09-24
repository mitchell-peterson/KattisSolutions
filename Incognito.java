import java.util.*;
public class Incognito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for(int c = 0; c < cases; c++){
            HashMap<String, HashSet<String>> dis = new HashMap<>();
            int a = Integer.parseInt(sc.nextLine());
            for(int x = 0; x < a; x++){
                Scanner line = new Scanner(sc.nextLine());
                String atr = line.next(); String type = line.next();
                if(dis.get(type) == null){
                    HashSet<String> temp = new HashSet<>();
                    temp.add(atr);
                    dis.put(type, temp);
                }
                else{
                    dis.get(type).add(atr);
                }
            }
            int comb = 1;
            for(String s : dis.keySet()){
                comb *= dis.get(s).size()+1;
            }
            System.out.println(comb-1);
        }
    }
}
