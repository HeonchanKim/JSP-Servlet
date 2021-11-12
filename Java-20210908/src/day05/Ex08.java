package day05;

public class Ex08 {

	public static void main(String[] args) {
		
		// 중첩 반복문을 이용해 구구단 출력
		
		// 바깥쪽 반복문을 이용해 행을 표현
		for(int i = 1; i <= 9; i++) {
			// 안쪽 반복문을 이용해 열을 표현
			for(int j = 2; j <= 9; j++)
				System.out.printf("%2d", j*i);
			
			// 개행
			System.out.println();
		}

	}

}
