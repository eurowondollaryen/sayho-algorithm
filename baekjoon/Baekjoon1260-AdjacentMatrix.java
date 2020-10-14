import java.util.ArrayList;
import java.util.Scanner;

public class DfsBfsAdjMatrix {
	
	public static void dfs(int start, boolean[][] matrix, boolean[] visit) {
		if(visit[start]) return;
		visit[start] = true;
		System.out.print(start + " ");
		for(int i = 1; i < matrix[start].length; ++i) {
			if(matrix[start][i]) dfs(i, matrix, visit);
		}
	}
	
	public static void bfs(int start, boolean[][] matrix, boolean[] visit) {
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(start);
		visit[start] = true;
		while(!q.isEmpty()) {
			start = q.get(0);
			System.out.print(q.get(0) + " ");
			q.remove(0);
			for(int i = 1; i < matrix[start].length; ++i) {
				if(matrix[start][i] == true && visit[i] == false) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m, v;
		boolean[][] matrix;
		boolean[] visit;
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();
		
		matrix = new boolean[n+1][n+1];
		visit = new boolean[n+1];
		for(int i = 0; i < n+1; ++i) {
			visit[i] = false;
			for(int j = 0; j < n+1; ++j) {
				matrix[i][j] = false;
			}
		}
		
		for(int i = 0; i < m; ++i) {
			int a, b;
			a = scan.nextInt();
			b = scan.nextInt();
			matrix[a][b] = true;
			matrix[b][a] = true;
		}
		
		dfs(v, matrix, visit);
		for(int i = 0; i < visit.length; ++i) {
			visit[i] = false;
		}
		System.out.println();
		bfs(v, matrix, visit);
		
	}
}