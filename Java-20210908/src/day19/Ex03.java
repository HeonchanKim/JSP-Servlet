package day19;

// Ÿ�� �Ű������� �ĺ��� ����
// T : �ڷ���(type)
// U, V, W, ... ��
// E : ���(Element)
// K : Ű(key)
// V : ��(value)

// Ÿ�� �Ű������� 2���� �������̽� ����
interface Pair<K, V> {
	public K getKey();
	public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V>{
	private K key;
	private V value;
	
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public OrderedPair() { this(null, null); }
	
	public K getKey() { return key; }
	public V getValue() { return value; }
	
}

public class Ex03 {
	public static void main(String[] args) {
		// OrededPair ��ü ����
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Age", 20);
		Pair<String, String> p2 = new OrderedPair<String, String>("Name","Harry porter");
		
		// Pair<String, Integer> p1 != Pair<String, String> p2 �� �ڷ����� ���� �ٸ���!!!
		// �ڷ����� Pair<String, Integer>�� Pair<String, String> �̴�!
		
		System.out.println(p1.getKey() + ": " + p1.getValue());
		System.out.println(p2.getKey() + ": " + p2.getValue());
	}
}
