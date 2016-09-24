import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class BigTruck {
	static Map<Integer, Integer>[] edges;
	static int[] items;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		edges = new HashMap[n];
		items = new int[n];
		for(int i = 0; i < n; i++){
			items[i] = Integer.parseInt(line[i]);
			edges[i] = new HashMap<>();
		}
		int e = Integer.parseInt(br.readLine());
		while(e --> 0){
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0])-1;
			int b = Integer.parseInt(line[1])-1;
			int c = Integer.parseInt(line[2]);
			edges[a].put(b, c);
			edges[b].put(a, c);
		}
		Point end = search();
		System.out.println(end == null ? "impossible" : end.dist + " " + end.items);
	}
	
	static Point search(){
		PriorityQueue<Point> pq = new PriorityQueue<>();
		Point[] v = new Point[items.length];
		v[0] = new Point(0, 0, items[0]);
		pq.add(v[0]);
		while(!pq.isEmpty()){
			Point now = pq.poll();
			if(now.cur == items.length -1) return now;
			if(now.compareTo(v[now.cur]) > 0) continue;
			for(Entry<Integer, Integer> e : edges[now.cur].entrySet()){
				int next = e.getKey();
				int dist = now.dist + e.getValue();
				int i = now.items + items[next];
				Point newPt = new Point(next, dist, i);
				if(v[next] == null || newPt.compareTo(v[next]) <= 0){
					v[next] = newPt;
					pq.add(newPt);
				}
			}
		}
		return null;
	}
	
	static class Point implements Comparable<Point>{
		int cur, dist, items;
		
		public Point(int c, int d, int i){
			cur = c; dist = d; items = i;
		}
		@Override
		public int compareTo(Point arg0) {
			if(this.dist == arg0.dist) return -Integer.compare(this.items, arg0.items);
			return Integer.compare(this.dist, arg0.dist);
		}
	}
}
