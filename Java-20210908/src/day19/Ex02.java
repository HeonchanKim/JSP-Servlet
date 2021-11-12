package day19;

/*
 * 
 * ���׸� Ŭ����(generic class)
 * -> �ʵ� �Ǵ� �޼ҵ忡�� �پ��� �ڷ����� ����� �� �ֵ��� �ϴ� Ŭ����
 * -> �̷��� �پ��� �ڷ����� "Ÿ�� �Ű�����(type parameter)"�� �̿��ؼ� ǥ���Ѵ�.
 *    Ÿ�� �Ű��������� ��ü�� �����ϸ鼭 ������ �ڷ����� ���޵ȴ�.
 * -> Ÿ�� �Ű������� ���޵Ǵ� �ڷ����� �ݵ�� Ŭ�����̾�� �Ѵ�!
 * */

class Box<T> {
	private T data;
	
	Box(T data) { this.data = data; }
	Box() { this(null); }
	public void set(T data) { this.data = data; }
	public T get() { return data; }
}

public class Ex02 {
	public static void main(String[] args) {
		// Integer �ڷ����� Box ��ü ����
		Box<Integer> num = new Box<Integer>(10);
		
		System.out.println("num = " + num);
		
		// num.set("Hello World!");          // Syntax error!
		
		// String �ڷ����� Box ��ü ����
		Box<String> str = new Box<String>("Hello World!");
		
		System.out.println("str = " + str);
		
		// str.set(10);                      // Syntax error!
	
		// Integer value = (Integer)str.get();  // Syntax error!
		
		// Ÿ�� �Ű��������� ���� �ڷ���(primitive type)�� ���޵� �� ����!
		// Box<int> n2 = new Box<int>(10);      //WRONG!
		
		// ���׸� Ŭ������ ��ü�� ������ ��, Ÿ�� �Ű������� ������ �ڷ����� ������ �� �ִ�.
		// �̶� ���ƿ� ���� �����Ϸ��� �ڷ����� �����Ѵ�.
		Box<String> str2 = new Box<>("Do your best!");
		
		System.out.println("str2 = " + str2);
	}
}
