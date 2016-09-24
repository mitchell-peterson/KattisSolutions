import java.util.*;
import java.io.*;
public class Torn {
    static HashSet<String> visited = new HashSet<>();
    static HashMap<String, Node> graph = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n-1; i++){
            Scanner line = new Scanner(sc.nextLine());
            String cur = line.next();
            if(graph.containsKey(cur)){
                while(line.hasNext()){
                    graph.get(cur).cons.add(line.next());
                }
            }
            else{
                Node newNode = new Node();
                while(line.hasNext()){
                    newNode.cons.add(line.next());
                }
                graph.put(cur, newNode);
            }
            for(String s : graph.get(cur).cons){
                if(!graph.containsKey(s)){
                    Node newNode = new Node();
                    newNode.cons.add(cur);
                    graph.put(s, newNode);
                }
                else{
                    graph.get(s).cons.add(cur);
                }
            }
        }
        String start = sc.next(); String end = sc.next();
        visited.add(start);
        if(!dfs(start,end)) System.out.println("no route found");
    }
    static boolean dfs(String start, String end){
        Node cur = graph.get(start);
        if(start.equals(end)){
            System.out.println(cur.output + end); return true;
        }
        cur.output += start + " ";
        for(String s : cur.cons){
            if(!visited.contains(s)){
                graph.get(s).output = cur.output;
                visited.add(s);
                dfs(s,end);
            }
        }
        return false;
    }
    static class Node{
        HashSet<String> cons = new HashSet<>();
        String output = "";
    }
}
