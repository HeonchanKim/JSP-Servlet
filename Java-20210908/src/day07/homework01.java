package day07;

public class homework01 {
	public static void main(String[] args) {
		
		
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		int count = 0;
		
		int[][] scores = {
				{87, 43, 64, 71},
				{65, 69, 77, 82},
				{91, 84, 62, 76}
		};
		
		
		for(int i = 0; i < scores.length; i++) {
			sum1 += scores[i][0];
			count += i;
		}
		System.out.printf("1th column : sum = %d, average = %f\n", sum1, (double)sum1/count);
		
		for(int i = 0; i < scores.length; i++) {
			sum2 += scores[i][1];
		}
		System.out.printf("2th column : sum = %d, average = %f\n",sum2, (double)sum2/count);		
		
		for(int i = 0; i < scores.length; i++) {
			sum3 += scores[i][2];
		}
		System.out.printf("3th column : sum = %d, average = %f\n",sum3, (double)sum3/count);			
		
		for(int i = 0; i < scores.length; i++) {
			sum4 += scores[i][3];
		}
		System.out.printf("4th column : sum = %d, average = %f\n",sum4, (double)sum4/count);			
		
	}
}
