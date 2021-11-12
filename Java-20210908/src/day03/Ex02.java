package day03;

public class Ex02 {

	public static void main(String[] args) {
		
		// 변수 선언
				int n1 = 3;
				int n2 = 7;
				
				// 변수 n1과 n2 중에서 작은 값을 계산
				int min = n1 < n2 ? n1 : n2;
				// 출력
				System.out.printf("The smaller of %d and %d is %d\n", n1, n2, min);
				
				//------------------------------------------------------------------
				double factor = 123.456789123;
				
				System.out.printf("n1 = |%d|\n", n1);
				System.out.printf("n1 = |%2d|\n", n1);
				System.out.printf("n1 = |%02d|\n", n1);
				
				System.out.printf("factor = %f\n", factor);
				System.out.printf("factor = %e\n", factor);
				System.out.printf("factor = %g\n", factor);
				
				System.out.printf("factor = %.2f\n", factor);
				
				//------------------------------------------------------------------
				// String.format 메서드
				// -> System.out.printf 메소드와 비슷하게 형식 문자열을 이용해 문자열 생성
				String str = String.format("n1 = %03d", n1);
				
				System.out.println(str);
				System.out.printf("str = %s\n", str);
				
	}

}
