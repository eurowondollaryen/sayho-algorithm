## DFS/BFS (백준 1260 문제)
- 인접 행렬과 인접 리스트의 차이점

### 인접 행렬
- 이차원 배열을 활용하는 방식으로, 장점은 구현이 쉽다.
- 연결 여부 확인의 경우 시간 복잡도는 O(1)
- 단점은 노드의 개수가 많아진다면, 모든 노드의 연결노드를 찾으려면, 무방향의 경우 O(V), 방향성의 경우 O(V*V) 의 시간 복잡도가 된다.
- 또한, 연결되지 않은 노드도 표시되므로, 메모리를 많이 잡아먹는다.

### 인접 리스트
- C++에서는 `vector`, Java에서는 `ArrayList<ArrayList<T> >`를 사용하는 것이 편하다. 안쪽의 ArrayList에 해당 노드에 연결된 모든 노드를 push하는 방식
- 장점 : 연결된 edge만 저장하기 때문에, 메모리를 덜 먹는다. 연결 여부를 스캔하는 비용은 O(E)이다. 즉 시간 복잡도가 상대적으로 적다.
- 단점 : 만약 1번 노드와 99번 노드의 연결여부를 확인하려면, 인접 행렬의 경우 O(1)이 소요되겠지만, 인접 리스트의 경우.. 1번, 99번의 ArrayList 전체를 돌며 O(V)가 된다.
- 또한, 문제를 풀 때, 숫자 적은 순서대로 출력해야 하는 경우가 있는데, 이 경우, 인접리스트는 정렬을 해줘야 한다.

### 1. DFS/BFS - 인접 행렬
```java
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
```
### 2. DFS/BFS - 인접 리스트
- 참고 : 인접리스트 구현 시, ArrayList<boolean[]> 으로 adjList를 사용하는 게 더 메모리상 유리
```java
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
```