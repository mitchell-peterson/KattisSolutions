import java.io.*;
import java.util.*;
public class AddingWords {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> vars = new HashMap<>();
        HashMap<Integer, String> vals = new HashMap<>();
        while(true){
            String command = in.readLine();
            if(command == null) break;
            String params[] = command.split(" ");
            if(params[0].equals("def")){
                Integer temp = vars.put(params[1], Integer.parseInt(params[2]));
                if(vals.containsKey(temp)) vals.remove(temp);//remove possible old number vals
                vals.put(Integer.parseInt(params[2]), params[1]);
            }
            else if(params[0].equals("calc")){
                int val = 0; boolean sub = false; boolean unknown = false;
                for(int i = 1; i < params.length; i++){
                    if(params[i].equals("=") || unknown){
                        for(int j = 1; j < params.length; j++){
                            System.out.print(params[j] + " ");
                        }
                        if(unknown || !vals.containsKey(val)){
                            System.out.println("unknown"); break;
                        }
                        else{
                            System.out.println(vals.get(val)); break;
                        }
                    }
                    else if(params[i].equals("+")) sub = false;
                    else if(params[i].equals("-")) sub = true;
                    else{
                        if(vars.containsKey(params[i])){
                            if(sub){
                                val -= vars.get(params[i]); sub = false;
                            }
                            else val+= vars.get(params[i]);
                        }
                        else unknown = true;
                    }
                }
            }
            else{
                vars = new HashMap<>();
                vals = new HashMap<>();
            }
        }
    }
}