import java.util.*;
import java.io.*;
public class Torn2 {
    static HashMap<String, Node> nodes = new HashMap<>();
    static boolean path = false;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            String input[] = in.readLine().split(" ");
            if(nodes.get(input[0]) == null){
                Node cur = new Node();
                for(int j = 1; j < input.length; j++) cur.connections.add(input[j]);
                nodes.put(input[0], cur);
            }
            else{
                for(int j = 1; j < input.length; j++) nodes.get(input[0]).connections.add(input[j]);
            }
            for(String s : nodes.get(input[0]).connections){
                if(nodes.get(s) == null){
                    Node cur = new Node();
                    cur.connections.add(input[0]);
                    nodes.put(s, cur);
                }
                else{
                    nodes.get(s).connections.add(input[0]);
                }
            }
        }
        String[] end = in.readLine().split(" ");
        if(nodes.get(end[0]) == null || nodes.get(end[1]) == null )System.out.println("no route found");
        else{
            nodes.get(end[0]).visited = true;
            dfs(end[0], end[1]);
            if(!path) System.out.println("no route found");
        }
    }
    static void dfs(String start, String end){
        Node cur = nodes.get(start);
        if(cur == null) return;
        if(start.equals(end)){
            System.out.println(nodes.get(start).path + end); path = true; return;
        }
        cur.path += start + " ";
        for(String s : cur.connections){
            if(nodes.get(s) == null) return;
            if(!nodes.get(s).visited){
                nodes.get(s).visited = true;
                nodes.get(s).path = cur.path;
                dfs(s, end);
            }
        }
        return;
    }
    static class Node{
        HashSet<String> connections = new HashSet<>();
        String path = "";
        boolean visited = false;
    }
}
