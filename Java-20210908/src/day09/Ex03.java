package day09;

public class Ex03 {
	public static void main(String[] args) {
		// ��ü ����
		Person jackson = new Person();
		Person brown = new Person();
		Person dean = new Person();

		// �����ڸ� �̿��� ��ü�� ���� ����
		jackson.setName("Michael Jackson");
		jackson.setAge(24);
		
		brown.setName("Charles Brown");
		brown.setAge(21);
		
		dean.setName("James Dean");
		dean.setAge(36);
		
		// ���
		jackson.print();
		brown.print();
		dean.print();
	}
}
