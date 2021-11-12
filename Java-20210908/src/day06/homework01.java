package day06;

import java.util.Scanner;

public class homework01 {
	public static void main(String[] args) {
		int i;    
		int num;
		int sum = 0;
		
		Scanner in = new Scanner(System.in);
		
		for(i = 1; i <= 30; i++) {
			System.out.print("Enter an integer : ");
			num = in.nextInt();
			sum += num;
			if(num == 0) 
				break;
		}
		
		double average = (double)sum/(i-1);
		
		System.out.println();
		System.out.printf("The average : %f\n", average);
		
				
		in.close();
	}
}
