package day11;

// ������ Ŭ���� Sample
class Sample {
	// �ʵ� = �ν��Ͻ� ����(instance variable)
	// -> ������ �ν��Ͻ�(��ü)�鸶�� �����Ǵ� ����
	// -> ��ü�� �Ҹ��ϸ� �ν��Ͻ� ������ �Ҹ��Ѵ�.
	private int data;
	
	// ���� ����(static variable) = Ŭ���� ����
	// -> Ŭ������ �ϳ��� �����ϸ�, Ŭ������ ��� �ν��Ͻ����� �����Ѵ�.
	// -> ���� ������ ��ü�ʹ� �����ϰ� �����ϸ�, ���α׷��� ����Ǹ� ����ǰ� �ʱ�ȭ�ȴ�.
	// -> ��ü�� �Ҹ���� ��� ���� ���α׷��� ����� ������ �����ȴ�.
	private static int numSamples = 0;
	
	// ��� �ʵ�(constant field)
	// -> �����ڿ��� �ʱ�ȭ
	// private final int MAX;
	
	// ���� ���
	// -> ����� �ʵ尡 ��� �ν��Ͻ����� ���� ���� ������, ���� ����� �����ϴ� ���� ����.
	private static final int MAX = 255;
	
	public Sample(int n) {
		data = n;
		
		// ������ �ݵ�� �����ϸ鼭 �ʱ�ȭ�ؾ� �Ѵ�.
		// ��� �ʵ�� �����ڿ��� �ʱ�ȭ�Ѵ�.
		// MAX = 255;
		numSamples++;
		
		System.out.println("number of Sample = " + numSamples);
		}
	public Sample() { this(0); }
	
	public void setData(int n) { data = n;}
	public int getData() { return data; }
	
	public void print() { System.out.println("data = " + data); }
	
	// ���� �޼���(static method)
	// -> ���� ������ ��ü�� �����Ǳ� ������ ���������, �Ϲ� �޼ҵ�� ��ü�� �����Ǿ��
	//    ȣ���� �� �ִ�.
	// -> ���� �޼ҵ�� ��ü�� �����Ǳ� ������ ȣ���� �� �ִ�.
	//    ���� �����޼ҵ忡���� ���� ������ ���� �޼ҵ忡�� ������ �� �ִ�.
	//    ���� this Ű���带 ����� �� ����.
	public static int getNumSamples() { return numSamples; }
	public static void printNumSamples() { System.out.println("numSamples = " + numSamples); }
}

public class Ex01 {
	public static void main(String[] args) {
		
		// main �޼ҵ�� ���� �޼ҵ��̹Ƿ�, ���� �޼ҵ常 ȣ���� �� �ִ�.
		
		// ���(constant)
		final double factor = 0.98;
		
		Sample.printNumSamples();
		
		// ���� ������ ��ü�� �����Ǳ� ���� ����ǰ� �ʱ�ȭ�ȴ�.
		// System.out.println("obj1. numSamples = " + Sample.numSamples); 
		// ��ü ����
		Sample obj1 = new Sample(10);
		Sample obj2 = new Sample(20);
	
		// ���� ������ ���� ��� public�̶�� �ص� ���� ������ ���� ������ �� ����!
		// System.out.println("obj1. numSamples = " + obj.1numSamples); // WRONG!!
		
		// ��ü �ܺο��� ���� ����(Ŭ���� ����)�� ������ ���� ���� ������ �����ϴ� �� �ƴ϶�
		// Ŭ���� �ĺ��ڸ� �̿��� �����ؾ� �Ѵ�.
		// System.out.println("obj1. numSamples = " + Sample.numSamples);
		
		// ���� �޼ҵ�� ���� ������ �ƴ϶� Ŭ���� �ĺ��ڸ� ���� �����ؾ� �Ѵ�.
		// obj1.printNumSamples(); // WRONG!!
		Sample.printNumSamples();
		
		obj1.print();
		obj2.print();
	}
}
