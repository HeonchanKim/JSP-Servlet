package day09;

// Ŭ���� ����
class Sample{
	// �ʵ� ����
	private int data;
	
	// �޼ҵ� ����
	
	// ������(setter)
	public void setData(int n) {
		// data = n;
		
		// �����ڿ����� ��� ������ �߸��� ���� ���� �ʵ��� ������ ���� �˻��Ѵ�!
		data = n > 0 ? n : 0;
	} 
	
	// ������(getter)
	public int getData() {
		return data;
	}
	
	public void print() {
		System.out.println("data = " + data);
	}
}

public class Ex02 {
	public static void main(String[] args) {
		// ��ü(object) ����
		Sample obj = new Sample();
		
		// obj.data = 10;
		obj.setData(10);
		
		obj.print();
		
		System.out.println("obj.data = " + obj.getData());
	}
}
