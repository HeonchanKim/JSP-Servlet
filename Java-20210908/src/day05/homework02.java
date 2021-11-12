package day05;

public class homework02 {

	public static void main(String[] args) {
		/*
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= i; j--)
				System.out.print("*");
			System.out.println("");
		}
		*/
		
		int lineCount = 4;  
		int spaceCount = lineCount/2 +1;
		int starCount = 1;
		
		for(int i = 0; i<lineCount; i++) {
			for(int j = 0; j<spaceCount; j++) {
				System.out.print(' ');
			}
			for(int j=0; j<starCount; j++) {
				System.out.print('*');
			}
			for(int j = 0; j<spaceCount; j++) {
				System.out.print(' ');
			}
			spaceCount-=1;
			starCount+=2;
			System.out.println();
		}
	}

}
