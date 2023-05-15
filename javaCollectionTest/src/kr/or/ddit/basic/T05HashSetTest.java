package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class T05HashSetTest {
	public static void main(String[] args) {
		Set hs1 = new HashSet();
		//set 에 데이터를 추가할때도 add를 사용한다.,특정위치에 삽입은 불가하다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set 데이터:" +hs1);
		System.out.println();
		
		//Set은 데이터의 중복을 허용하지 않는다
		//그래서 이미 있는 데이터를 add하면 false를 반환하고 데이터는 추가되지 않는다
		
		boolean isAdded = hs1.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdded);
		System.out.println("Set데이터 : "+ hs1);
		System.out.println();
		
		isAdded = hs1.add("CC");
		System.out.println("중복될때 : " + isAdded);
		System.out.println("Set데이터 : "+ hs1);
		//set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 해당 데이터를 삭제한 후 새로운 자료를 추가해주어야 한다.
		
		//삭제하는 메서드
		//1)clear()=> 전체 데이터 삭제
		//2)remove(삭제할 자료) => 해당 데이터 삭제
		
		//ex)'FF'를 'EE'로 수정하기 
		hs1.remove("FF");
		System.out.println("삭제 후 Set데이터: "+hs1);
		System.out.println();
		
		hs1.add("EE");
		System.out.println("추가 후 Set 데이터 : "+ hs1);
		System.out.println();
		
		//전체자료 삭제
		// hs1.clear();
		
		System.out.println("Set의 데이터 개수: "+ hs1.size());
		System.out.println();
		
		//set는 데이터의 인덱스 개념이 없기 때문에 List처럼 인덱스를 통한 데이터를 가져올 수 없다.
		//그래서 가져오기위해  Iterator를 이용해야 한다.
		Iterator it = hs1.iterator();
		
		//데이터 개수만큼 반복하기
		//hasNext() => 포인터를 다음 위치에 데이터가 있으면  true 없으면 false 반환
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
		//1~100사이의 중복되지 않은 정수 5개 만들기
		Set<Integer> intRnd = new HashSet<Integer>();
		
		while (intRnd.size()<5) {
			int num = (int)(Math.random()*100+1);
			intRnd.add(num);
			
		}
		
		System.out.println("만들어진 난수들: "+intRnd);
		//Collection유형의 객체들은 서로 다른 자료구조로 쉽게 변경해서 사용할 수 있다.
		//다른 종류의 객체를 생성할 때 생성자에 변경할 데이터를 넣어주면 된다.
		List<Integer> intRndList = new ArrayList<Integer>(intRnd);//리스트 타입이 되어서 인덱스가 생겨버림!
		
		System.out.println("List의 자료 출력: ");
		for (Integer num : intRndList) {
			System.out.println(num+"");
		}
		
		
	}
}
