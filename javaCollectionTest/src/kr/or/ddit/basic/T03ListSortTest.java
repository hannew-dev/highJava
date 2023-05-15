package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03ListSortTest {
	public static void main(String[] args) {
		/*
		 * 정렬과 관련된 interface는 Comparable과 Comparator 이렇게 두가지가 있다.
		 * 
		 * -보통 객체 자체에 정렬기능을 넣기 위해서는 Comparable을 구현하고
		 * 정렬기준을 별도로 구현하고 싶은 경우에는 Comparator를 구현하여 사용하면 된다.
		 */
		
		List<String> list = new ArrayList<String>();
		list.add("일지매");
		list.add("홍길동");
		list.add("변학도");
		list.add("이순신");

		System.out.println("정렬 전: "+ list);
		
		//정렬은 Collection.sort()메서드를 이용하여 정렬한다.
		//정렬은 기본적으로 *오름차순* 정렬을 수행한다.
		
	    Collections.sort(list);
	    System.out.println("정렬  후: " + list);
	    
	    Collections.shuffle(list);
	    System.out.println("데이터 섞기 후: "+ list);
	    
	    // 정렬방식을 결정하는 객체를 이용하여 정렬하기.
	    Collections.sort(list, new Desc());
	    System.out.println("외부 정렬자를 이용한 정렬 후: "+ list);
	    
	    
	    
	    
	    
	    
	    
	}
}

class Desc implements Comparator<String>{
	/*
	 *compare() 메서드의 반환값을 결정하는 방법
	 *
	 * 오름차순 정렬인 경우...
	 *  =>앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 한다.
	 	
	 	- String 객체에는 정렬을 위해서 이미 compareTo() 메서드가 구현되어 있는데 
	 	     이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다.
	 	  (Wrapper클래스와 Date, File 클래스 등에도 구현되어 있다.)
	 */
	
	@Override
	public int compare(String str1, String str2) {
		// TODO Auto-generated method stub
		return str1.compareTo(str2) * -1;//-1을 곱해주면 내림차순으로 정렬된다.
	}
	
}



