package day07;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		// Scanner 객체 생성
		Scanner in = new Scanner(System.in);
		
		// 변수 선언
		final int NUM_COINS = 10;   			 // 각 동전의 최대 개수
		int[] coinUnits = {500, 100, 50, 10};    // 동전들의 단위
		int amount;								 // 거스름돈
		int num;								 // 거슬러줄 동전의 개수	
		
		// 사용자 입력
		System.out.print("Enter the amount to be repaid : ");
		amount = in.nextInt();
		System.out.println();
		
		// 반복문을 이용해 500원짜리 동전부터 거슬러준다!
		for (int unit : coinUnits) {
			// 거슬러줄 동전의 개수를 계산
			num = amount / unit;
			
			// 거슬러줄 동전이 있는 경우
			if (num > 0) {
				// 거슬러줄 동전의 최대 개수는 10개이다!
				num = num > NUM_COINS ? NUM_COINS : num;
				
				// 현재 단위의 동전을 거슬러주고 남은 잔액을 계산
				amount -= unit * num;
				
				// 출력
				System.out.printf("%d won coins = %d\n", unit, num);
			}
		}
		
		// Scanner 객체 닫기
		in.close();
	}
}
