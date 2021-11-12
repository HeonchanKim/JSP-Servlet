package day13;

/*
 * ���� ǥ���ϴ� Ŭ���� Flower
 * */
class Flower {
	private String name;
	private int price;
	
	// ������
	public Flower(String name, int price) {
		setName(name);
		setPrice(price);
	}
	public Flower() { this(null, 0); }
	// ������
	public void setName(String name) { this.name = name; }
	public void setPrice(int price) { this.price = price >= 0 ? price : 0; }
	
	public void print() {
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println();
	}
}


/*
 * Flower Ŭ������ ��� �޴� Ŭ���� Rose
 */
class Rose extends Flower{
	// ������
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
 * Flower Ŭ������ ��� �޴� Ŭ���� Tulip
 */
class Tulip extends Flower {
	public Tulip() {
		super("Tulip", 200);
	}
}

public class Ex02 {
	public static void main(String[] args) {
		// Rose Ŭ������ Tulip Ŭ������ �ν��Ͻ� ����
		Rose rose = new Rose();
		Tulip tulip = new Tulip();
		
		rose.print();
		tulip.print();
	}
}
