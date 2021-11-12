package day18;

// 난수를 만들기 위해 Random 클래스를 포함
import java.util.Random;


public class Ex01 {
	public static void main(String[] args) {
		// Wrapper 클래스의 변환 메소드
		int i = Integer.parseInt("10");             // 10
		long l = Long.parseLong("10000");		    // 10000
		
		float f = Float.parseFloat("3.14");         // 3.14
		double d = Double.parseDouble("3.141592");  // 3.141592
		
		String str1 = Integer.toString(10);         // "10"
		String str2 = Integer.toHexString(10);      // "A"
		String str3 = Integer.toBinaryString(10);   // "1010" (2진수)
		// ---------------------------------------------------------------------
		// 오토 박싱(auto-boxing)
		// -> Wrapper 객체와 원시 자료형 사이의 값 사이의 형 변환을 자동으로 수행
		Integer box;
		
		box = 10;
		// -> box = Integer(10);
		
		System.out.println("box + 1 = " + (box + 1));
		// -> System.out.println("box + 1 = " + ((int)box + 1));
		
		
		// ---------------------------------------------------------------------
		// Random 객체 생성
		Random random = new Random();
		
		// 1부터 100 사의 난수를 10개 생성
		for (int j = 0; j < 10; j++)
			System.out.println(random.nextInt(100) + 1);
			// random.nextInt(100) = 0 <= n < 100
		
		
	}
}
