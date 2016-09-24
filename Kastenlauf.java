import java.io.*;
import java.util.*;
public class Kastenlauf {
    public static void main(String[] args) throws Exception{        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        while(cases-->0){
            int stores = Integer.parseInt(in.readLine());
            Loc locs[] = new Loc[stores+2];
            for(int i = 0; i < locs.length; i++){
                String line[] = in.readLine().split(" ");
                locs[i] = new Loc(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            }
            LinkedList<Loc> toSearch = new LinkedList<>();
            for(int i = 0; i < locs.length; i++){
                for(int j = i+1; j < locs.length; j++){
                    if(locs[i].distance(locs[j]) <= 1000){
                        locs[i].cons.add(locs[j]);
                        locs[j].cons.add(locs[i]);
                    }
                }
            }
            HashSet<Loc> visited = new HashSet<>();
            toSearch.add(locs[0]); visited.add(locs[0]); boolean happy = false;
            while(!toSearch.isEmpty()){
                Loc cur = toSearch.poll();
                if(cur.distance(locs[locs.length-1])==0){
                    happy = true; break;
                }
                for(Loc l : cur.cons) {
                    if(!visited.contains(l)) {
                        toSearch.add(l); visited.add(cur);
                    }
                }
            }
            System.out.println(happy ? "happy" : "sad");
        }
    }
    static class Loc{
        int x; int y; HashSet<Loc> cons = new HashSet<>();
        Loc(int a, int b){
            this.x = a; this.y = b;
        }
        int distance(Loc l){
            return Math.abs(l.x-this.x) + Math.abs(l.y-this.y);
        }
    }
}
