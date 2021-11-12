package day04;

public class Ex03 {
	public static void main(String[] args) {
		// for 구문을 이용해 1부터 100까지의 자연수들을 순차적으로 확인
		for(int i = 1;i <= 100;i++)
			if(i % 3 == 0 && i % 5 ==0)
			System.out.println("i = " + i);
	}

}
