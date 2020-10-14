import java.util.Scanner;

public class Baekjoon1712 {
	/* 1712 손익분기점
	 * 풀이법 : cx > a + bx가 되는 x를 구한다.
	 * 매출액이 비용 초과해야 하므로, 나누고 1 더하면 된다.
	 * 생산단가가 판매가격보다 크거나 같을 수 없으므로 예외처리
	 * */
	public static void solution(int a, int b, int c) {
		if(c <= b) {
			System.out.println(-1);
			return;
		} else {
			int result = a / (c-b);
			System.out.println(result+1);
		}
	}
	/*
	public static void main(String[] args) {
		int a, b, c;
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		solution(a, b, c);
	}
	*/
}
