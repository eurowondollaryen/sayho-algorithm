import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 참고 사이트
 * 1. start - destination까지의 path 수를 세는 것
 * https://www.geeksforgeeks.org/find-paths-given-source-destination/
 * */
public class DfsBfsAdjList {
	
	public static void dfs(int start, ArrayList<ArrayList<Integer> > adjList, boolean[] visit) {
		if(visit[start]) return;
		System.out.print(start + " ");
		visit[start] = true;
		for(int i = 0; i < adjList.size(); ++i) {
			if(start == adjList.get(i).get(0)) {
				int target = adjList.get(i).get(1);
				if(!visit[target]) dfs(target, adjList, visit);
			}
		}
	}
	public static void bfs(int start, ArrayList<ArrayList<Integer> > adjList, boolean[] visit) {
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(start);
		visit[start] = true;
		while(!q.isEmpty()) {
			start = q.get(0);
			System.out.print(q.get(0) + " ");
			q.remove(0);
			for(int i = 0; i < adjList.size(); ++i) {
				if(adjList.get(i).get(0) == start && !visit[adjList.get(i).get(1)]) {
					q.add(adjList.get(i).get(1));
					visit[adjList.get(i).get(1)] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		int n, m, v;
		ArrayList<ArrayList<Integer> > adjList = new ArrayList<ArrayList<Integer> >();
		Scanner scan = new Scanner(System.in);
		boolean[] visit;
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();
		visit = new boolean[n+1];
		for(int i = 0; i < n+1; ++i) {
			visit[i] = false; 
		}
		//sort adjList first
		for(int i = 0; i < m; ++i) {
			int a, b;
			a = scan.nextInt();
			b = scan.nextInt();
			ArrayList<Integer> inp = new ArrayList<Integer>();//양방향을 위해 2회 add
			inp.add(a);
			inp.add(b);
			adjList.add(inp);
			ArrayList<Integer> inp1 = new ArrayList<Integer>();
			inp1.add(b);
			inp1.add(a);
			adjList.add(inp1);
		}
		
		//sort adjList ascend
		adjList.sort(new Comparator<ArrayList<Integer> >() {
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				int alen = a.size();
				int blen = b.size();
				int len = alen < blen ? alen : blen;
				for(int i = 0; i < len; ++i) {
					if(a.get(i) < b.get(i)) return -1;
					else if(a.get(i) > b.get(i)) return 1;
				}
				return 0;
			}
		});
		
		dfs(v, adjList, visit);
		for(int i = 0; i < n+1; ++i) {
			visit[i] = false; 
		}
		System.out.println();
		bfs(v, adjList, visit);
	}
}