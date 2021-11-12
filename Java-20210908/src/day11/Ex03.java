package day11;

// ������(enumeration)
// -> ���� �ִ� ���(constant)���� ����
// -> Ŭ������ �����̸�, enum Ű���带 �̿��ؼ� ����
enum Days{ // Days�� �ڷ����̵ȴ�
	SUNDAY, MONDAY, TUESDAY, WENDSDAY, THURSDAY, FRIDAY, SATURDAY;
}
enum Types{ // Types�� �ڷ����̵ȴ�
	NOTICE, NORMAL, REPLY;
}

public class Ex03 {
	public static void main(String[] args) {
		/*
		// ������ ǥ���ϴ� ���
		private static final int SUNDAY = 1,
				MONDAY = 2,
				TUESDAY = 3,
				WENDSDAY = 4,
				THURSDAY = 5,
				FRIDAY = 6,
				SATURDAY = 7;
		
		// �Խù��� ������ ǥ���ϴ� ���
		*/
		
		/*
		// ������ ǥ��!
		// sunday = 1, monday = 2, tuesday = 3, .....
		int day = 2;
		
		// ���� day�� ���� ���
		switch (day) {
		case 1:
			System.out.println("Today is Sunday.");
			break;
		case 2:
			System.out.println("Today is Monday.");
			break;
		case 3:
			System.out.println("Today is Tuesday.");
			break;
		//...
		default:
			System.out.println("Invalid value!");
			break;
		}
		*/
		/*
		int day = MONDAY;
		
		// ���� day�� ���� ���
		switch (day) {
		case SUNDAY:
			System.out.println("Today is Sunday.");
			break;
		case MONDAY:
			System.out.println("Today is Monday.");
			break;
		case TUESDAY:
			System.out.println("Today is Tuesday.");
			break;
		//...
		default:
			System.out.println("Invalid value!");
			break;
		}
		*/
		
		// ������ ����
		Days day = Days.MONDAY;
		
		// ���� day�� ���� ���
		switch (day) {
		case SUNDAY:
			System.out.println("Today is Sunday.");
			break;
		case MONDAY:
			System.out.println("Today is Monday.");
			break;
		case TUESDAY:
			System.out.println("Today is Tuesday.");
			break;
		//...
		default:
			System.out.println("Invalid value!");
			break;
		}
		
		// �Խù��� ������ ��Ÿ���� ����
		Types type = Types.NORMAL;
		
		// �ٸ� �ڷ����� �����̹Ƿ� ���� �� ����!
//		if(day == type)
//			System.out.println("Same Value!");
		
	}
}
