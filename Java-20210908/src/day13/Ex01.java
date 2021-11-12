package day13;

// ������ ���� Ŭ���� SampleSuper
class SampleSuper {
	//�ʵ�
	private int dataSuper;
	
	// ������
	public SampleSuper(int n) { dataSuper = n; }
	public SampleSuper() { this(0); }
	
	// ������
	public void setDataSuper(int n) { dataSuper = n;}
	
	// ������
	public int getDataSuper() { return dataSuper; }
	
	// public void printSuper() {
	public void print() {
		System.out.println("dataSuper = " + dataSuper);
	}
}

// SampleSuper Ŭ������ ��� ���� ������ ���� Ŭ���� SampleSub
class SampleSub extends SampleSuper {
	private int dataSub;
	
	
	// ������
	
	// ���� Ŭ������ ��ü ����
	// -> ���� Ŭ������ �����ڰ� ����Ǳ� ���� ���� Ŭ������ �����ڰ� ȣ��Ǿ�� �Ѵ�!
	// -> ���� Ŭ������ �����ڿ��� ���� Ŭ������ �����ڸ� ȣ������ ������, ���� Ŭ������
	//    �⺻ �����ڰ� ���������� ȣ��ȴ�.
	// -> Ŭ������ �ʵ�� �ش� Ŭ������ �����ڿ��� �ʱ�ȭ�Ѵ�.
	
	public SampleSub(int n1, int n2) {
		// ���� Ŭ������ �����ڿ��� ����Ŭ������ �����ڸ� ��������� ȣ������ ���� ���,
		// �����Ϸ��� ���� Ŭ������ �⺻ �����ڸ� ���������� ȣ��
		// SampleSuper();
		// super();
		// ->super Ŭ������ �̿��� ���� Ŭ������ ������ ȣ��
		
		// -> ���� Ŭ������ �����ڿ����� ���� Ŭ������ �����ڸ� ȣ���ؼ� ���� Ŭ������ �ʵ嵵 �ʱ�ȭ�ؾ� �Ѵ�!
		super(n1);
		dataSub = n2;
		}
	
	public SampleSub() { this(0, 0); }
	
	// ������
	public void setDataSub(int n) { dataSub = n;}
	
	// ������
	public int getDataSub() { return dataSub; }
	
	// �޼ҵ� �������̵�(method overriding: �޼ҵ� ������)
	// -> ���� Ŭ�������� ������ �޼ҵ�� ���� �ĺ��ڸ� ������ �޼ҵ带 ���� Ŭ�������� �����ؼ�
	//    ���� Ŭ������ �޼ҵ带 �������� �� �ִ�.
	// -> ���� Ŭ�������� �������� �޼ҵ��� ���, @Override ����(annotation)�� �޾Ƽ�
	//    �����Ϸ����� �� �޼ҵ尡 �������� �޼ҵ����� ��������� �˸���.
	
	//public void printSub() {
	@Override
	public void print() {
		// System.out.println("dataSuper = " + dataSuper);
		// System.out.println("dataSuper = " + getDataSuper()); // ������ ���
		// printSuper();
		
		// �޼ҵ� �������̵�
		super.print();
		// -> ���� Ŭ������ ����� ���� Ŭ������ ����� �ĺ��ڰ� ���� ���, super Ű���带
		//    �̿��� ���� Ŭ������ ����� ������ �� �ִ�.
		
		System.out.println("dataSub = " + dataSub);
	}
}

public class Ex01 {
	public static void main(String[] args) {
		// SampleSuper Ŭ������ �ν��Ͻ� ����
		SampleSuper objSuper = new SampleSuper(10);
		
		objSuper.print();
		
		// SampleSub Ŭ������ �ν��Ͻ� ����
		SampleSub objSub = new SampleSub(10, 20);
		
		// �޼ҵ� �������̵�(method overriding)
		// objSub.printSub();
		objSub.print();
	}
}
