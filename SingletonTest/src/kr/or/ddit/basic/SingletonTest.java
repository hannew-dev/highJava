package kr.or.ddit.basic;

public class SingletonTest {
	public static void main(String[] args) {
		//MySingleton test1 = new MySingleton();->프라이빗이라 오류남
		
		MySingleton test2 = MySingleton.getInstance();
		test2.displayText();
		
		MySingleton test3 = MySingleton.getInstance();
		test3.displayText();
		
		System.out.println("test2 => "+test2);
		System.out.println("test3 => "+test3);
		
		
		
	}
}
