package day06;

public class Ex01 {
	public static void main(String[] args) {	
		// �ٱ��� �ݺ����� �̿��ؼ� ��(rows)�� ǥ��
		for(int i = 1; i <= 9; i++) {
			// ���� �ݺ����� �̿��� ��(columns)�� ǥ��
			for(int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
