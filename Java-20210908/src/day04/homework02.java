package day04;

import java.util.Scanner;

public class homework02 {
	public static void main(String[] args) {
		
		int N;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive integer : ");
		N = in.nextInt();
		System.out.println();
		
		for(int i = 1;i <= N;i++)
			System.out.println(i*3);
				
		in.close();
	}

}
