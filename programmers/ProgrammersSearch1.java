import java.util.ArrayList;
import java.util.Arrays;

public class ProgrammersSearch1 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42840
	 * 
	 * 완전탐색 - 모의고사
	 * 
	 * 1. 인원은 총 3명이므로, 3명이 각각 맞춘 문제를 count하기 위한 int[3]을 선언
	 * 2. 맞출 때 마다 1씩더한다.
	 * 3. 순회하면서 max값 찾는다.
	 * 4. 순회하면서 max값과 동일한 놈의 index+1을 result ArrayList에 넣는다.
	 * 
	 * */
	
	public static int[] ArrayListToArray(ArrayList<Integer> al) {
		int[] a = new int[al.size()];
		for(int i = 0; i < al.size(); ++i) {
			a[i] = al.get(i);
		}
		return a;
	}
	public static int[] solution(int[] answers) {
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] cnt = {0, 0, 0};
		int max = 0;
		for(int i = 0; i < answers.length; ++i) {
			if(arr1[i%5] == answers[i]) cnt[0]++;
			if(arr2[i%8] == answers[i]) cnt[1]++;
			if(arr3[i%10] == answers[i]) cnt[2]++;
		}
		
		for(int i = 0; i < cnt.length; ++i) {
			if(cnt[i] > max) max = cnt[i];
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < cnt.length; ++i) {
			if(max == cnt[i]) {
				result.add(i+1);
			}
		}
		return ArrayListToArray(result);
	}
	
	public static void print(int[] a) {
		for(int i = 0; i < a.length; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		int[] answers1 = {1,3,2,4,2};
		
		print(solution(answers));
		print(solution(answers1));
	}
}