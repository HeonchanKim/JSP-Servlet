package day03;

public class Ex02 {

	public static void main(String[] args) {
		
		// ���� ����
				int n1 = 3;
				int n2 = 7;
				
				// ���� n1�� n2 �߿��� ���� ���� ���
				int min = n1 < n2 ? n1 : n2;
				// ���
				System.out.printf("The smaller of %d and %d is %d\n", n1, n2, min);
				
				//------------------------------------------------------------------
				double factor = 123.456789123;
				
				System.out.printf("n1 = |%d|\n", n1);
				System.out.printf("n1 = |%2d|\n", n1);
				System.out.printf("n1 = |%02d|\n", n1);
				
				System.out.printf("factor = %f\n", factor);
				System.out.printf("factor = %e\n", factor);
				System.out.printf("factor = %g\n", factor);
				
				System.out.printf("factor = %.2f\n", factor);
				
				//------------------------------------------------------------------
				// String.format �޼���
				// -> System.out.printf �޼ҵ�� ����ϰ� ���� ���ڿ��� �̿��� ���ڿ� ����
				String str = String.format("n1 = %03d", n1);
				
				System.out.println(str);
				System.out.printf("str = %s\n", str);
				
	}

}
