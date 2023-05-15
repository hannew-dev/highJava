package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 외부의 properties 파일을 읽어와 Properties객체로 처리하기
 * @author PC-04
 *
 */
public class T02PrepertiesTest {
	public static void main(String[] args) {
		//읽어온 정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		
		//읽어올 파일명을 이용한 File 객체 생성하기
		File file = new File("res/db.properties");
		
		try {
			//파일을 읽기위해 스트림 객체 생성
			FileInputStream fis = new FileInputStream(file);
			
			//Properties 객체를 이용하여 읽기
			prop.load(fis);
			
			//읽어온 데이터 출력하기
			
			Enumeration<String> keys = 
					(Enumeration<String>)prop.propertyNames();
			
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + " => " + value);
				
			}
			System.out.println("출력~끝~!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
