package day03;

import java.util.Scanner;

// 1. Scanner 클래스 import

public class Ex03 {

	public static void main(String[] args) {
		
		// 2. Scanner 클래스의 객체를 생성
		Scanner in = new Scanner(System.in);
		
		// 프람프트 메시지 출력
		System.out.print("Enter an integer: ");
		
		// Scanner 클래스의 nextInt 메소드를 이용해 정수를 읽어온다.
		int num = in.nextInt();
		
		System.out.println("num = " + num);
		System.out.printf("%d + 8 = %d\n" , num, num + 9);
		System.out.printf("%d - 5 = %d\n" , num, num - 5);
		System.out.printf("%d * 3 = %d\n" , num, num * 3);
		
		in.close();
	}

}
