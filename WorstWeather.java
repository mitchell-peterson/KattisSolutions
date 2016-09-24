import java.io.*;

public class WorstWeather {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		while(true){
			int n = Integer.parseInt(in.readLine());
			int[][] a = new int[n][2]; //a[i] = year, rain
			for(int i = 0; i < n; i++){
				String[] ln = in.readLine().split(" ");
				a[i][0] = Integer.parseInt(ln[0]);
				a[i][1] = Integer.parseInt(ln[1]);
			}
			SegTree st = n == 0 ? null : new SegTree(a);
			int m = Integer.parseInt(in.readLine());
			if(n == 0 && m == 0) break;
			for(int i = 0; i < m; i++){
				String[] ln = in.readLine().split(" ");
				int y = Integer.parseInt(ln[0]);
				int x = Integer.parseInt(ln[1]);
				int rY = st.qRain(y, y);
				int rX = st.qRain(x, x);
				int rZ = st.qRain(y+1, x-1);
				boolean kX = (rX != -1), kY = (rY != -1), kZ = (st.qYrs(y, x) == (x-y)+1);
				if(kX && kY && kZ) out.println( (rY >= rX && rX > rZ) ? "true" :  "false");
				else if(!kX && kY) out.println( (rY > rZ) ? "maybe" :  "false");
				else if(kX && !kY) out.println( (rX > rZ) ? "maybe" :  "false");
				else if(kX && kY) out.println( (rY >= rX && rX > rZ) ? "maybe" :  "false");
				else out.println("maybe");
			}
			if(in.readLine() != null){
				out.println();
			}
		}
		out.flush();
	}
	
	static class SegTree{
		int l, r;
		int maxR, yrs;
		SegTree lc, rc;
		
		public SegTree(int[][] a){ this(a, 0, a.length-1); }
		
		public SegTree(int[][] a, int i, int j){//segtree from i...j inclusive
			if(i == j){//leaf
				l = r = a[i][0];
				maxR = a[i][1];
				yrs = 1;
			}else{
				int mid = (i+j)/2;
				lc = new SegTree(a, i, mid);
				rc = new SegTree(a, mid+1, j);
				maxR = Math.max(lc.maxR, rc.maxR);
				yrs = lc.yrs + rc.yrs;
				l = lc.l;
				r = rc.r;
			}
		}
		
		public int qRain(int i, int j){ //highest rain from i to j
			if(r < i || j < l) return -1;
			if(i <= l && r <= j) return maxR;
			return Math.max(lc.qRain(i, j), rc.qRain(i, j));
		}
		
		public int qYrs(int i, int j){
			if(i > r || j < l) return 0;
			if(i <= l && r <= j) return yrs;
			return lc.qYrs(i, j)+ rc.qYrs(i, j);
		}
	}
}
