package day18;

import java.util.Scanner;
import java.util.Random;

// 주사위 게임을 나타내는 클래스 DiceGame
class DiceGame {
	private int diceFace;
	private int userGuess;
	
	// 메서드
	private void rollDice() {
		// Random 객체 생성
		Random rand = new Random();
		
		// Random 클래스의 nextInt 메소드를 이용해 1~6 사이의 난수를 생성
		diceFace = rand.nextInt(6) + 1;
	}
	private int getUserInput() {
		// Scanner 객체 생성
		Scanner in = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("Enter your guess: ");
		userGuess = in.nextInt();
		
		// Scanner 객체 제거
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
		// Dice 객체 생성
		DiceGame game = new DiceGame();
		
		 game.startPlaying();
	}
}
