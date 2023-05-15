package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class T07FileWriterTest {

	public static void main(String[] args) {
		
		//콘솔 (표준입력장치)와 연결된 문자 스트림 객체 생성하기
		//InputStreamReader =>바이트 기반 스트림을 문자기반 스트림으로 변환해주는 보조스트림이다.
		
		InputStreamReader isr = new InputStreamReader(System.in);
		//보조스트림은 일반스트림이 가지고있는 io기능이 없다. 단독으로 아무것도 할수없음. 
		//2바이트씩 붙여서 처리해주는것뿐이다. 기본스트림이 필수로 필요하다.
		//기본스트림이 읽고 보조스트림이 처리만해줌!
		//일반스트림 하나 만들고 보조스트림을 추가적으로 붙여서 필요한 기능만 구현할수있다.
		//-> 데코레이션 패턴을 이용하여 설계해놨음.
		
		FileWriter fw = null;
		
		//파일 출력용 문자 스트림 객체 생성하기
		try {
			fw= new FileWriter("d:/D_Other/testChar.txt");
			
			int data = 0;
			//int타입은 4바이트
			
			System.out.println("아무거나 입력하세요");
			
			//콘솔에서 입력할때 입력의 끝 표시는 ctrl+Z를 누르면 된다.
			
			while ((data = isr.read())!=-1) {
				fw.write(data);
				
			}
			System.out.println("작업끝");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
