package day03;

import java.util.Scanner;

public class homework_2 {

	public static void main(String[] args) {
		
		// 2번 연습문제
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter hourly wage : ");
		System.out.println("Enter the hours worked : ");
		System.out.println("Enter the number of days in this month : ");
			
		int W = in.nextInt();
		int H = in.nextInt();
		int D = in.nextInt();
				
		System.out.println("W = " + W + " H = " + H + " D = " + D);
		System.out.printf("This month\'s salary is %d won.", W*H*D);

		in.close();
	}

}
