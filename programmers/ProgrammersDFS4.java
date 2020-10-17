import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProgrammersDFS4 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/43164
	 * 
	 * ArrayList sort : https://includestdio.tistory.com/35
	 * Sorting String lexicographically : https://www.geeksforgeeks.org/compare-two-strings-lexicographically-in-java/
	 * 
	 * */
	private static ArrayList<ArrayList<String> > totalRoute;
	
	public static int lexico(String a, String b) {
		int len = a.length() < b.length() ? a.length() : b.length();
		for(int i = 0; i < len; ++i) {
			if(a.charAt(i) < b.charAt(i)) return -1;
			else if(a.charAt(i) > b.charAt(i)) return 1;
		}
		return 0;
	}
	
	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		boolean[] used = new boolean[tickets.length];
		ArrayList<String> route = new ArrayList<String>();
		totalRoute = new ArrayList<ArrayList<String> >();
		
		for(int i = 0; i < used.length; ++i ) {
			used[i] = false;
		}
		
		dfs(tickets, used, "ICN", 0, route);
		//sort route list
		Collections.sort(totalRoute, new Comparator() {
			@Override
			public int compare(Object a, Object b) {
				for(int i = 0; i < ((ArrayList<String>) a).size(); ++i) {
					int cp = lexico(((ArrayList<String>) a).get(i), ((ArrayList<String>) b).get(i));
					if(cp != 0) return cp;
				}
				return 0;
			}
		});
		//get first route
		ArrayList<String> tmp = totalRoute.get(0);
		answer = new String[tmp.size()];
		for(int i = 0; i < tmp.size(); ++i) {
			answer[i] = tmp.get(i);
		}
		
		return answer;
	}
	
	public static void dfs(String[][] tickets, boolean[] used, String current, int level, ArrayList<String> route) {
		route.add(current);
		if(level == tickets.length) {
			totalRoute.add(route);
			return;
		}
		for(int i = 0; i < tickets.length; ++i) {
			if(!used[i] && tickets[i][0].equals(current)) {
				used[i] = true;
				ArrayList<String> na = new ArrayList<String>();
				for(int j = 0; j < route.size(); ++j) {
					na.add(route.get(j));
				}
				dfs(tickets, used, tickets[i][1], level+1, na);
				used[i] = false;
			}
		}
	}
	
	public static void print(String[] a) {
		for(int i = 0; i < a.length; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	/*
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		print(solution(tickets));
		print(solution(tickets1));
	}
	*/
	
}