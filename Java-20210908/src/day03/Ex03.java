package day03;

import java.util.Scanner;

// 1. Scanner Ŭ���� import

public class Ex03 {

	public static void main(String[] args) {
		
		// 2. Scanner Ŭ������ ��ü�� ����
		Scanner in = new Scanner(System.in);
		
		// ������Ʈ �޽��� ���
		System.out.print("Enter an integer: ");
		
		// Scanner Ŭ������ nextInt �޼ҵ带 �̿��� ������ �о�´�.
		int num = in.nextInt();
		
		System.out.println("num = " + num);
		System.out.printf("%d + 8 = %d\n" , num, num + 9);
		System.out.printf("%d - 5 = %d\n" , num, num - 5);
		System.out.printf("%d * 3 = %d\n" , num, num * 3);
		
		in.close();
	}

}
