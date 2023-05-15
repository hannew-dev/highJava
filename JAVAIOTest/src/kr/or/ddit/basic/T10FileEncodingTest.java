package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class T10FileEncodingTest {
	public static void main(String[] args) throws Exception {
		/*
		 ** OutputStreamWriter => OutputStream을 Writer로 변환해주는 보조스트림** => 이 객체도 출력할 때 '인코딩
		 * 방식 '을 지정해서 출력할 수 있다.
		 */
		// 키보드로 입력한 내용을 파일로 저장하는데
		// out_utf8.txt파일은 'utf-8'방식으로
		// out_ansi.txt파일은 'ms949'방식으로 저장한다.

		InputStreamReader isr = new InputStreamReader(System.in);

		// 파일출력용 스트림

		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_ut8.txt");
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");

		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");// 보조스트림 원하는 인코딩타입 지정가능
		OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "EUC-KR");// 바이트기반을 문자기반으로 저장가능

		int data = 0;

		System.out.println("아무거나 입력하시오");

		while ((data = isr.read()) != -1) {
			osw1.write(data);
			osw2.write(data);

		}
		System.out.println("작업완료!");
		isr.close();
		osw1.close();
		osw2.close();
	}
}
