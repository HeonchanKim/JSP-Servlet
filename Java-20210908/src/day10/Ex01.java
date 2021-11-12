package day10;

// 간단한 클래스 Sample
class Sample {
	// 필드(field)
	private int data;
	
	// 메소드
	
	// 생성자(constructor)
	// -> 객체가 생성될 때 자동으로 호출되는 메서드
	// -> 생성자는 필드를 초기화하는 역할을 수행한다.
	// -> 생성자의 식별자는 클래스의 식별자와 같아야 한다.
	// -> 생성자는 반환 값이 없는 메소드이다.
	// -> 생성자는 객체가 생성될 때 반드시 호출되어야 하므로, 접근제어를 "public"으로 한다.
	public Sample(int data) {
		// this.data = data;
		// setData(data);
		this.setData(data);
	}
	
	// 메소드 오버로딩을 이용해 생성자를 여러 개 정의할 수 있다.
	public Sample() {
		// this 메소드
		// -> 생성자에서 다른 생성자를 호출할 때 사용
		// -> this 메소드는 생성자의 첫 문장에서만 쓸 수 있다.
		// data = 0;
		this(0);
	}
	
	// 기본 생성자(default constructor)
	// -> 클래스에 생성자가 없는 경우 자동으로 추가되는 생성자
	//    만약 생성자가 하나라도 있으면 기본 생성자는 추가되지 않는다.
	// public Sample() { }
	
	// 복사 생성자(copy constructor)
	// -> 다른 객체를 전달 받아 호출되는 생성자
	public Sample(Sample copy) {
		this(copy.data);
	}
	
	// 최소한 3개의 생성자는 정의를 해줘야 어떠한 상황에서든지 객체를 생성할수있다.
	
	// 설정자
	public void setData(int data) {
		// this 참조 변수
		// -> 메소드에서 사용하는 키워드이며, 객체 자신을 참조
		this.data = data;
	}
	
	// 접근자
	public int getData() { return data; }
	
	// 출력
	public void print() {
		System.out.println("data = " + data);
	}
}

public class Ex01 {
	public static void main(String[] args) {
		// 변수 선언
		int num = 10;
		
		System.out.println("num = " + num);
		
		// 객체 생성
		// -> 객체가 생성될 때는 "생성자(constructor)"가 자동으로 호출된다.
		Sample obj = new Sample(10);
		// -> 필드 data를 초기화할 값을 지정해서 객체 생성
		//    이때는 Sample(int data) 생성자 호출
		obj.print();
		
		// 객체 생성
		Sample obj2 = new Sample();
		// -> 초기화하는 값 없이 객체 생성
		//	  이때 Sample() 생성자 호출
		
		obj2.setData(2);
		obj2.print();
		
		
		// 객체 생성
		Sample obj3 = new Sample(obj);
		// -> 필드 data를 초기화할 값으로 다른 객체를 지정해서 객체 생성
		//	  이때 Sample(Sample copy) 생성자 호출(복사생성자)
		
		obj3.print();
	}
}
