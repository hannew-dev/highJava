package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T08MapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		// 데이터 추가하기 => put(key 값, value 값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map => "+ map);
		
		//자료 수정하기 => 데이터를 저장할 때 key값이 같으면 나중에 입력한 값이 저장된다.
		//		   => put(수정할 key값, 새로운 value값)
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		//데이터 삭제 => remove (삭제할 데이터의 key값)
		map.remove("name");
		System.out.println("map => " + map);
		
		//데이터 가져오기 => get(가져올 value의 key값)
		System.out.println("addr => "+ map.get("addr"));
		System.out.println("==================================================");
		
		//key값을 읽어와서 데이터를 출력하는 방법
		
		//방법1 =>keySet()메서드를 이용하기
		//keySet() => Map의 key값들만 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();//keySet - key값으로 존재하는 집합
		
		System.out.println("Iterator를 이용하는 방법");
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key+" : "+map.get(key));
			

		}
		System.out.println("-------------------------------------------------");
		
		//방법2 => Set형의 데이터를 '향상된 for'문으로 처리하면 Iterator를 사용하지 않아도 된다.
		
		System.out.println("향상된 for문 (for-each)을 이용한 방법");
		for (String key : keySet) {
			System.err.println(key + " : "+map.get(key));
			
		}
		
		System.out.println("--------------------------------------------------");
		
		//방법3 => value값만 읽어와 출력하기 : values() 이용하기
		
		System.out.println("values() 이용하는 방법");
		for (String value : map.values()) {
			System.out.println(value);
			
		}
		
		System.out.println("--------------------------------------------------");
		
		//방법4 => Map관련 클래스에서는 Map.Entry타입의 내부 클래서가 만들어져 있다.
		//	      Map에서 Map.Entry타입의 객체들은 Set형식으로 저장하여 관리한다.
		
		//Map.Entry타입의 객체 모두가져오기 (가져온 Entry 타입의 객체들은 Set 형식으로 되어있다.)
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		//가져온 Entry객체들을 접근하기 위해 iterator객체 사용하기
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator(); //=>2번방법으로 꺼내보기! Iterator사용하지않고!
		while (entryIt.hasNext()) {
			Map.Entry<String,String> entry =  entryIt.next();
			
			System.out.println("Key값: "+entry.getKey());
			System.out.println("value값: "+entry.getValue());
			System.out.println();
			
		}
	}
}

















