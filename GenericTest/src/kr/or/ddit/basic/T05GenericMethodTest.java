package kr.or.ddit.basic;

class Util2{
	
	public static <T extends Number> int compare(T t1, T t2) {//T extends Number를 상속받은 타입만 올 수 있다.(타입제한을 걸어버린것)
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
		
	}
}

/**
 * 제한된 타입 파라미터 (Bounded Parameter) 예제
 *
 */

public class T05GenericMethodTest {//제한된 타입 파라미터 정할것임.
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20);//뒤가크면 음수.
		System.out.println(result1);
		
		int result2 = Util2.compare(3.14, 3);//앞이크면 양수
		System.out.println(result2);
	}

	
}
