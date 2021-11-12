package day05;

public class Ex04 {
	public static void main(String[] args) {
		
		// 누적해서 합계를 저장할 변수는 반드시 0으로 초기화해야 한다.
		int sum = 0;
		
		
		// 반복문을 이용해 변수 sum에 1에서 100까지의 자연수를 누적해서 더한다.
		for(int i = 1; i <= 100; i++)
			sum += i;
		
		// 출력
		System.out.print("sum += " + sum);

	}

}
