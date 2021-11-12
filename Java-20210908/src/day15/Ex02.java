package day15;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		// 변수 선언
		int n1, n2;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Dividend: ");
		n1 = in.nextInt();
		
		System.out.print("Divisor: ");
		n2 = in.nextInt();
		
		// 예외(exception)
		// -> 프로그램이 실행되는 도중에 발생하는 문제 상황
		
		// 예외 처리(exception handling)
		// -> 프로그램이 실행되는 도중 발생할 수 있는 예외를 대비해서 코드를 작성하는 것
		// -> 프로그램의 비정상적인 종료를 방지하고, 정상적인 실행 상태를 유지하기 위해 사용
		// -> try-catch 구문을 이용
		
		try {
			System.out.println("n1 / n2 = " + n1 / n2);
		}
		catch (Exception e) {
			System.out.println("Exception occurs!");
		}
		finally {
			System.out.println("Finally block!");
		}
		
		in.close();
	}
}
