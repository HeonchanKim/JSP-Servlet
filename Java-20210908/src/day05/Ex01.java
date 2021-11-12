package day05;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		// 변수 선언
		int num;
		
		// Scanner 객체 생성
		
		Scanner in = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("Enter a positive integer : ");
		num = in.nextInt();
		System.out.println();
		
		// 반복문 이용해 변수 num만큼 '*' 을 출력
		for(int i = 0; i < num; i++)
			System.out.print('*');
		
		// 개행
		System.out.println();
		
		// Scanner 객체 제거
		in.close();
	}

}
