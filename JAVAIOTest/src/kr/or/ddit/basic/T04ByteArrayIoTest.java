package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04ByteArrayIoTest {
	public static void main(String[] args) throws IOException {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];//자료를 읽고 쓸 때 사용할 배열 선언.
		
		//스트림객체 사용
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int readbytes = 0; //읽어온 byte수 저장.
		
		while ((readbytes = bais.read(temp)) != -1) {
			System.out.println("와일문 실행");
			System.out.println("temp => " +Arrays.toString(temp));
			baos.write(temp,0,readbytes);//출력하기
		}
		
		//출력된 데이터를 바이트 배열로 반환하는 메서드 호출
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc => "+Arrays.toString(inSrc));
		System.out.println("outSrc => "+Arrays.toString(outSrc));
		
		//스트림 객체 닫아주기
		bais.close();
		baos.close();
		
		
	}
}
