package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T03LambdaTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("일지매");
		list.add("이순신");
		
		for (String str : list) {
			System.out.println(str);
		}
		list.forEach((str)->System.out.println(str));
	}
}
