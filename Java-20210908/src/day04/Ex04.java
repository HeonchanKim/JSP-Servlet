package day04;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		
		// ���� ����
		int N;
		
		// Scanner ��ü ����
		Scanner in = new Scanner(System.in);
		
		// ����� �Է�
		System.out.print("Enter a positive interger : ");
		N = in.nextInt();
		System.out.println();
		
		for(int i = 1;i <= N;i++)
			System.out.println(i +". Do your best!");
		in.close();
	}

}
