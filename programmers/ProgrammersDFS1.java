import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersDFS1 {
	/*
	 * 타겟 넘버
	 * 배열 numbers 내의 숫자들을 더하거나 빼서, sum과 같이 만들 수 있는 방법의 수를 반환
	 * dfs로 구현 시, 재귀 사용
	 * bfs로 구현 시, Queue<int[]> 사용하는 것이 ArrayList보다 빠름.. ArrayList 사용 시 타임아웃 나왔음
	 * Java Queue / ArrayList 비교
	 * */
	private static int cnt;
	public static void print(ArrayList<int[]> a) {
		for(int i = 0; i < a.size(); ++i) {
			System.out.println(a.get(i)[0] + " / " + a.get(i)[1]);
		}
	}
	public static void dfs(int[] numbers, int target, int sum, int index) {
		if(index >= numbers.length) {
			if(target == sum) cnt++;
			return;
		}
		dfs(numbers, target, sum+numbers[index], index+1);
		dfs(numbers, target, sum-numbers[index], index+1);
	}
	public static void bfs(int[] numbers, int target) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] tempa = {0, numbers[0]};
		int[] tempb = {0, -numbers[0]};
		q.add(tempa);
		q.add(tempb);
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[0] == numbers.length-1) {
				if(tmp[1] == target) cnt++;
				continue;
			}
			
			int[] temp1 = {tmp[0]+1, tmp[1]+numbers[tmp[0]+1]};
			int[] temp2 = {tmp[0]+1, tmp[1]-numbers[tmp[0]+1]};
			q.add(temp1);
			q.add(temp2);
		}
	}
	
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		cnt = 0;
		bfs(numbers, target);
		//dfs(numbers, target, 0, 0);
		answer = cnt;
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	/*
	 * 다른 사람이 작성한 깔끔한 코드
	 * class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
	 * */
	
}
