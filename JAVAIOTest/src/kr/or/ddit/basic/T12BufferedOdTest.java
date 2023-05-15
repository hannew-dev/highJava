package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 문자기반 스트림을 위한 Buffered스트림 사용 예제
 * 
 * @author PC-04
 *
 */
public class T12BufferedOdTest {
	public static void main(String[] args) {

		FileReader fr = null;
		BufferedReader br = null;// 문자기반의 보조스트림

		try {
			fr = new FileReader("./src/kr/or/ddit/basic/T11BufferedIOTest.java");
			br = new BufferedReader(fr);// 입출력 성능향상을 도와줌 (Buffered)

			String tmpStr = ""; // 한줄씩 읽은 데이터를 리턴받기위해 선언
			int cnt = 1;

			while ((tmpStr = br.readLine()) != null) {
				System.out.printf("%4d: %s\n", cnt++, tmpStr);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
