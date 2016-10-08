import java.util.*;
import java.io.*;

public class grille {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] lines = new String[n];
		for (int i = 0; i < n; i++) {
			lines[i] = br.readLine();
		}
		Grill grill = new Grill(lines, n);
		if (!grill.check()){
			System.out.println("invalid grille");
			return;
		}
		String raw = br.readLine();
		char[][] grid = new char[n][n];

		int count = 0;
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grill.mask[i][j]) {
						grid[i][j] = raw.charAt(count++);
					}
				}
			}
			grill.rotate();
		}
		String out = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				out += grid[i][j];
			}
		}
		System.out.println(out);
	}

	static class Grill {
		int n;
		boolean[][] mask;

		Grill(String[] raw, int n) {
			this.n = n;
			this.mask = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String line = raw[i];
				for (int j = 0; j < n; j++) {
					mask[i][j] = line.charAt(j) == '.';
				}
			}
		}

		boolean check() {
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mask[i][j])
						count++;
				}
			}
			if (count != (n * n) / 4)
				return false;
			boolean[][] temp = new boolean[n][n];
			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (mask[i][j])
							temp[i][j] = true;
					}
				}
				this.rotate();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!temp[i][j])
						return false;
				}
			}
			return true;

		}

		private void rotate() {
			boolean[][] buff = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					buff[i][j] = mask[n - 1 - j][i];
				}
			}
			mask = buff;
		}
	}
}
