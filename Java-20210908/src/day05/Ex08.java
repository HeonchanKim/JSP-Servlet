package day05;

public class Ex08 {

	public static void main(String[] args) {
		
		// ��ø �ݺ����� �̿��� ������ ���
		
		// �ٱ��� �ݺ����� �̿��� ���� ǥ��
		for(int i = 1; i <= 9; i++) {
			// ���� �ݺ����� �̿��� ���� ǥ��
			for(int j = 2; j <= 9; j++)
				System.out.printf("%2d", j*i);
			
			// ����
			System.out.println();
		}

	}

}
