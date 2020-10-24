import java.util.Scanner;

public class Baekjoon14719 {
	/*
	 * https://www.acmicpc.net/problem/14719
	 * 빗물
	 * 2020.10.24 시행한 nhn 코딩테스트 수록 문제와 유사
	 * < solution >
	 * 2중for문으로 순회하면서
	 * 1. 인접한 녀석은 skip
	 * 2. 두 index 사이에 둘 중 작은 녀석보다 큰 녀석이 존재하면 break. (i+1)
	 * 3. 그게 아니라면 물을 채우고, count에 채운 만큼 더한다.
	 * */
	public static boolean riseCheck(int[] blocks, int indexa, int indexb) {
		int lena = blocks[indexa];
		int lenb = blocks[indexb];
		int less = lena < lenb ? lena : lenb;
		for(int i = indexa+1; i < indexb; ++i) {
			if(less < blocks[i]) return true;
		}
		return false;
	}
	public static int pour(int[] blocks, int indexa, int indexb) {
		int lena = blocks[indexa];
		int lenb = blocks[indexb];
		int less = lena < lenb ? lena : lenb;
		int count = 0;
		for(int i = indexa+1; i < indexb; ++i) {
			count += (less - blocks[i]);
			blocks[i] = less;
		}
		return count;
	}
	public static int solution(int[] blocks) {
		int count = 0;
		for(int i = 0; i < blocks.length; ++i) {
			for(int j = i + 2; j < blocks.length; ++j) {
				if(!riseCheck(blocks, i, j)) {
					count += pour(blocks, i, j);
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int h, w;
		int[] blocks;
		Scanner scan = new Scanner(System.in);
		h = scan.nextInt();
		w = scan.nextInt();
		blocks = new int[w];
		for(int i = 0; i < w; ++i) {
			blocks[i] = scan.nextInt();
		}
		System.out.println(solution(blocks));
	}
}
