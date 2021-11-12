package day17;

public class Ex01 {
	public static void main(String[] args) {
		// String ��ü ����
		String str1 = "Hello";
		String str2 = "Hi";
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println();
		
		// String Ŭ������ compareTo �޼ҵ�
		// @return positive str1�� str2���� ū ���
		// @return negative str1�� str2���� ���� ���
		// @return zero str1�� str2�� ���� ���
		
		// ���������� �� (�ƽ�Ű�ڵ��� ũ�⸣ ��())
		if (str1.compareTo(str2) > 0)
			System.out.println("str1 is greater than str2.");
		else if (str1.compareTo(str2) < 0)
			System.out.println("str1 is less than str2.");
		else
			System.out.println("str1 is equal to str2.");
			
		//-----------------------------------------------------------------------------------------------
		// String ��ü ����
		String str3 = "Dream";
		String str4 = "comes true!";
		
		// ���� ������(+)�� �̿��� �� ���ڿ��� ����
		String str5 = str3 + str4;
		
		// ���
		System.out.println("str3 = " +str3);
		System.out.println("str4 = " +str4);
		System.out.println("str5 = " +str5);
		System.out.println();
		
		// ���� ���� ������(+=)�� �̿��ؼ� �� ���ڿ��� �����ؼ� ���ο� Stirng ��ü�� ����
		str3 += str4;
		
		System.out.println("str3 = " +str3);
		
		// ���� ������(+)�� �̿��� �ٸ� �ڷ����� ���� ���ڿ��� ����
		String str6 = "value = " + 10;
		
		System.out.println(str6);
		
		//
		// ���� ������(+)�� �̿��� �ٸ� �ڷ����� ���� ���ڿ��� ����
		int n1 = 7;
		int n2 = 3;
		
		String str7 = n1 + " x " + n2 + " = " + n1 * n2;
		
		System.out.println(str7);
		
		// ���ڿ��� �ٸ� �ڷ����� ������ ��ȯ
		// -> ���� Ŭ����(wrapper class)�� �̿��� ���ڿ��� �ٸ� �ڷ����� ������ ��ȯ
		// -> ���� Ŭ������ ���� �ڷ���(primitve type)�� ���� �ٷ�� ���� ����Ѵ�.
		//    Integer, Double, Char ��
		String str8 = "21";
		
		int num = Integer.parseInt(str8);
		
		double pi = Double.parseDouble("3.141592");
		
		System.out.println("num = " + num);
		System.out.println("pi = " + pi);
		
		// String Ŭ������ length �޼ҵ�
		// -> ���ڿ��� ���̸� ���ϴ� �޼ҵ�
		System.out.println("str7.length = " + str7.length());
		
		
	}
}
