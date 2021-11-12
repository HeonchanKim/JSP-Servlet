package day08;

public class Ex01 {
	public static void main(String[] args) {
		// 2차원 배열 생성
		int[][] scores = {
				{87, 43, 64, 71},
				{65, 69, 77, 82},
				{91, 84, 62, 76}
		};
		
		// 2차원 배열 scores의 행의 개수
		int rows = scores.length;
		
		// 2차원 배열 scores의 열의 개수
		int columns = scores[0].length;
		
		// 2차원 배열 scores의 각 열의 합계를 저장할 배열
		int[] sumColumn = new int[4];
		
		// 평균
		double average;
		
		// 중첩 반복문을 이용해 2차원 배열 scores의 각 열의 합계를 계산
		// -> 바깥쪽 반복문이 행(rows)을 표현, 안쪽 반복문이 열(columns)을 표현
		for (int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				sumColumn[j] += scores[i][j];
		
		// 평균을 계산한 후 출력
		for (int i = 0; i < columns; i++) {
			average = (double)sumColumn[i] / rows;
			
			System.out.printf("%dth column : sum = %d, average = %.2f\n", i + 1, sumColumn[i], average);
		}
		// ----------------------------------------------------------------------------------------------
		System.out.println();
		
		// 각 열의 합계를 저장할 변수
		int sum = 0;
		
		// 중첩 반복문을 이용해 2차원 배열 scores의 각 열의 합계를 계산
		// -> 바깥쪽 반복문이 열(columns)을 표현, 안쪽 반복문이 행(rows)을 표현
		for (int i = 0; i < columns; i++) {
			// 합계를 저장할 변수를 초기화
			sum = 0;
		
			// 각 행에서 같은 열의 원소의 합계를 계산
			for(int j = 0; j < rows; j++)
				sum += scores[j][i];
			
			// 평균 계산
			average = (double)sum / rows;
			
			// 출력
			System.out.printf("%dth column : sum = %d, average = %.2f\n", i + 1, sum, average);
		}
		
	}
}
