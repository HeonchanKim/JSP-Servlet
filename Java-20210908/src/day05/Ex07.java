package day05;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		int num;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive integer : ");
		num = in.nextInt();
		
		// 누적해서 곱해가는 변수는 1로 초기화한다.
		long factorial = 1;
		
		for(int i = num; i >= 1; i--)
			factorial *= i;
		
		// 출력
		System.out.printf("Factorial %d = %d\n", num, factorial);
		
		in.close();
	}

}
