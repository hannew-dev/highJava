package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class T09FileEncodingTest {
	/*
	 * 한글 인코딩 방식은 크게 UTF-8 과 EUC-KR방식 두가지로 나누워 볼 수 있다. 한글윈도우는 cp949방식을 사용했는데 윈도를 개발한
	 * 마이크로소프트에서 EUT-KR방식에서 확장하였기 떄문에 MS949라고도 한다. 한글 윈도우의 메모장에서 이야기하는 ANSI인코딩이란
	 * CP949(Code Page 949)를 말한다. CP949는 EUC_KR의 확장이며 하위 호환성이 있다
	 * 
	 * - Ms949=>윈도우의 기본 한글 인코딩 방식(ANSI계열) - UTF-8=> 유니코드 UFT-8인코딩 방식(영문자 및 숫자: 1byte
	 * 한글 : 3byte)=> 가변적 - US-ASCII => 영문전용 인코딩 방식
	 * 
	 * ANSI에는 영어를 표기하기위해 만든 코드규격으로 자체에 한글이 없었다가 나중에 여기에 한글이 포함되면서 EUC-KR, CP949등으로
	 * 확장되었다.
	 * 
	 * 
	 * - 유니코드 => 서로 다른 문자 인코딩을 사용하는 컴퓨터간의 문서교환에 어려움을 겪게되고, 이런 문제점을 해결하기위해 전 세계의 모든
	 * 문자를 하나의 통일된 문자집합(Char set)으로 표현
	 */

	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader isr = null;

		try {
			// fis = new FileInputStream("d:/D_Other/test_ansi.txt");//기본스트림
			fis = new FileInputStream("d:/D_Other/test_utf8.txt");// 기본스트림

			// 파일인코딩 정보를 이용하여 읽어오기
			// 형식) new InputStreamReader(바이트기반 스트림, 인코딩방식)
			// isr = new InputStreamReader(fis,"CP949");//보조스트림
			isr = new InputStreamReader(fis, "UTF-8");// 보조스트림

			int data = 0;

			while ((data = isr.read()) != -1) {
				System.out.print((char) data);

			}
			System.out.println();
			System.out.println("!!출력끝!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isr != null) {

					isr.close();// 보조스트림만 닫아도 된다.(보조스트림을 닫으면 기본스트림 먼저 닫아버리고 보조스트림이 닫힌다)
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
