import java.util.Scanner;

public class Baekjoon1712 {
	/* 1712 ���ͺб���
	 * Ǯ�̹� : cx > a + bx�� �Ǵ� x�� ���Ѵ�.
	 * ������� ��� �ʰ��ؾ� �ϹǷ�, ������ 1 ���ϸ� �ȴ�.
	 * ����ܰ��� �ǸŰ��ݺ��� ũ�ų� ���� �� �����Ƿ� ����ó��
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
