package day09;

//클래스 정의

//사람을 표현하는 클래스 Person
public class Person {
	// 필드(field) 정의
	private String name;
	private int age;
	
	// 메소드 정의
	
	// 설정자(setter)
	public void setName(String str) {
		name = str;
	}
	public void setAge(int n) {
		age = n >= 0 ? n : 0;
	}
	
	// 접근자(getter)
	public String getName(){ return name; }
	public int getAge() { return age; }
	
	// 출력
	public void print(){
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		System.out.println();
	}
	
}
