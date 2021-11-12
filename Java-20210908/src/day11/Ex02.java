package day11;

class Sample2{
	private int data;
	
	public Sample2(int n) { data = n;}
	public Sample2() { this(0); }
	
	public void setData(int n) { data = n;}
	public int getData() { return data;}
	public void print() { System.out.println("data = " + data); }
}

public class Ex02 {
	public static void main(String[] args) {
		// �迭 ����
		int[] numbers = new int[10];
		
		// ��ü �迭 ����
		// -> ��ü �迭�� ��ü�� �����ϴ� ���� �������� �迭�̴�.
		Sample2[] samples = new Sample2[5];
		
		for (int i = 0; i < samples.length; i++) {
			// ��ü �迭�� �� ���ҿ� ���� ��ü�� ���� �����ؾ� �Ѵ�.
			samples[i] = new Sample2(i + 1);
		
			samples[i].print();
		}
	}
}
