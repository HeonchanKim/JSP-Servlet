package day05;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		// ���� ����
		int num;
		
		// Scanner ��ü ����
		
		Scanner in = new Scanner(System.in);
		
		// ����� �Է�
		System.out.print("Enter a positive integer : ");
		num = in.nextInt();
		System.out.println();
		
		// �ݺ��� �̿��� ���� num��ŭ 3�� ����� ���
		for(int i = 1; i <= num; i++)
			System.out.println(i*3);
		
		// Scanner ��ü ����
		in.close();
	}

}
