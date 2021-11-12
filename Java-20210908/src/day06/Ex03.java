package day06;

public class Ex03 {

	public static void main(String[] args) {

		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		for(int i = 0; i < numbers.length;i++)
			System.out.printf("number[%d] = %d\n",i,numbers[i]);
			System.out.println();
		//---------------------------------------------------------
		
		int[] scores = {88, 92, 76, 64, 86, 96, 82, 78};
		
		// 80보다 큰 원소 출력
		for(int i = 0; i < scores.length; i++)
			if(scores[i] > 80)
			System.out.printf("scores[%d] = %d\n",i,scores[i]);
			System.out.println();
		
		// 합계 평균
		
		int sum = 0;
		double average;
		
		
		for(int item : scores)
				sum += item;
		
		// 평균 계산
		average = (double)sum / scores.length;
		
		// 출력
		System.out.printf("sum = %d\n", sum);
		System.out.printf("average = %f", average);
		
		
		
	}

}
