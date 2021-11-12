package day13;

// 간단한 슈퍼 클래스 SampleSuper
class SampleSuper {
	//필드
	private int dataSuper;
	
	// 생성자
	public SampleSuper(int n) { dataSuper = n; }
	public SampleSuper() { this(0); }
	
	// 설정자
	public void setDataSuper(int n) { dataSuper = n;}
	
	// 접근자
	public int getDataSuper() { return dataSuper; }
	
	// public void printSuper() {
	public void print() {
		System.out.println("dataSuper = " + dataSuper);
	}
}

// SampleSuper 클래스를 상속 받은 간단한 서브 클래스 SampleSub
class SampleSub extends SampleSuper {
	private int dataSub;
	
	
	// 생성자
	
	// 서브 클래스의 객체 생성
	// -> 서브 클래스의 생성자가 실행되기 전에 슈퍼 클래스의 생성자가 호출되어야 한다!
	// -> 서브 클래스의 생성자에서 슈퍼 클래스의 생성자를 호출하지 않으면, 슈퍼 클래스의
	//    기본 생성자가 묵시적으로 호출된다.
	// -> 클래스의 필드는 해당 클래스의 생성자에서 초기화한다.
	
	public SampleSub(int n1, int n2) {
		// 서브 클래스의 생성자에서 슈퍼클래스의 생성자를 명시적으로 호출하지 않은 경우,
		// 컴파일러가 슈퍼 클래스의 기본 생성자를 묵시적으로 호출
		// SampleSuper();
		// super();
		// ->super 클래스를 이용해 슈퍼 클래스의 생성자 호출
		
		// -> 서브 클래스의 생성자에서는 슈퍼 클래스의 생성자를 호출해서 슈퍼 클래스의 필드도 초기화해야 한다!
		super(n1);
		dataSub = n2;
		}
	
	public SampleSub() { this(0, 0); }
	
	// 설정자
	public void setDataSub(int n) { dataSub = n;}
	
	// 접근자
	public int getDataSub() { return dataSub; }
	
	// 메소드 오버라이딩(method overriding: 메소드 재정의)
	// -> 슈퍼 클래스에서 정의한 메소드와 같은 식별자를 가지는 메소드를 서브 클래스에서 정의해서
	//    슈퍼 클래스의 메소드를 재정의할 수 있다.
	// -> 서브 클래스에서 재정의한 메소드의 경우, @Override 주해(annotation)을 달아서
	//    컴파일러에게 이 메소드가 재정의한 메소드임을 명시적으로 알린다.
	
	//public void printSub() {
	@Override
	public void print() {
		// System.out.println("dataSuper = " + dataSuper);
		// System.out.println("dataSuper = " + getDataSuper()); // 접근자 사용
		// printSuper();
		
		// 메소드 오버라이딩
		super.print();
		// -> 슈퍼 클래스의 멤버와 서브 클래스의 멤버가 식별자가 같은 경우, super 키워드를
		//    이용해 슈퍼 클래스의 멤버에 접근할 수 있다.
		
		System.out.println("dataSub = " + dataSub);
	}
}

public class Ex01 {
	public static void main(String[] args) {
		// SampleSuper 클래스의 인스턴스 생성
		SampleSuper objSuper = new SampleSuper(10);
		
		objSuper.print();
		
		// SampleSub 클래스의 인스턴스 생성
		SampleSub objSub = new SampleSub(10, 20);
		
		// 메소드 오버라이딩(method overriding)
		// objSub.printSub();
		objSub.print();
	}
}
