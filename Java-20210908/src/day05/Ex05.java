package day05;

public class Ex05 {

	public static void main(String[] args) {
		
		// �ݺ����� �̿��� ���� sum�� 1���� 1000������ �ڿ����� �߿��� 7�� ������� �����ؼ� ���Ѵ�.
		int sum = 0;
		
		for(int i = 7; i <= 1000; i+= 7)
			sum += i;
		
		// ���
		System.out.print("The sum of multiples of 7 between 1 and 1000 is " + sum);
		// ----------------------------------------------------------------------------------
				
			
	}
}
