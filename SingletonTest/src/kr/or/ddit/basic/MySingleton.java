package kr.or.ddit.basic;

public class MySingleton {
/*
 	Singleton =>객체(인스턴스)를 한개만 만들어지게 하는 프로그래밍 방법
 	
 	-싱글턴 클래스를 구성하는 방법
 	1.자기 자신Class의 참조변수를 멤버변수로 선언한다.
 	(이 변수는 private static으로 지정한다)
 	
 	2.생성자를 private로 지정한다.
 	(외부에서 생성자에 접근을 못하게 하기 위해서 즉, 외부에서 new명령을 사용하지 못하게 하기위해)
 	
 	3.객체(인스턴스)는 내부에서 생성해서 이 생성된 객체를 반환하는 메서드를 제공한다.
 	(이 메서드의 이름은 보통  getInstance()으로 지정하고 static으로 선언한다.)
 */
	
	//자기자신의 class의 참조변수를 저장할 멤버 변수 선언
	private static MySingleton single;
	
	
	//생성자를 private으로 지정
	private MySingleton() {
		System.out.println("생성자입니다");
	}
	
	public static MySingleton getInstance() {
		if (single == null) {
			single = new MySingleton();
		}
		return single;
	}
	
	//나머지 내용들은 이 클래스로 처리할 내용들을 기술한다.
	public void displayText() {
		System.out.println("안녕하세요. 싱글턴 객체입니다.");
	}

	
	
}
