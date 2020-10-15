public class ProgrammersDFS2 {
	/*
	 * https://programmers.co.kr/learn/courses/30/parts/12421
	 * 네트워크
	 * graph가 matrix로 주어지고, 연결된 그래프의 수를 return하면 됨.
	 * 풀이 방법 : 전체 노드를 순회하면서, dfs로 인접한 모든 노드를 방문하여 visited 배열에 체크한다.
	 * 이 때, 시작점에서 매번 카운트해준다.
	 * */
	private static int count;
	public static void dfs(int cur, int[][] computers, boolean[] visited) {
		if(visited[cur]) {
			return;
		}
		visited[cur] = true;
		for(int i = 0; i < computers[cur].length; ++i) {
			if(!visited[i] && computers[cur][i] == 1) {
				dfs(i, computers, visited);
			}
		}
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		count = 0;
		
		boolean[] visited = new boolean[n];
		for(int i = 0; i < visited.length; ++i) visited[i] = false;
		for(int i = 0; i < n; ++i) {
			if(!visited[i]) {
				count++;
				dfs(i, computers, visited);
			}
		}
		answer = count;
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		int[][] computers1 = {{1,1,0},{1,1,1},{0,1,1}};
		int[][] computers2 = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		int[][] computers3 = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		int[][] computers4 = {{1,1,1},{1,1,0},{1,0,1}};
		int n = 3;
		System.out.println(solution(3, computers));
		System.out.println(solution(3, computers1));
		System.out.println(solution(4, computers2));
		System.out.println(solution(4, computers3));
		System.out.println(solution(3, computers4));
	}
}