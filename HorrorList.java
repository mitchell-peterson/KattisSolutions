import java.io.*;
import java.util.*;
public class HorrorList {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int l = Integer.parseInt(input[2]);
        
        input = in.readLine().split(" ");
        HashSet<Integer> horror = new HashSet<>();
        for(int i = 0; i < h; i++){
            horror.add(Integer.parseInt(input[i]));
        }
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i = 0; i < l; i++){
            input = in.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if(graph.get(a) == null) graph.put(a, new HashSet<Integer>());
            if(graph.get(b) == null) graph.put(b, new HashSet<Integer>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] dist = new int[n]; 
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> toSearch = new LinkedList<>();
        for(int i : horror){
            dist[i]++; toSearch.add(i); visited.add(i);
        }
        LinkedList<Integer> nextSearch = new LinkedList<>();
        while(!toSearch.isEmpty()){
            int cur = toSearch.poll();
            if(graph.get(cur) == null) continue;
            for(Integer i : graph.get(cur)){
                if(!visited.contains(i)){
                    dist[i] += dist[cur]+1;
                    visited.add(i); nextSearch.add(i);
                }
            }
            if(toSearch.isEmpty()){
                toSearch = nextSearch; 
                nextSearch = new LinkedList<>();
            }
        }
        int max = 0; int out = -1;
        for(int i = 0; i < dist.length; i++){
            if(dist[i]==0){
                out = i; break;
            } 
            else if(dist[i] > max){
                max = dist[i]; out = i;
            }
        }
        System.out.println(out);
    }
}
