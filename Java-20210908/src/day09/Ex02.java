package day09;

// 클래스 정의
class Sample{
	// 필드 정의
	private int data;
	
	// 메소드 정의
	
	// 설정자(setter)
	public void setData(int n) {
		// data = n;
		
		// 설정자에서는 멤버 변수에 잘못된 값이 들어가지 않도록 설정할 값을 검사한다!
		data = n > 0 ? n : 0;
	} 
	
	// 접근자(getter)
	public int getData() {
		return data;
	}
	
	public void print() {
		System.out.println("data = " + data);
	}
}

public class Ex02 {
	public static void main(String[] args) {
		// 객체(object) 생성
		Sample obj = new Sample();
		
		// obj.data = 10;
		obj.setData(10);
		
		obj.print();
		
		System.out.println("obj.data = " + obj.getData());
	}
}
