package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 바이트 기반의 Buffered 스트림 예제
 * 
 * @author PC-04
 *
 */
public class T11BufferedIOTest {
	public static void main(String[] args) {
		// 입출력 성능 향상을 위해 버퍼를 이용하는 보조스트림

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");
			// 바이트기반의 보조스트림. 보조기능: 버퍼기능제공
			// 버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8192bytes로 설정된다.
			// 버퍼의 크기가 5인 스트림 생성
			bos = new BufferedOutputStream(fos, 5);// 다섯개 쌓여야 한번 처리.
			// 효율적으로 저장하기위해 사용

			for (char ch = '1'; ch <= '9'; ch++) {// 숫자 자체를 문자로 저장하기.
				// System.out.println("나야!");-> 포문 9번 돌아감.
				bos.write(ch);
				// 버퍼는 5개가 차야 한번 저장됨, 4개가 남음!-> flash 사용하면 나머지 4개도 저장됨.
			}

			bos.flush();// 작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다.
			// (close시 자동 호출되어 사용하지 않아도 되지만 오류가 날때 있어서 알아둬야함..)

			System.out.println("작업끝!!!!!!!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();// close하면 자동으로 flush먼저 작동하고 close된다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
