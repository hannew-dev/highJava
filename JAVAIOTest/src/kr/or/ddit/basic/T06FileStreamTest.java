package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 파일출력예제
 * @author PC-04
 *
 */
public class T06FileStreamTest {
	public static void main(String[] args) {
		//파일에 출력하기
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("d:/D_Other/out.txt");//출력,저장
			
			for (char ch = 'a'; ch < 'z'; ch++) {
				fos.write(ch);
			}
			System.out.println("파일쓰기 작업 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/////////////////////////////////////////////////////
		FileInputStream fis= null;
		
		try {
			fis = new FileInputStream("d:/D_Other/out.txt");
			
			int data = 0;
			while ((data = fis.read()) !=-1) {
				System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
