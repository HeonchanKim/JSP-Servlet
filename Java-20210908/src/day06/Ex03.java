package day06;

public class Ex03 {

	public static void main(String[] args) {

		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		for(int i = 0; i < numbers.length;i++)
			System.out.printf("number[%d] = %d\n",i,numbers[i]);
			System.out.println();
		//---------------------------------------------------------
		
		int[] scores = {88, 92, 76, 64, 86, 96, 82, 78};
		
		// 80���� ū ���� ���
		for(int i = 0; i < scores.length; i++)
			if(scores[i] > 80)
			System.out.printf("scores[%d] = %d\n",i,scores[i]);
			System.out.println();
		
		// �հ� ���
		
		int sum = 0;
		double average;
		
		
		for(int item : scores)
				sum += item;
		
		// ��� ���
		average = (double)sum / scores.length;
		
		// ���
		System.out.printf("sum = %d\n", sum);
		System.out.printf("average = %f", average);
		
		
		
	}

}
