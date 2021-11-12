package day07;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		// Scanner ��ü ����
		Scanner in = new Scanner(System.in);
		
		// ���� ����
		final int NUM_COINS = 10;   			 // �� ������ �ִ� ����
		int[] coinUnits = {500, 100, 50, 10};    // �������� ����
		int amount;								 // �Ž�����
		int num;								 // �Ž����� ������ ����	
		
		// ����� �Է�
		System.out.print("Enter the amount to be repaid : ");
		amount = in.nextInt();
		System.out.println();
		
		// �ݺ����� �̿��� 500��¥�� �������� �Ž����ش�!
		for (int unit : coinUnits) {
			// �Ž����� ������ ������ ���
			num = amount / unit;
			
			// �Ž����� ������ �ִ� ���
			if (num > 0) {
				// �Ž����� ������ �ִ� ������ 10���̴�!
				num = num > NUM_COINS ? NUM_COINS : num;
				
				// ���� ������ ������ �Ž����ְ� ���� �ܾ��� ���
				amount -= unit * num;
				
				// ���
				System.out.printf("%d won coins = %d\n", unit, num);
			}
		}
		
		// Scanner ��ü �ݱ�
		in.close();
	}
}
