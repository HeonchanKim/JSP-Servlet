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
			System.out.printf("��������� %d���̰� A��� �Դϴ�.", (korean + english + math) / 3);
		}else if((korean + english + math) / 3 >= 80 && (korean + english + math) / 3 < 90) {
			System.out.printf("��������� %d���̰� B��� �Դϴ�.", (korean + english + math) / 3);
		}else if((korean + english + math) / 3 >= 70 && (korean + english + math) / 3 < 80) {
			System.out.printf("��������� %d���̰� C��� �Դϴ�.", (korean + english + math) / 3);
		}else if((korean + english + math) / 3 >= 60 && (korean + english + math) / 3 < 70) {
			System.out.printf("��������� %d���̰� D��� �Դϴ�.", (korean + english + math) / 3);
		}else {
			System.out.printf("��������� %d���̰� F��� �Դϴ�.", (korean + english + math) / 3);
		};
		in.close();
	}

}
