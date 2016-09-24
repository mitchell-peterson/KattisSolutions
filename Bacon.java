import java.util.*;
public class Bacon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int customers = Integer.parseInt(sc.nextLine());
            if(customers == 0) break;
            TreeMap<String, TreeSet<String>> orders = new TreeMap<>();//food to people
            for(int i = 0; i < customers; i++){
                Scanner line = new Scanner(sc.nextLine());
                String person = line.next();
                while(line.hasNext()){
                    String food = line.next();
                    if(orders.get(food) == null){
                        TreeSet<String> people = new TreeSet<>();
                        people.add(person);
                        orders.put(food, people);
                    }
                    else orders.get(food).add(person);
                }
            }
            for(String food : orders.keySet()){
                    System.out.print(food + " ");
                    for(String p : orders.get(food)){
                        System.out.print(p + " ");
                    }
                    System.out.println("");
            }
            System.out.println("");
        }
    }
}