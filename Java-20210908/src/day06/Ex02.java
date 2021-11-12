package day06;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
				
		// 높이가 A미터인 나무에 올라가고자한다.
		// 달팽이는 낮 시간 동안 B미터를 올라갈수있다. 그런데 밤에 잠을 자는 동안 C미터 만큼미끄러진다.
		// 꼭대기에 올라가면 미끄러지지않는다. 올라가는데 며칠이 걸리지는지 구하여라
		
		// 변수 선언
		int treeheight;         // 나무높이
		int riseDay;            // 낮시간 이동거리
		int slidingNight;       // 밤에 미끄러지는 거리
		int snailHeight = 0;    // 달팽이의 현재높이
		int days = 0;           // 며칠이 지났는가!

		// 사용자 입력
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the tree height : ");
		treeheight = in.nextInt();
		System.out.print("Enter the height that rises during the day : ");
		riseDay = in.nextInt();
		System.out.print("Enter the sliding height at night : ");
		slidingNight = in.nextInt();
		System.out.println();
		
		
		// 무한 반복을 이용해 달팽이가 나무 꼭대기에 도달할 때까지 반복문을 수행
		
		while (true) {
			// 날짜 증가
			days++;
			
			//낮 시간 동안 달팽이가 올라간 높이를 계산
			snailHeight += riseDay;
			
			// 달팽이가 나무 꼭대기에 도달했는지 검사
			if(snailHeight >= treeheight) break;
			
			// 밤 시간 동안 달팽이가 미끄러지는 높이를 계산
			snailHeight -= slidingNight;
		}
		
		// 출력
		System.out.printf("It takes %d days for the snail to climb the tree.", days);
		
		in.close();
	}
}
