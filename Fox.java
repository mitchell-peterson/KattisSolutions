import java.util.*;
public class Fox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < cases; i++){
            String rec = sc.nextLine();
            HashSet<String> noises = new HashSet<>();
            while(true){
                String temp = sc.nextLine();
                if(temp.equals("what does the fox say?")) break;
                Scanner line = new Scanner(temp);
                line.next(); line.next();
                noises.add(line.next());
            }
            Scanner recording = new Scanner(rec);
            while(recording.hasNext()){
                String temp = recording.next();
                if(!noises.contains(temp)) System.out.print(temp + " ");
            }
            System.out.println("");
        }
    }
}
