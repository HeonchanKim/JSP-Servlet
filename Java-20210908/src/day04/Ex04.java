package day04;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		
		// 변수 선언
		int N;
		
		// Scanner 객체 생성
		Scanner in = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("Enter a positive interger : ");
		N = in.nextInt();
		System.out.println();
		
		for(int i = 1;i <= N;i++)
			System.out.println(i +". Do your best!");
		in.close();
	}

}
