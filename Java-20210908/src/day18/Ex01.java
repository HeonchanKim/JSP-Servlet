package day18;

// ������ ����� ���� Random Ŭ������ ����
import java.util.Random;


public class Ex01 {
	public static void main(String[] args) {
		// Wrapper Ŭ������ ��ȯ �޼ҵ�
		int i = Integer.parseInt("10");             // 10
		long l = Long.parseLong("10000");		    // 10000
		
		float f = Float.parseFloat("3.14");         // 3.14
		double d = Double.parseDouble("3.141592");  // 3.141592
		
		String str1 = Integer.toString(10);         // "10"
		String str2 = Integer.toHexString(10);      // "A"
		String str3 = Integer.toBinaryString(10);   // "1010" (2����)
		// ---------------------------------------------------------------------
		// ���� �ڽ�(auto-boxing)
		// -> Wrapper ��ü�� ���� �ڷ��� ������ �� ������ �� ��ȯ�� �ڵ����� ����
		Integer box;
		
		box = 10;
		// -> box = Integer(10);
		
		System.out.println("box + 1 = " + (box + 1));
		// -> System.out.println("box + 1 = " + ((int)box + 1));
		
		
		// ---------------------------------------------------------------------
		// Random ��ü ����
		Random random = new Random();
		
		// 1���� 100 ���� ������ 10�� ����
		for (int j = 0; j < 10; j++)
			System.out.println(random.nextInt(100) + 1);
			// random.nextInt(100) = 0 <= n < 100
		
		
	}
}
