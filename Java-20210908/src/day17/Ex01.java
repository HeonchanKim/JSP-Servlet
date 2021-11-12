package day17;

public class Ex01 {
	public static void main(String[] args) {
		// String 객체 생성
		String str1 = "Hello";
		String str2 = "Hi";
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println();
		
		// String 클래스의 compareTo 메소드
		// @return positive str1이 str2보다 큰 경우
		// @return negative str1이 str2보다 작은 경우
		// @return zero str1과 str2가 같은 경우
		
		// 사전순으로 비교 (아스키코드의 크기르 비교())
		if (str1.compareTo(str2) > 0)
			System.out.println("str1 is greater than str2.");
		else if (str1.compareTo(str2) < 0)
			System.out.println("str1 is less than str2.");
		else
			System.out.println("str1 is equal to str2.");
			
		//-----------------------------------------------------------------------------------------------
		// String 객체 생성
		String str3 = "Dream";
		String str4 = "comes true!";
		
		// 덧셈 연산자(+)를 이용해 두 문자열을 연결
		String str5 = str3 + str4;
		
		// 출력
		System.out.println("str3 = " +str3);
		System.out.println("str4 = " +str4);
		System.out.println("str5 = " +str5);
		System.out.println();
		
		// 복합 대입 연산자(+=)를 이용해서 두 문자열을 연결해서 새로운 Stirng 객체를 생성
		str3 += str4;
		
		System.out.println("str3 = " +str3);
		
		// 덧셈 연산자(+)를 이용해 다른 자료형의 값을 문자열에 연결
		String str6 = "value = " + 10;
		
		System.out.println(str6);
		
		//
		// 덧셈 연산자(+)를 이용해 다른 자료형의 값을 문자열에 연결
		int n1 = 7;
		int n2 = 3;
		
		String str7 = n1 + " x " + n2 + " = " + n1 * n2;
		
		System.out.println(str7);
		
		// 문자열을 다른 자료형의 값으로 변환
		// -> 랩퍼 클래스(wrapper class)를 이용해 문자열을 다른 자료형의 값으로 변환
		// -> 랩퍼 클래스는 원시 자료형(primitve type)의 값을 다루기 위해 사용한다.
		//    Integer, Double, Char 등
		String str8 = "21";
		
		int num = Integer.parseInt(str8);
		
		double pi = Double.parseDouble("3.141592");
		
		System.out.println("num = " + num);
		System.out.println("pi = " + pi);
		
		// String 클래스의 length 메소드
		// -> 문자열의 길이를 구하는 메소드
		System.out.println("str7.length = " + str7.length());
		
		
	}
}
