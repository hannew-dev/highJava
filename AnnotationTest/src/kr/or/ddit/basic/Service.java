package kr.or.ddit.basic;

@PrintAnnotation
public class Service {
	
	@PrintAnnotation
	public void method1() {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value = "%")//value이름인경우 ,value만 사용하는경우 ("%")만 사용해도 된다. 
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value = "#",count = 25)
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}
}
