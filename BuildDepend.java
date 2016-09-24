import java.io.*;
import java.util.*;
public class BuildDepend {
    static HashMap<String, Node> map = new HashMap<>();
    static ArrayList<String> stack = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            String line[] = in.readLine().split(" ");
            String name = line[0].substring(0, line[0].length()-1);
            Node cur, temp;
            if(map.get(name) == null) cur = new Node();
            else cur = map.get(name);
            for(int j = 1; j < line.length; j++){//map creation wonky for depOf
                cur.depOn.add(line[j]);
                if(map.get(line[j]) == null) temp = new Node();
                else temp = map.get(line[j]);
                temp.depOf.add(name);                
                map.put(line[j], temp);
            }
            map.put(name, cur);
        }
        String file = in.readLine();
        map.get(file).visited = true;
        dfs(file);
        for(int i = stack.size()-1; i > -1; i--){
            System.out.println(stack.get(i));
        }
    }
    static void dfs(String file){
        for(String s : map.get(file).depOf){
            if(map.get(s).visited) continue;
            else{
                map.get(s).visited = true;
                dfs(s); 
            }
        }
        stack.add(file);
    }
    static class Node{
        HashSet<String> depOn = new HashSet<>();
        HashSet<String> depOf = new HashSet<>();
        boolean visited = false;
    }
}
