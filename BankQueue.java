import java.util.*;
public class BankQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        ArrayList<ArrayList<Person>> out = new ArrayList<>();
        for(int i = 0; i < t; i++) out.add(new ArrayList<Person>());
        Person[] q = new Person[n];
        for(int i = 0; i < n; i++){
            q[i] = new Person(in.nextInt(), in.nextInt());
        }
        Arrays.sort(q);
        for(int i = 0; i < t; i++){
            for(int j = 0; j < n; j++){
                if(q[j].time >= i) out.get(i).add(q[j]);
            }
        }
        for(int i = 0; i < t; i++) Collections.sort(out.get(i));
        int sum = 0;
        HashSet<Person> used = new HashSet<>();
        for(int i = t-1; i >=0 ; i--){
            ArrayList<Person> cur = out.get(i);
            for(int j = 0; j < cur.size(); j++){
                if(!used.contains(cur.get(j))){
                    sum += cur.get(j).money;
                    used.add(cur.get(j));
                    break;
                }
            }
        }
        System.out.println(sum);
    }
    static class Person implements Comparable<Person>{
        int money; int time;
        Person(int x, int y){
            this.money = x; this.time = y;
        }

        @Override
        public int compareTo(Person t) {
            return Integer.compare(t.money, this.money);
        }
        
    }
}