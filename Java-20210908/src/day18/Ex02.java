package day18;

import java.util.Scanner;
import java.util.Random;

// �ֻ��� ������ ��Ÿ���� Ŭ���� DiceGame
class DiceGame {
	private int diceFace;
	private int userGuess;
	
	// �޼���
	private void rollDice() {
		// Random ��ü ����
		Random rand = new Random();
		
		// Random Ŭ������ nextInt �޼ҵ带 �̿��� 1~6 ������ ������ ����
		diceFace = rand.nextInt(6) + 1;
	}
	private int getUserInput() {
		// Scanner ��ü ����
		Scanner in = new Scanner(System.in);
		
		// ����� �Է�
		System.out.print("Enter your guess: ");
		userGuess = in.nextInt();
		
		// Scanner ��ü ����
		in.close();
		
		return userGuess;
	}
	
	private void checkUserGuess() {
		
		if (diceFace == userGuess)
			System.out.println("Excellent! You got it!");
		else
			System.out.println("Oops! Wrong number.");
		
		System.out.println("The dice face is " + diceFace + ".");
	}
	
	public void startPlaying() {
		System.out.println("Let's enjoy the dice game!\n");
		
		rollDice();
		getUserInput();
		checkUserGuess();
	}
}

public class Ex02 {
	public static void main(String[] args) {
		// Dice ��ü ����
		DiceGame game = new DiceGame();
		
		 game.startPlaying();
	}
}
