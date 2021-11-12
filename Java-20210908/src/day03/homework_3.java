package day03;

import java.util.Scanner;

public class homework_3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the year : ");
		
		int y = in.nextInt();
		
		if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
			System.out.printf("%d is a leap year!", y);			
		}else {
			System.out.printf("%d is NOT a leap year!", y);
		}
		in.close();
	}

}
