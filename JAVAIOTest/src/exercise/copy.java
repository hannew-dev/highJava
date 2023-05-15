package exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class copy {
public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		
		try {
			//복사할 파일 객체 가져오기
			fis = new FileInputStream(new File("d:/D_Other/라봉이.jpg"));
			//복사된 파일
			fos = new FileOutputStream(new File("d:/D_Other/라봉이_copy.jpg"));
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int data = 0;
			//읽어온 값이 -1이면 파일의 끝까지 읽었다는 의미이다.
			while ((data = fis.read())!= -1) {
				//읽어온 데이터 콘솔에 출력하기
				fos.write(data);;//아스키코드로 표현할 수 있는 문자만 출력
				//1바이트만 출력가능 1바이트 넘어가는 데이터 출력못한다.(한글은 출력못함.)
			}
			System.out.println("출력완료");
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
