package kr.or.ddit.basic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnotationTest {
	public static void main(String[] args) {
		//Reflection 기능을 이용한 메서드 실행하기
		//선언된 메서드 목록 가져오기
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		for (Method m : declaredMethods) {
			System.out.println(m.getName());//메서드명 출력
			
			 Annotation[] annos = m.getDeclaredAnnotations();
			 
			 for (Annotation anno : annos) {
				 if (anno.annotationType().getSimpleName().equals("PrintAnnotation")) {
					 PrintAnnotation printAnn =(PrintAnnotation) anno;
					 
					 for (int i = 0; i < printAnn.count(); i++) {
						System.out.print(printAnn.value());
					}
					
				}
				
			}System.out.println();
		}
		
		
		
		
	}
}
