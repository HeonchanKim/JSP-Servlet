package day04;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		// 변수 선언
		int korean, english, math;
		double average;
		char grade;
		
		// Scanner 객체 생성
		Scanner in = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("Enter the score of korean : ");
		korean = in.nextInt();
		System.out.print("Enter the score of english : ");
		english = in.nextInt();
		System.out.print("Enter the score of math : ");
		math = in.nextInt();
		System.out.println();
		
		// 평균 계산
		average = (double)(korean + english + math) / 3;
		
		// 등급 계산
		if (average >= 90) grade = 'A';
		else if(average >= 80) grade = 'B';
		else if(average >= 70) grade = 'C';
		else if(average >= 60) grade = 'D';
		else grade = 'F';
		
		// 출력
		System.out.println("Average : " + average);
		System.out.println("grade : " + grade);
		
		// 열어놓은 시스템 자원은 사용한 다음 닫도록 한다!
		in.close();
	}

}
