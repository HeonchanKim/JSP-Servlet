package day09;

//Ŭ���� ����

//����� ǥ���ϴ� Ŭ���� Person
public class Person {
	// �ʵ�(field) ����
	private String name;
	private int age;
	
	// �޼ҵ� ����
	
	// ������(setter)
	public void setName(String str) {
		name = str;
	}
	public void setAge(int n) {
		age = n >= 0 ? n : 0;
	}
	
	// ������(getter)
	public String getName(){ return name; }
	public int getAge() { return age; }
	
	// ���
	public void print(){
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		System.out.println();
	}
	
}
