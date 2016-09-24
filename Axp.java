import java.util.*;
public class Axp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next().replaceAll("([A-Za-z])\\1+", "$1"));
    }
}
