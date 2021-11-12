package day07;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		// Scanner 객체 생성
		Scanner in = new Scanner(System.in);
		
		// 변수 선언
		final int LENGTH = 30;				// 사용자가 입력할 정수들의 최대 개수
		int [] numbers = new int[LENGTH];   // 사용자가 입력한 정수들을 저장한 배열
		int length = 0;                     // 사용자가 입력한 정수들의 개수
		int sum = 0;						// 사용자가 입력한 정수들의 합계
		double average;						// 사용자가 입력한 정수들의 평균
		int aboveAverage = 0;				// 평균보다 더 큰 정수들의 개수
		
		// 반복문을 이용해 사용자에게 최대 30개의 정수를 입력
		for(int i = 0; i < LENGTH; i++) {
			// 사용자 입력
			System.out.print("Enter an integer : ");
			numbers[i] = in.nextInt();
			
			// 사용자가 0을 입력하면 반복문 종료
			if(numbers[i] == 0) break;
			
			// 사용자가 입력한 정수의 개수를 증가
			length++;
			
			// 사용자가 입력한 정수들의 합계 계산
			sum += numbers[i];
		}
		
		// 평균 계산
		average = (double)sum / length;
		
		// 사용자가 입력한 정수들 중에서 평균보다 더 큰 정수들의 개수를 계산
		for(int i = 0; i < length; i++)
			if(numbers[i] > average) aboveAverage++;
		
		// 출력
		System.out.println("\nThe average : " + average);
		System.out.printf("Percentage of numbers above the average : %g%%",
				(double)aboveAverage / length * 100);
		
		
		
		// Scanner 객체 닫기
		in.close();
	}
}
