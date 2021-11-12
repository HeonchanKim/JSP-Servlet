package day16;

// 간단한 클래스 Sample
// -> Sample 클래스의 인스턴스를 복제하기 위해서는 Cloneable 인터페이스를 구현해서
//    clone 메소드를 재정의해야 한다.
class Sample implements Cloneable{
	private int data;
	
	public Sample(int n) { data = n; }
	public Sample() { this(0); }
	
	public void setData(int n) { data = n; }
	public int getData() { return data; }
	
	void print() { System.out.println("data = " + data); }
	
	// clone 메소드 재정의
	@Override
	public Sample clone() {
		try {
			return (Sample)super.clone();
		}
		catch (CloneNotSupportedException e) {
			// Cloneable 인터페이스를 구현했기 때문에 이 블록이 실행되는 일은 없다.
			return null;
		}
	}
	
	// equals 메소드의 재정의
	// -> 두 인스턴스의 필드가 같은 값을 가지고 있는지 비교하기 위해, Object 클래스의
	//    equals 메소드를 재정의한다.
	public boolean equals(Object obj) {
		// 매개변수에 전달된 객체가 Sample 클래스의 인스턴스인지 확인
		if (obj instanceof Sample)
			// Object 클래스의 참조 변수인 obj를 통해 Sample 클래스의 필드에 접근
			return data == ((Sample)obj).data;
		else
			return false;
	}
	
	// toString 메소드의 재정의
	// -> 객체를 문자열 형태로 표현할 때 toString 메소드가 호출된다. 이때 Object 클래스의
	//    toString 메소드를 재정의하면 원하는 형태로 문자열을 만들 수 있다.
	@Override
	public String toString() {
		return "[data = " + data + "]"; 
	}
}
public class Ex01 {
	public static void main(String[] args) {
		// 객체 생성
		Sample obj1 = new Sample(10);
		
		// 참조 변수를 이용해 obj1이 참조하는 객체를 obj2를 이용해서 참조
		// 즉, obj1과 obj2가 참조하는 객체는 같은 객체이다.
		Sample obj2 = obj1;

		// clone 메소드를 이용해 기존 객체를 복제해서 새로운 객체를 생성할 수 있다.
		// 이때 clone 메소드를 이용해 복제하기 위해서는 Cloneable 인터페이스를 구현해야 한다.
		Sample obj3 = obj1.clone();
		
		System.out.println("obj1.data = " + obj1.getData());
		System.out.println("obj2.data = " + obj2.getData());
		System.out.println("obj3.data = " + obj3.getData());
		System.out.println();
		
		obj1.setData(20);
		
		System.out.println("obj1.data = " + obj1.getData());
		System.out.println("obj2.data = " + obj2.getData());
		System.out.println("obj3.data = " + obj3.getData());
		System.out.println();
		
		// 배열은 참조 변수들의 배열을 참조하는 참조 변수이다.
		Sample[] list1 = new Sample[3];

		// 배열의 각 원소는 참조 변수이며, 객체를 생성해서 이 참조 변수로 참조하도록 한다.
		list1[0] = new Sample(100);
		list1[1] = new Sample(200);
		list1[2] = new Sample(300);
		
		Sample[] list2 = list1;
		
		// 배열 list1을 복제했지만, list1의 각 원소가 참조하고 있는 객체는 복제하지 않는다!
		Sample[] list3 = list1.clone();
		
		list1[0].setData(110);
		
		System.out.println("list1[0].data = " + list1[0].getData());
		System.out.println("list2[0].data = " + list2[0].getData());
		System.out.println("list3[0].data = " + list3[0].getData());
		
		/*
		 * 두 객체가 같은지 비교
		 * */
		// 비교 연산자를 이용해 비교하면, 두 참조 변수가 같은 객체를 참조하고 있는지 확인
		if (obj1 == obj2)
			System.out.println("Same object!");
		else
			System.out.println("Different objects!");
		
		// equals 메소드를 이용해, 두 객체의 필드가 같은지 확인
		if (obj1.equals(obj2))
			System.out.println("Same object!");
		else
			System.out.println("Different objects!");
		
		/*
		 * 객체의 클래스 정보를 확인
		 * -> Object 클래스의 getClass 메소드를 이용 
		 * */
		System.out.println("obj1 is of type + " + obj1.getClass().getName());
		// -> getClass 메소드는 Class 객체를 반환하고, Class 객체의 getName 메소드를
		//    이용해 클래스 식별자를 문자열 형태로 구할 수 있다.
		
		/*
		 * 객체를 문자열 형태로 표현
		 * -> 이때 toString 메소드가 자동으로 호출된다.
		 * */
		System.out.println("obj1 = " + obj1);
	}
}
