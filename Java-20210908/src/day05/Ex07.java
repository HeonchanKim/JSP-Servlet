package day05;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		int num;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive integer : ");
		num = in.nextInt();
		
		// �����ؼ� ���ذ��� ������ 1�� �ʱ�ȭ�Ѵ�.
		long factorial = 1;
		
		for(int i = num; i >= 1; i--)
			factorial *= i;
		
		// ���
		System.out.printf("Factorial %d = %d\n", num, factorial);
		
		in.close();
	}

}
