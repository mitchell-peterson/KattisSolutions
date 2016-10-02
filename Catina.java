import java.io.*;
import java.util.*;
public class Catina {
    static HashMap<String, HashSet<String>> languages = new HashMap<>();
    static HashMap<String, String> people = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            String[] input = in.readLine().split(" ");
            people.put(input[0], input[1]);
            for(int j = 1; j < input.length; j++){
                HashSet<String> set = languages.get(input[j]);
                if(set == null){
                    languages.put(input[j], new HashSet<String>());
                }
                languages.get(input[j]).add(input[0]);
            }
        }
        int max = 0;
        for(String a : people.keySet()){
            int count = 0; 
            for(String b : people.keySet()){
                if(search(a, b) && search(b, a)) count++;
            }
            if(count > max) max = count;
        }
        System.out.println(n-max);
    }
    static boolean search(String a, String b){
        if(a.equals(b)) return true;
        ArrayList<String> toSearch = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        toSearch.add(a); visited.add(a);
        
        while(!toSearch.isEmpty()){
            ArrayList<String> nextSearch = new ArrayList<>();
            for(String cur : toSearch){
                for(String s : languages.get(people.get(cur))){
                    if(visited.contains(s)) continue;
                    if(b.equals(s)) return true;
                    visited.add(s); nextSearch.add(s);
                }
            }
            toSearch = nextSearch;
        }
        return false;
    }
}
