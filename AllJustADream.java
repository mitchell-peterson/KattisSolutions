import java.util.*;
import java.io.*;
public class AllJustADream {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        TreeMap<String, Integer> map = new TreeMap<>();
        ArrayList<String> events = new ArrayList<>();
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            String input[] = in.readLine().split(" ");
            if(input[0].equals("E")){
                events.add(input[1]);
                map.put(input[1], events.size()-1);
            }
            else if(input[0].equals("D")){
                int request = Integer.parseInt(input[1]);
                while(request-->0) map.remove(events.remove(events.size()-1));
            }
            else{
                int keep = -1; int delete = events.size(); boolean fail = false;
                for(int j = 2; j < input.length; j++){
                    if(input[j].charAt(0) == '!'){
                        String sub = input[j].substring(1);
                        if(map.keySet().contains(sub)) delete = delete < map.get(sub) ? delete : map.get(sub);//more deletes = smaller index
                    }
                    else{
                        if(!map.keySet().contains(input[j])){
                            fail = true; break;
                        }
                        else{
                            keep = keep > map.get(input[j]) ? keep : map.get(input[j]);//most vulnerable position is greatest position
                        }
                    }
                    if(keep >= delete){
                        fail = true; break;
                    }
                }
                if(delete != events.size() && !fail) out.write((events.size()-delete + " Just A Dream\n").getBytes());
                else if(!fail) out.write(("Yes\n").getBytes());
                else out.write(("Plot Error\n").getBytes());
            }                
        }
        out.flush();
    }
}