package day07;

public class Ex04 {
	public static void main(String[] args) {
		
		// 2���� �迭 ����
		int[][] numbers = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};

		// ��ø �ݺ����� �̿��� 2���� �迭�� ��� ���ҵ鿡 ����
		
		// �ٱ��� �ݺ����� �̿��� ��(row)�� ǥ�� - 2���� �迭�� �� ������ �迭�� ����
		for(int i = 0; i < numbers.length; i++) {
			// ���� �ݺ����� �̿��� ��(columns)�� ǥ�� - 2���� �迭�� �� ������ �迭�� ����
			for(int j = 0; j < numbers[i].length; j++)
				System.out.printf("numbers[%d][%d] = %d\n", i, j, numbers[i][j]);
		}
	}
}
