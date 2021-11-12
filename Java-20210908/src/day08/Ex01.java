package day08;

public class Ex01 {
	public static void main(String[] args) {
		// 2���� �迭 ����
		int[][] scores = {
				{87, 43, 64, 71},
				{65, 69, 77, 82},
				{91, 84, 62, 76}
		};
		
		// 2���� �迭 scores�� ���� ����
		int rows = scores.length;
		
		// 2���� �迭 scores�� ���� ����
		int columns = scores[0].length;
		
		// 2���� �迭 scores�� �� ���� �հ踦 ������ �迭
		int[] sumColumn = new int[4];
		
		// ���
		double average;
		
		// ��ø �ݺ����� �̿��� 2���� �迭 scores�� �� ���� �հ踦 ���
		// -> �ٱ��� �ݺ����� ��(rows)�� ǥ��, ���� �ݺ����� ��(columns)�� ǥ��
		for (int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				sumColumn[j] += scores[i][j];
		
		// ����� ����� �� ���
		for (int i = 0; i < columns; i++) {
			average = (double)sumColumn[i] / rows;
			
			System.out.printf("%dth column : sum = %d, average = %.2f\n", i + 1, sumColumn[i], average);
		}
		// ----------------------------------------------------------------------------------------------
		System.out.println();
		
		// �� ���� �հ踦 ������ ����
		int sum = 0;
		
		// ��ø �ݺ����� �̿��� 2���� �迭 scores�� �� ���� �հ踦 ���
		// -> �ٱ��� �ݺ����� ��(columns)�� ǥ��, ���� �ݺ����� ��(rows)�� ǥ��
		for (int i = 0; i < columns; i++) {
			// �հ踦 ������ ������ �ʱ�ȭ
			sum = 0;
		
			// �� �࿡�� ���� ���� ������ �հ踦 ���
			for(int j = 0; j < rows; j++)
				sum += scores[j][i];
			
			// ��� ���
			average = (double)sum / rows;
			
			// ���
			System.out.printf("%dth column : sum = %d, average = %.2f\n", i + 1, sum, average);
		}
		
	}
}
