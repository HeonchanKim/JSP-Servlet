package day07;

public class Ex02 {

	public static void main(String[] args) {
		
		// ���� ����
		int[] numbers = {1, 3, 4, 2, 1, 3, 4, 1, 2, 3, 1, 3};
		
		// �迭 numbers�� ���ҵ� �߿��� 1, 2, 3, 4�� ������ ������ �迭
		int[] counts = new int[5];
		// -> counts[1] = 1�� ����
		// -> counts[2] = 2�� ����
		// -> counts[3] = 3�� ����
		// -> counts[4] = 4�� ����
		// -> counts[5] = 5�� ����
		
		// �ݺ����� �̿��� �迭 numbers�� ���ҵ� �߿��� 1, 2, 3, 4�� ������ ���
		
		for(int item : numbers)
			counts[item]++;
			
		/*
		for(int item = 0; item < numbers.length; item++)
			counts[numbers[item]]++;
		*/
		// ���
		for (int i = 1; i <= 4; i++) {
			// ���� ���
			System.out.print(i + " ");
		
			// 1, 2, 3, 4�� ������ŭ "*"�� ���
			for (int j = 0; j < counts[i]; j++) System.out.print("*");
			
			// ����
			System.out.println();
		}
	}
}
