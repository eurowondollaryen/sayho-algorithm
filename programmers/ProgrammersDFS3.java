public class ProgrammersDFS3 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/43163
	 * 주어진 문자열을 주어진 배열을 활용해 변환하여 타겟 문자열로 변환하는 문제
	 * 주어진 배열로 변환 시, 변환 문자열과 하나만 달라야 그 문자열로 변환할 수 있다.
	 * 
	 *  배열의 모든 원소에 대해 dfs로 단계를 카운트해가면서 전역변수에 최소값을 넣는다.
	 * */
	private static int count;
	public static boolean isConvertAble(String a, String b) {
		int falseCount = 0;
		if(a.length() != b.length()) return false;
		for(int i = 0; i < a.length(); ++i) {
			if(a.charAt(i) != b.charAt(i)) {
				falseCount++;
				if(falseCount > 1) return false;
			}
		}
		return true;
	}
	public static void dfs(int level, String begin, String target, String[] words, boolean[] visit) {
		if(begin.equals(target)) {
			if(level < count) count = level;
			return;
		}
		for(int i = 0; i < words.length; ++i) {
			if(!visit[i] && isConvertAble(begin, words[i])) {
				visit[i] = true;
				dfs(level+1, words[i], target, words, visit);
				visit[i] = false;
			}
		}
	}
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		count = 999999;
		boolean possible = false;
		for(int i = 0; i < words.length; ++i) {
			if(target.equals(words[i])) {
				possible = true;
				break;
			}
		}
		if(!possible) return 0;
		
		boolean[] visit = new boolean[words.length];
		int level = 0;
		dfs(level, begin, target, words, visit);
		answer = count;
		return answer;
	}
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words1 = {"hot", "dot", "dog", "lot", "log"};
		System.out.println(solution(begin, target, words));
		System.out.println(solution(begin, target, words1));
	}
	
}