package day05;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
	
		int n1;
		int n2;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter two positive integer : ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		
		System.out.println();
		
		// ���� n1�� n2 �߿��� ū���� ���� ���� ���
		int max = n1 > n2 ? n1: n2;
		int min = n1 < n2 ? n1: n2;
		
		// �ݺ����� �̿��� ���� min�������� ���� max������ �ڿ������� �հ踦 ���
		
		int sum = 0;
		
		for(int i = min; i <= max; i++)
			sum += i;
			System.out.println("sum = " + sum);
			
		in.close();

	}
}
