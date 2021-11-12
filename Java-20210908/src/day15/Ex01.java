package day15;

// 간단한 슈퍼 클래스 SampleSuper
class SampleSuper {
	private int dataSuper;
	
	public SampleSuper(int n) { dataSuper = n; }
	public SampleSuper() { this(0); }
	
	public void setDataSuper(int n) { dataSuper = n; }
	public int getDataSuper() { return dataSuper; }
	
	void print() {
		System.out.println("dataSuper = " + dataSuper);
	}
	
	public static void printStatic() {
		System.out.println("SampleSuper::printStatic");
	}
}

// 간단한 서브 클래스 SampleSub
class SampleSub extends SampleSuper {
	private int dataSub;
	
	public SampleSub(int n1, int n2) {
		super(n1);
		dataSub = n2;
	}
	
	public SampleSub() { this(0, 0); }
	
	public void setDataSub(int n) { dataSub = n; }
	public int getDataSub() { return dataSub; }
	
	@Override
	public void print() {
		super.print();
		System.out.println("dataSub = " + dataSub);
	}
	
	public static void printStatic() {
		System.out.println("SampleSub::printStatic");
	}
	
	
}

public class Ex01 {
	public static void main(String[] args) {
		// 객체 생성
		SampleSuper objSuper = new SampleSuper(10);
		SampleSub objSub = new SampleSub(20, 30);
		
		objSuper.print();		  // SampleSuper::print();
		SampleSuper.printStatic();
		System.out.println();
		
		objSub.print();			  // SampleSub::print();
		SampleSub.printStatic();
		System.out.println();
		
		// 슈퍼 클래스의 참조 변수로 서브 클래스의 객체를 참조할 수 있다!
		objSuper = objSub;
		
		objSuper.print();		  // SampleSub::print(); (동적바인딩)
		System.out.println();
		
		// 메소드를 호출할 때 어떤 메소드를 호출할지 결정하는 방식(바인딩; binding)
		// 1. 정적 바인딩(static binding)
		//    -> 컴파일 단계에서 참조 변수의 자료형에 따라 어떤 메소드를 호출할지 결정
		//    -> 정적 메소드(클래스 메소드)의 경우에는 정적 바인딩을 한다.
		// 2. 동적 바인딩(dynamic binding)
		//    -> 프로그램 실행 단계에서 어떤 메소드를 호출할지 결정
		//    -> 참조 변수의 자료형이 아니라 참조 변수가 참조하는 객체의 자료형에 따라
		//       어떤 메소드를 호출할지 결정한다!
		//	  -> Java 프로그램에서는 인스턴스 메소드(일반 메소드)는 동적 바인딩을 한다.
		
		// 슈퍼 클래스의 배열 선언
		SampleSuper[] list = new SampleSuper[3];
		
		// 객체를 생성해서 배열의 각 원소에 대입
		list[0] = new SampleSuper(100);
		list[1] = new SampleSub(200, 300);
		list[2] = new SampleSuper(400);
		
		// 반복문을 이용해 배열 list의 각 원소에 순차적으로 접근
		for (int i = 0; i < list.length; i++)
			list[i].print();
		
	}
}
