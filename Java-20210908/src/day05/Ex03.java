package day05;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		// ���� ����
		int num;
		
		// Scanner ��ü ����
		
		Scanner in = new Scanner(System.in);
		
		// ����� �Է�
		System.out.print("Enter a positive integer : ");
		num = in.nextInt();
		System.out.println();
		
		// �ݺ��� �̿��� ���� num�������� 1����, 1�� �����ϴ� �ڿ����� ���
		for(int i = num; i >= 1; i--)
			System.out.println(i);
		
		// Scanner ��ü ����
		in.close();
	}

}
