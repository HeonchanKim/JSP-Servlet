package day11;

// 열거형(enumeration)
// -> 관련 있는 상수(constant)들의 집합
// -> 클래스의 일종이며, enum 키워드를 이용해서 정의
enum Days{ // Days는 자료형이된다
	SUNDAY, MONDAY, TUESDAY, WENDSDAY, THURSDAY, FRIDAY, SATURDAY;
}
enum Types{ // Types는 자료형이된다
	NOTICE, NORMAL, REPLY;
}

public class Ex03 {
	public static void main(String[] args) {
		/*
		// 요일을 표현하는 상수
		private static final int SUNDAY = 1,
				MONDAY = 2,
				TUESDAY = 3,
				WENDSDAY = 4,
				THURSDAY = 5,
				FRIDAY = 6,
				SATURDAY = 7;
		
		// 게시물의 종류를 표현하는 상수
		*/
		
		/*
		// 요일을 표현!
		// sunday = 1, monday = 2, tuesday = 3, .....
		int day = 2;
		
		// 변수 day에 따라 출력
		switch (day) {
		case 1:
			System.out.println("Today is Sunday.");
			break;
		case 2:
			System.out.println("Today is Monday.");
			break;
		case 3:
			System.out.println("Today is Tuesday.");
			break;
		//...
		default:
			System.out.println("Invalid value!");
			break;
		}
		*/
		/*
		int day = MONDAY;
		
		// 변수 day에 따라 출력
		switch (day) {
		case SUNDAY:
			System.out.println("Today is Sunday.");
			break;
		case MONDAY:
			System.out.println("Today is Monday.");
			break;
		case TUESDAY:
			System.out.println("Today is Tuesday.");
			break;
		//...
		default:
			System.out.println("Invalid value!");
			break;
		}
		*/
		
		// 열거형 변수
		Days day = Days.MONDAY;
		
		// 변수 day에 따라 출력
		switch (day) {
		case SUNDAY:
			System.out.println("Today is Sunday.");
			break;
		case MONDAY:
			System.out.println("Today is Monday.");
			break;
		case TUESDAY:
			System.out.println("Today is Tuesday.");
			break;
		//...
		default:
			System.out.println("Invalid value!");
			break;
		}
		
		// 게시물의 종류를 나타내는 변수
		Types type = Types.NORMAL;
		
		// 다른 자료형의 변수이므로 비교할 수 없다!
//		if(day == type)
//			System.out.println("Same Value!");
		
	}
}
