package kr.or.ddit.basic;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class T03ResourceBundleTest {
	/*
	 * ResourceBundle 객체 => 확장자가 properties인 파일 정보를 읽어와
	 * 		key값과 value 값을 분리한 정보를 갖는 객체
	 * 
	 * => 읽어올 파일은 'key값 = value값' 형태로 되어 있어야 한다.
	 * 
	 *	소스폴더는 컴파일대상!
	 */
	
	public static void main(String[] args) {
		//ResorceBunble 객체를 이용하여 파일 읽어오기
		
		//ResorceBunble객체에 생성하기
		// 			=> 파일을 지정 할 때는 '파일명'만 지정하고 확장자는 지정하지 않는다.
		//				(확장자는 항상 .properties이기 때문에)
		
		System.out.println("현재 기본 로케일정보 => "+ Locale.getDefault());
		//로케일: 언어 지역설정 통화 등등~ 출력형식
		
		ResourceBundle bundle = ResourceBundle.getBundle("db", Locale.ENGLISH);
		//저장되어있는 언어 형식의 properties가 없으면 디폴드값으로 나온다.
		
		//key값들만 읽어오기
		Enumeration<String> keys = bundle.getKeys();
		
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			
			String value = bundle.getString(key);
			
			System.out.println(key + " => " + value);
		}
		
		System.out.println("출력 끝!!!!!!!!!!!");
	}
}
