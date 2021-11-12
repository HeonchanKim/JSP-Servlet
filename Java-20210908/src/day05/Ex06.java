package day05;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
	
		int n1;
		int n2;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter two positive integer : ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		
		System.out.println();
		
		// 변수 n1과 n2 중에서 큰값과 작은 값을 계산
		int max = n1 > n2 ? n1: n2;
		int min = n1 < n2 ? n1: n2;
		
		// 반복문을 이용해 변수 min에서부터 변수 max까지의 자연수들의 합계를 계산
		
		int sum = 0;
		
		for(int i = min; i <= max; i++)
			sum += i;
			System.out.println("sum = " + sum);
			
		in.close();

	}
}
