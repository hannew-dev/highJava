package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T03ByteArrayIoTest {
	public static void main(String[] args) throws IOException {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		/*
		 * 1.직접 복사하기
		
		outSrc = new byte[inSrc.length];
		for (int i = 0; i < inSrc.length; i++) {
			outSrc[i] = inSrc[i];
		} */
		
		
		/*
		 	2.ArrayCopy를 이용한 방법
		outSrc = new byte[inSrc.length];
		System.arraycopy(inSrc, 0, outSrc, 0, inSrc.length); 
		*/
		
		//스트림 객체 생성하기
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int data = 0; // 읽어온 자료를 저장할 변수
		//read()메서드 => byte단위로 자료를 읽어와 int형으로 변환한다.
		//			=> 더이상 읽어올 자료가 없으면 -1을 반환한다.
		while ((data = bais.read()) != -1) {
			baos.write(data);//출력하기
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
