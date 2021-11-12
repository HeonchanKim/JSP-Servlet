package day03;

import java.util.Scanner;

public class homework_4 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the korean score : ");
		System.out.println("Enter the english score : ");
		System.out.println("Enter the math score : ");
		
		int korean = in.nextInt();
		int english = in.nextInt();
		int math = in.nextInt();
		
		if((korean + english + math) / 3 >= 90 && (korean + english + math) / 3 <= 100) {
			System.out.printf("평균점수는 %d점이고 A등급 입니다.", (korean + english + math) / 3);
		}else if((korean + english + math) / 3 >= 80 && (korean + english + math) / 3 < 90) {
			System.out.printf("평균점수는 %d점이고 B등급 입니다.", (korean + english + math) / 3);
		}else if((korean + english + math) / 3 >= 70 && (korean + english + math) / 3 < 80) {
			System.out.printf("평균점수는 %d점이고 C등급 입니다.", (korean + english + math) / 3);
		}else if((korean + english + math) / 3 >= 60 && (korean + english + math) / 3 < 70) {
			System.out.printf("평균점수는 %d점이고 D등급 입니다.", (korean + english + math) / 3);
		}else {
			System.out.printf("평균점수는 %d점이고 F등급 입니다.", (korean + english + math) / 3);
		};
		in.close();
	}

}
