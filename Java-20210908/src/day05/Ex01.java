package day05;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		// ���� ����
		int num;
		
		// Scanner ��ü ����
		
		Scanner in = new Scanner(System.in);
		
		// ����� �Է�
		System.out.print("Enter a positive integer : ");
		num = in.nextInt();
		System.out.println();
		
		// �ݺ��� �̿��� ���� num��ŭ '*' �� ���
		for(int i = 0; i < num; i++)
			System.out.print('*');
		
		// ����
		System.out.println();
		
		// Scanner ��ü ����
		in.close();
	}

}
