package day04;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		// ���� ����
		int month;
		
		// Scanner ��ü ����
		Scanner in = new Scanner(System.in);
		
		// ����� �Է�
		System.out.print("Enter the month as a number : ");
		month = in.nextInt();
		
		// switch ������ �̿��� ���� month�� ���� ���
		switch (month) {
		case 1: 
		case 3: 
		case 5: 
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.print("The month has 31 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.print("The month has 30 days");
			break;
		case 2:
			System.out.print("The month has 28 days");
			break;
		default:
			System.out.print("[ERROR]");
			break;
		}
		
		
		
		
		in.close();
	}

}
