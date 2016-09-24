import java.io.*;
import java.util.*;
public class GrandpaBernie {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String input[] = in.readLine().split(" ");
            if(map.get(input[0]) == null){
                ArrayList<Integer> a = new ArrayList<>();
                a.add(Integer.parseInt(input[1]));
                map.put(input[0], a);
            }
            else map.get(input[0]).add(Integer.parseInt(input[1]));
        }
        for(ArrayList<Integer> a : map.values()) Collections.sort(a);
        int q = Integer.parseInt(in.readLine());
        for(int i = 0; i < q; i++){
            String input[] = in.readLine().split(" ");
            System.out.println(map.get(input[0]).get(Integer.parseInt(input[1])-1));
        }
    }
}
