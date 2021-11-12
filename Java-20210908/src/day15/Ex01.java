package day15;

// ������ ���� Ŭ���� SampleSuper
class SampleSuper {
	private int dataSuper;
	
	public SampleSuper(int n) { dataSuper = n; }
	public SampleSuper() { this(0); }
	
	public void setDataSuper(int n) { dataSuper = n; }
	public int getDataSuper() { return dataSuper; }
	
	void print() {
		System.out.println("dataSuper = " + dataSuper);
	}
	
	public static void printStatic() {
		System.out.println("SampleSuper::printStatic");
	}
}

// ������ ���� Ŭ���� SampleSub
class SampleSub extends SampleSuper {
	private int dataSub;
	
	public SampleSub(int n1, int n2) {
		super(n1);
		dataSub = n2;
	}
	
	public SampleSub() { this(0, 0); }
	
	public void setDataSub(int n) { dataSub = n; }
	public int getDataSub() { return dataSub; }
	
	@Override
	public void print() {
		super.print();
		System.out.println("dataSub = " + dataSub);
	}
	
	public static void printStatic() {
		System.out.println("SampleSub::printStatic");
	}
	
	
}

public class Ex01 {
	public static void main(String[] args) {
		// ��ü ����
		SampleSuper objSuper = new SampleSuper(10);
		SampleSub objSub = new SampleSub(20, 30);
		
		objSuper.print();		  // SampleSuper::print();
		SampleSuper.printStatic();
		System.out.println();
		
		objSub.print();			  // SampleSub::print();
		SampleSub.printStatic();
		System.out.println();
		
		// ���� Ŭ������ ���� ������ ���� Ŭ������ ��ü�� ������ �� �ִ�!
		objSuper = objSub;
		
		objSuper.print();		  // SampleSub::print(); (�������ε�)
		System.out.println();
		
		// �޼ҵ带 ȣ���� �� � �޼ҵ带 ȣ������ �����ϴ� ���(���ε�; binding)
		// 1. ���� ���ε�(static binding)
		//    -> ������ �ܰ迡�� ���� ������ �ڷ����� ���� � �޼ҵ带 ȣ������ ����
		//    -> ���� �޼ҵ�(Ŭ���� �޼ҵ�)�� ��쿡�� ���� ���ε��� �Ѵ�.
		// 2. ���� ���ε�(dynamic binding)
		//    -> ���α׷� ���� �ܰ迡�� � �޼ҵ带 ȣ������ ����
		//    -> ���� ������ �ڷ����� �ƴ϶� ���� ������ �����ϴ� ��ü�� �ڷ����� ����
		//       � �޼ҵ带 ȣ������ �����Ѵ�!
		//	  -> Java ���α׷������� �ν��Ͻ� �޼ҵ�(�Ϲ� �޼ҵ�)�� ���� ���ε��� �Ѵ�.
		
		// ���� Ŭ������ �迭 ����
		SampleSuper[] list = new SampleSuper[3];
		
		// ��ü�� �����ؼ� �迭�� �� ���ҿ� ����
		list[0] = new SampleSuper(100);
		list[1] = new SampleSub(200, 300);
		list[2] = new SampleSuper(400);
		
		// �ݺ����� �̿��� �迭 list�� �� ���ҿ� ���������� ����
		for (int i = 0; i < list.length; i++)
			list[i].print();
		
	}
}
