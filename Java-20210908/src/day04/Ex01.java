package day04;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		// ���� ����
		int korean, english, math;
		double average;
		char grade;
		
		// Scanner ��ü ����
		Scanner in = new Scanner(System.in);
		
		// ����� �Է�
		System.out.print("Enter the score of korean : ");
		korean = in.nextInt();
		System.out.print("Enter the score of english : ");
		english = in.nextInt();
		System.out.print("Enter the score of math : ");
		math = in.nextInt();
		System.out.println();
		
		// ��� ���
		average = (double)(korean + english + math) / 3;
		
		// ��� ���
		if (average >= 90) grade = 'A';
		else if(average >= 80) grade = 'B';
		else if(average >= 70) grade = 'C';
		else if(average >= 60) grade = 'D';
		else grade = 'F';
		
		// ���
		System.out.println("Average : " + average);
		System.out.println("grade : " + grade);
		
		// ������� �ý��� �ڿ��� ����� ���� �ݵ��� �Ѵ�!
		in.close();
	}

}
