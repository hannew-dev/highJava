package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	/*
	 * 와일드 카드에 대하여,, 와일드 카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의 인수
	 * (Argument)로서 변수선언, 객체생성 및 메서드 정의할 때 사용된다.(제너릭 타입 선언시에 사용할 수 없다.)
	 * 
	 * <? extend T> => 와일드 카드의 상한 제한. T 와 그 자손들만 가능. 
	 * <? super T>  => 와일드 카드의 하한제한. T와 그 조상들만 가능. 
	 * <?>			=> 모든타입이 가능 <?extends Object>와 동일
	 */
	
	
	
	public static void main(String[] args) {
		FriutBox<Fruit> friutBox = new FriutBox<>();
		FriutBox<Apple> appleBox = new FriutBox<>();
		FriutBox<Garbage> garbageBox = new FriutBox<>();
		
		garbageBox.add(new Garbage("음쓰"));
		garbageBox.add(new Garbage("폐타이어"));
		garbageBox.add(new Garbage("재활용 쓰레기"));
		
		friutBox.add(new Apple());
		friutBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		Juicer.makeJuice(friutBox);
		Juicer.makeJuice(appleBox);
		//Juicer.makeJuice(garbageBox);//->제한된 타입 파라미터 사용했기 때문에 오류가 난다. 과일만 쥬서에 들어갈 수 있게 했다.
		
	}
}



//쥬서클래스
 class Juicer{
//	 static <T extends Fruit> void makeJuice(FriutBox<T> box) {
		 static void makeJuice(FriutBox<?extends Fruit> box)//?사용시 일반메서드를 가지고 제너릭하게 만들 수 있다.
		 {

		 String fruitStr = "";//과일목록
		 
		 int cnt = 0;
		 for(Object f: box.getFruitList()) {
			 if(cnt == 0) {
				 fruitStr += f;
			 }else {
				fruitStr += ","+f;
			}
			 cnt++;
		 }
		 
		 System.out.println(fruitStr+"=>쥬스완성!!!");
		 
	 }
 }


	class Fruit {
		private String name;

		public Fruit(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "과일 (" + name + ")";
		}

	}

	class Apple extends Fruit {
		public Apple() {
			super("사과");
		}
	}

	class Grape extends Fruit {
		public Grape() {
			super("포도");
		}
	}
	
	class Garbage{
		private String name;

		public Garbage(String name) {
			this.name = name;
			
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		} 
	}

	
	/**
	 * 과일상자
	 * @author PC-04
	 *
	 * @param <T>
	 */
	class FriutBox<T> {
		private List<T> fruitList;

		public FriutBox() {
			fruitList = new ArrayList<>();
		}

		public List<T> getFruitList() {
			return fruitList;
		}

		public void add(T fruit) {
			this.fruitList.add(fruit);
		}

	}
