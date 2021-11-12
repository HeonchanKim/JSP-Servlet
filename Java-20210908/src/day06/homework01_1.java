package day06;

import java.util.Scanner;

public class homework01_1 {

	public static void main(String[] args) {
		
		int i;
		int num;
		int[] numbers = new int[30];  
		int sum = 0;
		
		Scanner in = new Scanner(System.in);
		
		for(i = 0; i <= numbers.length; i++) {
			System.out.print("Enter an integer : ");
			num = in.nextInt();
			numbers[i] = num;
			sum += num;
			if(num == 0) 
				break;
		}
		
		double average = (double)sum/i;
		System.out.println();
		System.out.printf("The average : %f\n", average);
		for(int j = 0; j < i; j++)
			if(numbers[j] > average)
				System.out.println(j);
		// System.out.print("Percentage of numbers above the average : " +  + "%");
		
		in.close();
	}

}
