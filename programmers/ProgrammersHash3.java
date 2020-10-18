import java.util.HashMap;

public class ProgrammersHash3 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42578
	 * 
	 * 위장
	 * 경우의 수 -1(아무것도 안 입는 경우) 제외하여 return
	 * 
	 * */
	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < clothes.length; ++i) {
			Integer val = map.get(clothes[i][1]);
			if(val == null) {
				map.put(clothes[i][1], 2);
			}
			else {
				map.put(clothes[i][1], val+1);
			}
		}
		for(String key : map.keySet()) {
			answer *= map.get(key);
		}
		return answer-1;
	}
	/*
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes1 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes));
		System.out.println(solution(clothes1));
	}
	*/
}
