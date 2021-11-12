package day03;

import java.util.Scanner;

public class homework_1 {

	public static void main(String[] args) {
		
		// 1번연습문제
		Scanner in = new Scanner(System.in);
		System.out.print("Enter two integgers: ");
		
		int N1 = in.nextInt();
		int N2 = in.nextInt();
		
		System.out.println("N1 = " + N1 + ", N2 = " + N2);
		if(N2 % N1 == 0) {
			System.out.printf("%d is a factor of %d.", N1, N2);			
		}else if(N1 % N2 == 0) {
			System.out.printf("%d is a multiple of %d.", N1, N2);
		}
		else{
			System.out.printf("%d is neither a multiple of %d nor a factor.", N1, N2);
		}
		// -----------------------------------------------------------------------------
		
		in.close();
		
	}

}
