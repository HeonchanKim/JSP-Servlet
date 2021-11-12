package day05;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		// 변수 선언
		int num;
		
		// Scanner 객체 생성
		
		Scanner in = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("Enter a positive integer : ");
		num = in.nextInt();
		System.out.println();
		
		// 반복문 이용해 변수 num에서부터 1까지, 1씩 감소하는 자연수를 출력
		for(int i = num; i >= 1; i--)
			System.out.println(i);
		
		// Scanner 객체 제거
		in.close();
	}

}
