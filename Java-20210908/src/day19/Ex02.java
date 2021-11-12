package day19;

/*
 * 
 * 제네릭 클래스(generic class)
 * -> 필드 또는 메소드에서 다양한 자료형을 사용할 수 있도록 하는 클래스
 * -> 이러한 다양한 자료형을 "타입 매개변수(type parameter)"를 이용해서 표현한다.
 *    타입 매개변수에는 객체를 생성하면서 지정한 자료형이 전달된다.
 * -> 타입 매개변수에 전달되는 자료형은 반드시 클래스이어야 한다!
 * */

class Box<T> {
	private T data;
	
	Box(T data) { this.data = data; }
	Box() { this(null); }
	public void set(T data) { this.data = data; }
	public T get() { return data; }
}

public class Ex02 {
	public static void main(String[] args) {
		// Integer 자료형의 Box 객체 생성
		Box<Integer> num = new Box<Integer>(10);
		
		System.out.println("num = " + num);
		
		// num.set("Hello World!");          // Syntax error!
		
		// String 자료형의 Box 객체 생성
		Box<String> str = new Box<String>("Hello World!");
		
		System.out.println("str = " + str);
		
		// str.set(10);                      // Syntax error!
	
		// Integer value = (Integer)str.get();  // Syntax error!
		
		// 타입 매개변수에는 원시 자료형(primitive type)이 전달될 수 없다!
		// Box<int> n2 = new Box<int>(10);      //WRONG!
		
		// 제네릭 클래스의 객체를 생성할 때, 타입 매개변수에 전달할 자료형을 생략할 수 있다.
		// 이때 문맥에 따라 컴파일러가 자료형을 추측한다.
		Box<String> str2 = new Box<>("Do your best!");
		
		System.out.println("str2 = " + str2);
	}
}
