import java.util.*;
import java.io.*;
public class Catina {
    static HashMap<String,String> speaks = new HashMap();
    static HashMap<String, Set<String>> understands = new HashMap();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < people; i++){
            Scanner line = new Scanner(sc.nextLine());
            String name = line.next(); String lang = line.next();
            speaks.put(name, lang); 
            if(understands.containsKey(lang)) understands.get(lang).add(name);
            else{
                HashSet<String> temp = new HashSet(); temp.add(name);
                understands.put(lang, temp);
            }
            while(line.hasNext()){
                lang = line.next();
                if(understands.containsKey(lang)) understands.get(lang).add(name);
                else{
                    HashSet<String> temp = new HashSet(); temp.add(name);
                    understands.put(lang, temp);
                }
            }
        }
        for(String name : speaks.keySet()){
            
        }
        
    }
}
