import java.io.*;
import java.util.*;
public class BreakingBad {
    static HashMap<String, HashSet<String>> list = new HashMap<>();
    static HashMap<String, Boolean> visited = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String toBuy[] = new String[n];
        for(int i = 0; i < n; i++){
            String cur = in.readLine();
            list.put(cur, new HashSet<String>());
            toBuy[i] = cur;
            visited.put(cur, null);
        }
        int m = Integer.parseInt(in.readLine());
        for(int i = 0; i < m; i++){
            String input[] = in.readLine().split(" ");
            if(list.get(input[0]) == null){
                list.put(input[0] , new HashSet<String>());
            }
            if(list.get(input[1]) == null){
                list.put(input[1] , new HashSet<String>());
            }
            list.get(input[0]).add(input[1]);
            list.get(input[1]).add(input[0]);
        }
        boolean imp = false;
        for(String s : toBuy){
            if(visited.get(s) == null){//search
                if(!dfs(s, true)){
                    System.out.println("impossible");
                    imp = true; break;
                }
            }
        }
        if(!imp){
            StringBuilder w = new StringBuilder(); StringBuilder j = new StringBuilder();
            for(String s : toBuy){
                if(visited.get(s)) w.append(s).append(" ");
                else j.append(s).append(" ");
            }
            System.out.println(w);
            System.out.println(j);
        }

    }
    static boolean dfs(String s, boolean b){
        if(visited.get(s) != null){
            return visited.get(s) == b;
        }
        visited.put(s, b);
        for(String nbr : list.get(s)){//for all items that are neighbors of this
            if(!dfs(nbr, !b)) return false;            
        }
        return true;
    }
}
