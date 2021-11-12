package day15;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		// ���� ����
		int n1, n2;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Dividend: ");
		n1 = in.nextInt();
		
		System.out.print("Divisor: ");
		n2 = in.nextInt();
		
		// ����(exception)
		// -> ���α׷��� ����Ǵ� ���߿� �߻��ϴ� ���� ��Ȳ
		
		// ���� ó��(exception handling)
		// -> ���α׷��� ����Ǵ� ���� �߻��� �� �ִ� ���ܸ� ����ؼ� �ڵ带 �ۼ��ϴ� ��
		// -> ���α׷��� ���������� ���Ḧ �����ϰ�, �������� ���� ���¸� �����ϱ� ���� ���
		// -> try-catch ������ �̿�
		
		try {
			System.out.println("n1 / n2 = " + n1 / n2);
		}
		catch (Exception e) {
			System.out.println("Exception occurs!");
		}
		finally {
			System.out.println("Finally block!");
		}
		
		in.close();
	}
}
