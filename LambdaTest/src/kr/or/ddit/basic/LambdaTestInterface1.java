package kr.or.ddit.basic;
//public는 한번만 사용가능. 인터페이스 안에서는 모두 추상메서드
//추상메서드가 하나여야 람다식으로 변경 가능.
@FunctionalInterface
public interface LambdaTestInterface1 {
	//반환값이 없고 매개변수도 없는 추상메서드 선언
	public void test(); 
	//public void test2(); @FunctionalInterface라는 어노테이션을 사용하여 잘못사용하면 에러가 뜬다.
	
	
}

@FunctionalInterface
interface LambdaTestInterface2 {
	//반환값이 없고 매개변수만 있는 추상 메서드 선언
	public void test(int a);
	
	
}

@FunctionalInterface
interface LambdaTestInterface3 {
	//반환값도 있고 매개변수도 있는 추상메서드 선언
	public int test(int a, int b);
	
	
}

