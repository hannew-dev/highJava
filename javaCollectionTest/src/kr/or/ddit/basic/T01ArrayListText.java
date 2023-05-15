package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T01ArrayListText {
	public static void main(String[] args) {
	
		List list1 = new ArrayList();//Default_Capacity = 10(따로 정하지 않았을때 10으로 자동으로 정해진다.) 
		//List list1 = new LinkedList();로 변경해도 사용가능 결과값도 같다(인터페이스)
		//배열은 크기를 초반에 정한다. 크기가 정해지지 않은 배열은 만들수가 없다.
		
		//add() 메서드를 사용하여 데이터 추가
		list1.add("aaa");
		list1.add("bbb");
		list1.add(new Integer(111));
		list1.add(new Character('k'));
		list1.add(new Boolean(true));
		list1.add(new Double(12.34));// new를 사용해서 형변환 안해줘도 자동으로 변환해준다.
		
		//size() => 데이터 개수 확인
		
		System.out.println("size => "+ list1.size());
		System.out.println("list1 = >" + list1);
		
		//get()으로 데이터 꺼내오기
		System.out.println("1번째 자료: "+ list1.get(0));
		
		//데이터 끼워넣기
		list1.add(0,"zzz");//오버로드.파라미터 종류만 다르게해서 만드는것--add(인덱스번호, 값)
		System.out.println("list => "+ list1);
		
		//데이터 변경하기
		String temp = (String) list1.set(0,"YYY");
		System.out.println("temp =>" + temp);
		System.out.println("list1 => "+list1);
		
		//데이터 삭제하기
		list1.remove(0);//인덱스번호 넣어서 삭제
		System.out.println("첫번째 데이터 삭제 후: "+ list1);
		
		list1.remove("bbb");//object 값을 넣어 그 값 삭제
		System.out.println("bbb삭제 후:"+list1);
		System.out.println("--------------------------------------");
			
		
		
		//list1.remove(111);//int값을 넣으면 인덱스번호임.
		list1.remove(new Integer(111));// 이렇게 넣어야 111값이 지워진다.
		
		//contains (비교객체) => 리스트에 '비교객체'가 있으면 true 없으면 false
		System.out.println(list1.contains("aaa"));
		System.out.println(list1.contains("ccc"));
		
		//indexOf(비교객체) => 리스트에 '비교객체'를 찾아 '비교객체'가 있는 index값을 반환.(없으면 -1 반환된다.)
		System.out.println("aaa의 index값: "+ list1.indexOf("aaa"));
		System.out.println();
		
		//------------------------------------------------------------------------------
		for (int i = 0; i < list1.size(); i++) {
			list1.remove(i);
		}
		System.out.println("list1의 개수: " + list1.size());
		//지워지고 한칸씩 당겨지기 때문에 이렇게 실행하면 2개가 남는다.다 지우고싶으면 역순으로 지워라.
		
}
}
