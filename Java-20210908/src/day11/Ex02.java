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
		// 배열 생성
		int[] numbers = new int[10];
		
		// 객체 배열 생성
		// -> 객체 배열은 객체를 참조하는 참조 변수들의 배열이다.
		Sample2[] samples = new Sample2[5];
		
		for (int i = 0; i < samples.length; i++) {
			// 객체 배열의 각 원소에 들어가는 객체는 따로 생성해야 한다.
			samples[i] = new Sample2(i + 1);
		
			samples[i].print();
		}
	}
}
