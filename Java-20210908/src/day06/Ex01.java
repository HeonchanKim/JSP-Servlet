package day06;

public class Ex01 {
	public static void main(String[] args) {	
		// 바깥쪽 반복문을 이용해서 행(rows)을 표현
		for(int i = 1; i <= 9; i++) {
			// 안쪽 반복문을 이용해 열(columns)을 표현
			for(int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
