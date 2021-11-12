package day09;

public class Ex03 {
	public static void main(String[] args) {
		// 객체 생성
		Person jackson = new Person();
		Person brown = new Person();
		Person dean = new Person();

		// 설정자를 이용해 객체에 값을 설정
		jackson.setName("Michael Jackson");
		jackson.setAge(24);
		
		brown.setName("Charles Brown");
		brown.setAge(21);
		
		dean.setName("James Dean");
		dean.setAge(36);
		
		// 출력
		jackson.print();
		brown.print();
		dean.print();
	}
}
