package day19;

// 타입 매개변수의 식별자 관례
// T : 자료형(type)
// U, V, W, ... 등
// E : 요소(Element)
// K : 키(key)
// V : 값(value)

// 타입 매개변수가 2개인 인터페이스 정의
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
		// OrededPair 객체 생성
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Age", 20);
		Pair<String, String> p2 = new OrderedPair<String, String>("Name","Harry porter");
		
		// Pair<String, Integer> p1 != Pair<String, String> p2 의 자료형은 서로 다르다!!!
		// 자료형은 Pair<String, Integer>과 Pair<String, String> 이다!
		
		System.out.println(p1.getKey() + ": " + p1.getValue());
		System.out.println(p2.getKey() + ": " + p2.getValue());
	}
}
