package day07;

public class Ex04 {
	public static void main(String[] args) {
		
		// 2차원 배열 생성
		int[][] numbers = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};

		// 중첩 반복문을 이용해 2차원 배열의 모든 원소들에 접근
		
		// 바깐쪽 반복문을 이용해 행(row)을 표현 - 2차원 배열의 각 원소인 배열에 접근
		for(int i = 0; i < numbers.length; i++) {
			// 안쪽 반복문을 이용해 열(columns)을 표현 - 2차원 배열의 각 원소의 배열의 원소
			for(int j = 0; j < numbers[i].length; j++)
				System.out.printf("numbers[%d][%d] = %d\n", i, j, numbers[i][j]);
		}
	}
}
