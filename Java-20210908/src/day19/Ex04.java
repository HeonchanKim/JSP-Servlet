package day19;

// �迭�� ���õ� ����� �����ϴ� Ŭ���� Array
class Array {
	
	/*
	 * 
	 * ���׸� �޼ҵ�(method)
	 * -> �޼ҵ忡�� Ÿ�� �Ű������� ����� ���׸� �޼ҵ带 ����
	 * -> �̶� Ÿ�� �Ű������� ������ �޼ҵ� ���η� ���ѵȴ�. 
	 * */
	public static <T> T getLast(T[] list) {
		return list[list.length - 1];
	}
}
public class Ex04 {
	public static void main(String[] args) {
		// String �迭 ����
		String[] languages = { "C++", "C#", "Java" };
		
		// ���׸� �޼ҵ带 ȣ���� �� Ÿ�� �Ű������� ������ �ڷ����� �����Ѵ�.
		// String last = Array.<String>getLast(languages);
		
		// ���ƿ� ���� �ڷ����� ������ �� �ִٸ�, Ÿ�� �Ű������� ������ �ڷ����� ������ �� �ִ�.
		String last = Array.getLast(languages);
		
		System.out.println("last = " + last);
	}
}
