import java.io.*;

public class Sylvester {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = Integer.parseInt(in.readLine()); tc --> 0;){
            String[] line = in.readLine().split(" ");
            long n = Long.parseLong(line[0]);
            long x = Long.parseLong(line[1]);
            long y = Long.parseLong(line[2]);
            int w = Integer.parseInt(line[3]);
            int h = Integer.parseInt(line[4]);
            for(int dy = 0; dy < h; dy++){
                for(int dx = 0; dx < w; dx++){
                    System.out.print(coor(n, x+dx, y+dy) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }   
    }
    
    //Returns the coordinate i,j of h(n)
    //null if no coordinate
    /**
     *   0  1
     * 0 q1 q2
     * 1 q3 q4
     */
    //This could also be done by iteration (decrease and conquer) 
    static int coor(long n, long x, long y){
        if(n == 1) return 1;
        int q = 0;//q1 = 00, q2 = 01, q3 = 10, q4 = 11 
        if(x >= (n>>1)){//if x is over n/2, it's in the right row
            x -= (n>>1); //x offset by n/2
            q = (q^0b01);//set row
        }
        if(y >= (n>>1)){//if y is over n/2, it's in the bottom row
            y -= (n>>1); //y offset by n/2
            q = (q^0b10);//set column
        }
        return (q != 0b11) ? coor(n>>1, x ,y) : -coor(n>>1, x ,y);//if q4, negate
    }
}
