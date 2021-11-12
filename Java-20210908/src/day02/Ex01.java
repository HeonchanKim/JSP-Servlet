package day02;

public class Ex01 {
	public static void main(String[] args) {
		
		// 변수의 선언과 초기화
		int x = 10;
		int y = 3;
		// 출력
		System.out.println("x + y = "+(x+y));
		System.out.println("x - y = "+(x-y));
		System.out.println("x * y = "+(x*y));
		
		// 형 변환 연산자
		// -> 피연산자를 지정한 자료형으로 변환하는 연산자
		System.out.println("x / y = "+((double)x/(double)y));
		System.out.println("x / y = "+((double)x/y));
		
		System.out.println("x % y = "+(x%y));
		
		// 산술 연산의 규칙
		// -> 산술 연산에서 연산 결과의 자료형은 피연산자의 자료형과 같다!
		// -> 산술 연산에서 피연산자들은 반드시 자료형이 같아야 한다
		//    만약 피연산자들의 자료형이 다르면, 표현 범위가 더 넓은 자료형을 기준으로
		//    자료형을 변환한 다음 연산한다.(자동형변환)
		
	}

}
