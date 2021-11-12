package day05;

public class Ex05 {

	public static void main(String[] args) {
		
		// 반복문을 이용해 변수 sum에 1부터 1000까지의 자연수들 중에서 7의 배수들을 누적해서 더한다.
		int sum = 0;
		
		for(int i = 7; i <= 1000; i+= 7)
			sum += i;
		
		// 출력
		System.out.print("The sum of multiples of 7 between 1 and 1000 is " + sum);
		// ----------------------------------------------------------------------------------
				
			
	}
}
