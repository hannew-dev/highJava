package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 프린터기능 제공 보조스트림 예제
 * @author PC-04
 *
 */
public class T14PrintStreamTest {
	public static void main(String[] args) throws IOException {
		
		//PrintStream은 모든 타입의 데이터를 출력할 수 있는 기능을 제공하는 보조스트림이다.
		//PrintStream은 IOException을 발생시키지 않는다.
		
		
		PrintStream out = new PrintStream(
				new FileOutputStream("d:/D_Other/print.txt"));
		
		out.print("안녕하세요. PrintStream 입니다.\n");
		out.println("안녕하세요. PrintStream 입니다.2");
		out.println("안녕하세요. PrintStream 입니다.3");
		out.println(out);//객체출력
		out.println(3.14);
		
		out.close();
		
		////////////////////////////////////////////////////////////////
		/*
		 	PrintStream은 데이터를 문자열로 출력하는 기능을 수행한다.(system.out)
		 	향상된 기느으이 PrintWrier가 추가되었지만 계속 사용되고 있음.
		 	
		 	PrintWriter가 PrintStream보다 다양한 언어의 문자를 처리하는데 적합하다.
		 */
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print2.txt");
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos,"UTF-8"));
		pw.print("안녕하세요. PrintWriter입니다.\n");
		pw.println("안녕하세요. PrintWriter입니다.2");
		pw.println("안녕하세요. PrintWriter입니다.3");
		
		pw.close();
		
	}
	
	
	
}
