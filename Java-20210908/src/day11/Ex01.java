package day11;

// 간단한 클래스 Sample
class Sample {
	// 필드 = 인스턴스 변수(instance variable)
	// -> 각각의 인스턴스(객체)들마다 생성되는 변수
	// -> 객체가 소멸하면 인스턴스 변수도 소멸한다.
	private int data;
	
	// 정적 변수(static variable) = 클래스 변수
	// -> 클래스에 하나만 존재하며, 클래스의 모든 인스턴스들이 공유한다.
	// -> 정적 변수는 객체와는 무관하게 존재하며, 프로그램이 실행되면 선언되고 초기화된다.
	// -> 객체의 소멸과는 상관 없이 프로그램이 종료될 때까지 유지된다.
	private static int numSamples = 0;
	
	// 상수 필드(constant field)
	// -> 생성자에서 초기화
	// private final int MAX;
	
	// 정적 상수
	// -> 상수가 필드가 모든 인스턴스에서 같은 값을 가지면, 정적 상수로 선언하는 것이 좋다.
	private static final int MAX = 255;
	
	public Sample(int n) {
		data = n;
		
		// 샹수는 반드시 선언하면서 초기화해야 한다.
		// 상수 필드는 생성자에서 초기화한다.
		// MAX = 255;
		numSamples++;
		
		System.out.println("number of Sample = " + numSamples);
		}
	public Sample() { this(0); }
	
	public void setData(int n) { data = n;}
	public int getData() { return data; }
	
	public void print() { System.out.println("data = " + data); }
	
	// 정적 메서드(static method)
	// -> 정적 변수는 객체가 생성되기 이전에 선언되지만, 일반 메소드는 객체가 생성되어야
	//    호출할 수 있다.
	// -> 정적 메소드는 객체가 생성되기 이전에 호출할 수 있다.
	//    따라서 정적메소드에서는 정적 변수와 정적 메소드에만 접근할 수 있다.
	//    또한 this 키워드를 사용할 수 없다.
	public static int getNumSamples() { return numSamples; }
	public static void printNumSamples() { System.out.println("numSamples = " + numSamples); }
}

public class Ex01 {
	public static void main(String[] args) {
		
		// main 메소드는 정적 메소드이므로, 정적 메소드만 호출할 수 있다.
		
		// 상수(constant)
		final double factor = 0.98;
		
		Sample.printNumSamples();
		
		// 정적 변수는 객체가 생성되기 전에 선언되고 초기화된다.
		// System.out.println("obj1. numSamples = " + Sample.numSamples); 
		// 객체 생성
		Sample obj1 = new Sample(10);
		Sample obj2 = new Sample(20);
	
		// 정적 변수의 접근 제어가 public이라고 해도 참조 변수를 통해 접근할 수 없다!
		// System.out.println("obj1. numSamples = " + obj.1numSamples); // WRONG!!
		
		// 객체 외부에서 정적 변수(클래스 변수)에 접근할 때는 참조 변수로 접근하는 게 아니라
		// 클래스 식별자를 이용해 접근해야 한다.
		// System.out.println("obj1. numSamples = " + Sample.numSamples);
		
		// 정적 메소드는 참조 변수가 아니라 클래스 식별자를 통해 접근해야 한다.
		// obj1.printNumSamples(); // WRONG!!
		Sample.printNumSamples();
		
		obj1.print();
		obj2.print();
	}
}
