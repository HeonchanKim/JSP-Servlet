package day07;

public class Ex02 {

	public static void main(String[] args) {
		
		// 변수 선언
		int[] numbers = {1, 3, 4, 2, 1, 3, 4, 1, 2, 3, 1, 3};
		
		// 배열 numbers의 원소들 중에서 1, 2, 3, 4의 개수를 저장할 배열
		int[] counts = new int[5];
		// -> counts[1] = 1의 개수
		// -> counts[2] = 2의 개수
		// -> counts[3] = 3의 개수
		// -> counts[4] = 4의 개수
		// -> counts[5] = 5의 개수
		
		// 반복문을 이용해 배열 numbers의 원소들 중에서 1, 2, 3, 4의 개수를 계산
		
		for(int item : numbers)
			counts[item]++;
			
		/*
		for(int item = 0; item < numbers.length; item++)
			counts[numbers[item]]++;
		*/
		// 출력
		for (int i = 1; i <= 4; i++) {
			// 숫자 출력
			System.out.print(i + " ");
		
			// 1, 2, 3, 4의 개수만큼 "*"을 출력
			for (int j = 0; j < counts[i]; j++) System.out.print("*");
			
			// 개행
			System.out.println();
		}
	}
}
