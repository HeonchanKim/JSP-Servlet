package day13;

/*
 * 꽃을 표현하는 클래스 Flower
 * */
class Flower {
	private String name;
	private int price;
	
	// 생성자
	public Flower(String name, int price) {
		setName(name);
		setPrice(price);
	}
	public Flower() { this(null, 0); }
	// 설정자
	public void setName(String name) { this.name = name; }
	public void setPrice(int price) { this.price = price >= 0 ? price : 0; }
	
	public void print() {
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println();
	}
}


/*
 * Flower 클래스를 상속 받는 클래스 Rose
 */
class Rose extends Flower{
	// 생성자
	/*
	public Rose(String name, int price) {
		super(name, price);
		}
	*/
	public Rose() {
		super("Rose", 100);
	}
}


/*
 * Flower 클래스를 상속 받는 클래스 Tulip
 */
class Tulip extends Flower {
	public Tulip() {
		super("Tulip", 200);
	}
}

public class Ex02 {
	public static void main(String[] args) {
		// Rose 클래스와 Tulip 클래스의 인스턴스 생성
		Rose rose = new Rose();
		Tulip tulip = new Tulip();
		
		rose.print();
		tulip.print();
	}
}
