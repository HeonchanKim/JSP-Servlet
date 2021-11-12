package day16;

// ������ Ŭ���� Sample
// -> Sample Ŭ������ �ν��Ͻ��� �����ϱ� ���ؼ��� Cloneable �������̽��� �����ؼ�
//    clone �޼ҵ带 �������ؾ� �Ѵ�.
class Sample implements Cloneable{
	private int data;
	
	public Sample(int n) { data = n; }
	public Sample() { this(0); }
	
	public void setData(int n) { data = n; }
	public int getData() { return data; }
	
	void print() { System.out.println("data = " + data); }
	
	// clone �޼ҵ� ������
	@Override
	public Sample clone() {
		try {
			return (Sample)super.clone();
		}
		catch (CloneNotSupportedException e) {
			// Cloneable �������̽��� �����߱� ������ �� ����� ����Ǵ� ���� ����.
			return null;
		}
	}
	
	// equals �޼ҵ��� ������
	// -> �� �ν��Ͻ��� �ʵ尡 ���� ���� ������ �ִ��� ���ϱ� ����, Object Ŭ������
	//    equals �޼ҵ带 �������Ѵ�.
	public boolean equals(Object obj) {
		// �Ű������� ���޵� ��ü�� Sample Ŭ������ �ν��Ͻ����� Ȯ��
		if (obj instanceof Sample)
			// Object Ŭ������ ���� ������ obj�� ���� Sample Ŭ������ �ʵ忡 ����
			return data == ((Sample)obj).data;
		else
			return false;
	}
	
	// toString �޼ҵ��� ������
	// -> ��ü�� ���ڿ� ���·� ǥ���� �� toString �޼ҵ尡 ȣ��ȴ�. �̶� Object Ŭ������
	//    toString �޼ҵ带 �������ϸ� ���ϴ� ���·� ���ڿ��� ���� �� �ִ�.
	@Override
	public String toString() {
		return "[data = " + data + "]"; 
	}
}
public class Ex01 {
	public static void main(String[] args) {
		// ��ü ����
		Sample obj1 = new Sample(10);
		
		// ���� ������ �̿��� obj1�� �����ϴ� ��ü�� obj2�� �̿��ؼ� ����
		// ��, obj1�� obj2�� �����ϴ� ��ü�� ���� ��ü�̴�.
		Sample obj2 = obj1;

		// clone �޼ҵ带 �̿��� ���� ��ü�� �����ؼ� ���ο� ��ü�� ������ �� �ִ�.
		// �̶� clone �޼ҵ带 �̿��� �����ϱ� ���ؼ��� Cloneable �������̽��� �����ؾ� �Ѵ�.
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
		
		// �迭�� ���� �������� �迭�� �����ϴ� ���� �����̴�.
		Sample[] list1 = new Sample[3];

		// �迭�� �� ���Ҵ� ���� �����̸�, ��ü�� �����ؼ� �� ���� ������ �����ϵ��� �Ѵ�.
		list1[0] = new Sample(100);
		list1[1] = new Sample(200);
		list1[2] = new Sample(300);
		
		Sample[] list2 = list1;
		
		// �迭 list1�� ����������, list1�� �� ���Ұ� �����ϰ� �ִ� ��ü�� �������� �ʴ´�!
		Sample[] list3 = list1.clone();
		
		list1[0].setData(110);
		
		System.out.println("list1[0].data = " + list1[0].getData());
		System.out.println("list2[0].data = " + list2[0].getData());
		System.out.println("list3[0].data = " + list3[0].getData());
		
		/*
		 * �� ��ü�� ������ ��
		 * */
		// �� �����ڸ� �̿��� ���ϸ�, �� ���� ������ ���� ��ü�� �����ϰ� �ִ��� Ȯ��
		if (obj1 == obj2)
			System.out.println("Same object!");
		else
			System.out.println("Different objects!");
		
		// equals �޼ҵ带 �̿���, �� ��ü�� �ʵ尡 ������ Ȯ��
		if (obj1.equals(obj2))
			System.out.println("Same object!");
		else
			System.out.println("Different objects!");
		
		/*
		 * ��ü�� Ŭ���� ������ Ȯ��
		 * -> Object Ŭ������ getClass �޼ҵ带 �̿� 
		 * */
		System.out.println("obj1 is of type + " + obj1.getClass().getName());
		// -> getClass �޼ҵ�� Class ��ü�� ��ȯ�ϰ�, Class ��ü�� getName �޼ҵ带
		//    �̿��� Ŭ���� �ĺ��ڸ� ���ڿ� ���·� ���� �� �ִ�.
		
		/*
		 * ��ü�� ���ڿ� ���·� ǥ��
		 * -> �̶� toString �޼ҵ尡 �ڵ����� ȣ��ȴ�.
		 * */
		System.out.println("obj1 = " + obj1);
	}
}
