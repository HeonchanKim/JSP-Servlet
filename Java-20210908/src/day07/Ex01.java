package day07;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		// Scanner ��ü ����
		Scanner in = new Scanner(System.in);
		
		// ���� ����
		final int LENGTH = 30;				// ����ڰ� �Է��� �������� �ִ� ����
		int [] numbers = new int[LENGTH];   // ����ڰ� �Է��� �������� ������ �迭
		int length = 0;                     // ����ڰ� �Է��� �������� ����
		int sum = 0;						// ����ڰ� �Է��� �������� �հ�
		double average;						// ����ڰ� �Է��� �������� ���
		int aboveAverage = 0;				// ��պ��� �� ū �������� ����
		
		// �ݺ����� �̿��� ����ڿ��� �ִ� 30���� ������ �Է�
		for(int i = 0; i < LENGTH; i++) {
			// ����� �Է�
			System.out.print("Enter an integer : ");
			numbers[i] = in.nextInt();
			
			// ����ڰ� 0�� �Է��ϸ� �ݺ��� ����
			if(numbers[i] == 0) break;
			
			// ����ڰ� �Է��� ������ ������ ����
			length++;
			
			// ����ڰ� �Է��� �������� �հ� ���
			sum += numbers[i];
		}
		
		// ��� ���
		average = (double)sum / length;
		
		// ����ڰ� �Է��� ������ �߿��� ��պ��� �� ū �������� ������ ���
		for(int i = 0; i < length; i++)
			if(numbers[i] > average) aboveAverage++;
		
		// ���
		System.out.println("\nThe average : " + average);
		System.out.printf("Percentage of numbers above the average : %g%%",
				(double)aboveAverage / length * 100);
		
		
		
		// Scanner ��ü �ݱ�
		in.close();
	}
}
