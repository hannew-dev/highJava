package kr.or.ddit.basic;

public class T01ArgsTest {
	/*
	 * 가변형인수 => 메서드의 매개변수의 개수가 실행될 때마다 다를때 사용한다.
	 * 
	 * - 가변형 인수는 메서드 안에서는 배열로 처리된다.
	 * - 가변형 인수는 한가지 자료형만 사용할 수 있다.
	 */
	public int sumArr(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	//가변형 인수를 이용한 메서드 선언
	
	public int sumArg(int...data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	//가변형 인수와 일반적인 인수를 같이 사용할 경우에는 *가변형 인수를 제일 뒤쪽에 배치해야한다.
	
	public static String sumArg2(String name, int...data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return name+"님 점수: "+ sum;
	}
	
	
	
	
	public static void main(String[] args) {
		T01ArgsTest at = new T01ArgsTest();
		
		int[] nums = {100, 200, 300};
		System.out.println(at.sumArr(nums));
		System.out.println(at.sumArr(new int[] {1,2,3,4,5}));
		System.out.println();
		
		System.out.println(at.sumArg(100,200,300));
		System.out.println(at.sumArg(1,2,3,4,5));
		System.out.println();
		
		System.out.println(sumArg2("홍길동", 1,2,3,4,5,6,7,8));
//		-> 스테틱 메서드 객체생성 하지 않아도 된다. 같은클래스안에 있기때문에 호출을 따로 하지않아도 된다.
		
		
		
	}
}
