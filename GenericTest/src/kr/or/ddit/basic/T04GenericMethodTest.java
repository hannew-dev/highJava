package kr.or.ddit.basic;

class Util {
	/*
	 * 제너릭 메서드 <T,R> R method(T t)
	 * 
	 * 파라미터 타입과 리턴타입으로 타입파라미터를 가지는 메서드
	 * 리턴타입 앞에 꺽쇠 사용.
	 * 
	 * 선언방법 => 리턴타입 앞에 <> 기호를 추가하고 타입글자를 기술 후 사용한다.
	 * 
	 */
	
	public static <K, V> boolean compare(Pair<K,V> p1, Pair <K,V> p2) {//타입 여러개 명시가능, 멀티타입가능. 
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valyeCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valyeCompare;

	}
}
/**
 * 멀티타입<K,V>를 가지는 제너릭 클래스
 * @author PC-04
 *
 * @param <K>
 * @param <V>
 */
class Pair<K,V>{
	private K key;
	private V value;
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	//키와 값을 모두 출력
	public <K,V> void printAll(K key, V val) {
		System.out.println(key + " : "+ val);
	}
}


public class T04GenericMethodTest {
	public static void main(String[] args) {
		Pair<Integer,String> p1 = new Pair<Integer, String>(1,"홍길동");
		Pair<Integer,String> p2 = new Pair<Integer, String>(1,"홍길동");
		
		boolean result1 = Util.<Integer,String>compare(p1, p2);//compare가 제너릭 메서드이기 때문에 호출시 타입 말해줘야한다.
		
		if (result1) {
			System.out.println("두 객체는 의미적으로 같은 객체임");
		}else {
			System.out.println("두 객체는 의미적으로 다른 객체임");
		}
		Pair<String,String> p3 = new Pair<String,String>("001", "홍길동");
		Pair<String,String> p4 = new Pair<String,String>("002", "홍길동");
		
		boolean result2 = Util.compare(p3, p4);//파라미터 타입으로 유추가능하기때문에 타입 생략도 가능하다.(위에것과 비교)
		
		if (result2) {
			System.out.println("두 객체는 의미적으로 같은 객체임");
		} else {
			System.out.println("두 객체는 의미적으로 다른 객체임");
		}
		
		p1.<String,Integer>printAll("키", 180);// 제너릭 클래스의 일반 메소드는 제너릭클래스 따라가야하지만 제너릭메서드는 그만의 타입을 가질수있다.제너릭클래스 따라가지 않아도 됨.
		
	}
}


