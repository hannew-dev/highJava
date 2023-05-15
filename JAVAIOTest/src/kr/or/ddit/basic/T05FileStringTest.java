package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 파일 읽기 예제
 * @author PC-04
 *
 */
public class T05FileStringTest {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(new File("d:/D_Other/test.txt"));
			
			int data = 0;
			//읽어온 값이 -1이면 파일의 끝까지 읽었다는 의미이다.
			while ((data = fis.read())!= -1) {
				//읽어온 데이터 콘솔에 출력하기
				System.out.print((char)data);//아스키코드로 표현할 수 있는 문자만 출력
				//1바이트만 출력가능 1바이트 넘어가는 데이터 출력못한다.(한글은 출력못함.)
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
}
