package day06;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
				
		// ���̰� A������ ������ �ö󰡰����Ѵ�.
		// �����̴� �� �ð� ���� B���͸� �ö󰥼��ִ�. �׷��� �㿡 ���� �ڴ� ���� C���� ��ŭ�̲�������.
		// ����⿡ �ö󰡸� �̲��������ʴ´�. �ö󰡴µ� ��ĥ�� �ɸ������� ���Ͽ���
		
		// ���� ����
		int treeheight;         // ��������
		int riseDay;            // ���ð� �̵��Ÿ�
		int slidingNight;       // �㿡 �̲������� �Ÿ�
		int snailHeight = 0;    // �������� �������
		int days = 0;           // ��ĥ�� �����°�!

		// ����� �Է�
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the tree height : ");
		treeheight = in.nextInt();
		System.out.print("Enter the height that rises during the day : ");
		riseDay = in.nextInt();
		System.out.print("Enter the sliding height at night : ");
		slidingNight = in.nextInt();
		System.out.println();
		
		
		// ���� �ݺ��� �̿��� �����̰� ���� ����⿡ ������ ������ �ݺ����� ����
		
		while (true) {
			// ��¥ ����
			days++;
			
			//�� �ð� ���� �����̰� �ö� ���̸� ���
			snailHeight += riseDay;
			
			// �����̰� ���� ����⿡ �����ߴ��� �˻�
			if(snailHeight >= treeheight) break;
			
			// �� �ð� ���� �����̰� �̲������� ���̸� ���
			snailHeight -= slidingNight;
		}
		
		// ���
		System.out.printf("It takes %d days for the snail to climb the tree.", days);
		
		in.close();
	}
}
