package day19;

// 배열에 관련된 기능을 제공하는 클래스 Array
class Array {
	
	/*
	 * 
	 * 제네릭 메소드(method)
	 * -> 메소드에서 타입 매개변수를 사용해 제네릭 메소드를 정의
	 * -> 이때 타입 매개변수의 범위는 메소드 내부로 제한된다. 
	 * */
	public static <T> T getLast(T[] list) {
		return list[list.length - 1];
	}
}
public class Ex04 {
	public static void main(String[] args) {
		// String 배열 생성
		String[] languages = { "C++", "C#", "Java" };
		
		// 제네릭 메소드를 호출할 때 타입 매개변수에 전달할 자료형을 지정한다.
		// String last = Array.<String>getLast(languages);
		
		// 문맥에 따라 자료형을 결정할 수 있다면, 타입 매개변수에 전달할 자료형을 생략할 수 있다.
		String last = Array.getLast(languages);
		
		System.out.println("last = " + last);
	}
}
