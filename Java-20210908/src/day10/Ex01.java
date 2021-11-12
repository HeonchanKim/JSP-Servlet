package day10;

// ������ Ŭ���� Sample
class Sample {
	// �ʵ�(field)
	private int data;
	
	// �޼ҵ�
	
	// ������(constructor)
	// -> ��ü�� ������ �� �ڵ����� ȣ��Ǵ� �޼���
	// -> �����ڴ� �ʵ带 �ʱ�ȭ�ϴ� ������ �����Ѵ�.
	// -> �������� �ĺ��ڴ� Ŭ������ �ĺ��ڿ� ���ƾ� �Ѵ�.
	// -> �����ڴ� ��ȯ ���� ���� �޼ҵ��̴�.
	// -> �����ڴ� ��ü�� ������ �� �ݵ�� ȣ��Ǿ�� �ϹǷ�, ������� "public"���� �Ѵ�.
	public Sample(int data) {
		// this.data = data;
		// setData(data);
		this.setData(data);
	}
	
	// �޼ҵ� �����ε��� �̿��� �����ڸ� ���� �� ������ �� �ִ�.
	public Sample() {
		// this �޼ҵ�
		// -> �����ڿ��� �ٸ� �����ڸ� ȣ���� �� ���
		// -> this �޼ҵ�� �������� ù ���忡���� �� �� �ִ�.
		// data = 0;
		this(0);
	}
	
	// �⺻ ������(default constructor)
	// -> Ŭ������ �����ڰ� ���� ��� �ڵ����� �߰��Ǵ� ������
	//    ���� �����ڰ� �ϳ��� ������ �⺻ �����ڴ� �߰����� �ʴ´�.
	// public Sample() { }
	
	// ���� ������(copy constructor)
	// -> �ٸ� ��ü�� ���� �޾� ȣ��Ǵ� ������
	public Sample(Sample copy) {
		this(copy.data);
	}
	
	// �ּ��� 3���� �����ڴ� ���Ǹ� ����� ��� ��Ȳ�������� ��ü�� �����Ҽ��ִ�.
	
	// ������
	public void setData(int data) {
		// this ���� ����
		// -> �޼ҵ忡�� ����ϴ� Ű�����̸�, ��ü �ڽ��� ����
		this.data = data;
	}
	
	// ������
	public int getData() { return data; }
	
	// ���
	public void print() {
		System.out.println("data = " + data);
	}
}

public class Ex01 {
	public static void main(String[] args) {
		// ���� ����
		int num = 10;
		
		System.out.println("num = " + num);
		
		// ��ü ����
		// -> ��ü�� ������ ���� "������(constructor)"�� �ڵ����� ȣ��ȴ�.
		Sample obj = new Sample(10);
		// -> �ʵ� data�� �ʱ�ȭ�� ���� �����ؼ� ��ü ����
		//    �̶��� Sample(int data) ������ ȣ��
		obj.print();
		
		// ��ü ����
		Sample obj2 = new Sample();
		// -> �ʱ�ȭ�ϴ� �� ���� ��ü ����
		//	  �̶� Sample() ������ ȣ��
		
		obj2.setData(2);
		obj2.print();
		
		
		// ��ü ����
		Sample obj3 = new Sample(obj);
		// -> �ʵ� data�� �ʱ�ȭ�� ������ �ٸ� ��ü�� �����ؼ� ��ü ����
		//	  �̶� Sample(Sample copy) ������ ȣ��(���������)
		
		obj3.print();
	}
}
