package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class T07EqualsHashcodeTest {
	/*
	 * 해시함수 (hash function)는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수이다.
	 * 해시함수에 의해 얻어지는 값은 해시값, 해시코드, 또는 간단히 해시라고 부른다.
	 * 충돌의 가능성이 있기때문에 충돌 최소화하여 설계하여야 한다
	 * 해시는 속도가 빨라야한다.
	 * 해시는 다른것인지는 확실히 구분할 수 있지만 충돌의 가능성이 있기때문에 같은경우에는 equals를 사용하여 확실하게 해줘야한다.
	 * 
	 * HashSet, HashMap, HashTable과 같은 객체들을 사용할 경우
	 * 객체가 서로 같은지를 비교하기 위해 equals()와 hashCode()를 호출한다.
	 * 그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 해야한다.
	 * HashSet, HashMap, HashTable에서 객체가 같은지 여부는 데이터를 추가할 때 검사한다.
	 * 
	 * - equals()는 두 객체의 내용(값)이 같은지 비교하는 메서드이고 
	 * - hashCode()는 두 객체에 대한 해시코드값을 가져오기 위한 메서드이다.=>해시 테이블 작성시 사용됨.
	 * 
	 * **equals()와 hashCode()에 관련된 규칙
	 * 
	 * 1. 두 객체가 같으면 반드시 같은 hashCode를 가져야 한다.
	 * 2. 두 객체가 같으면 equals()를 호출했을때 true를 반환해야 한다.
	 *    즉 객체 a,b가 같으면 a.equals(b)와 b.equals(a) 둘 다 true여야 한다.
	 * 3. 두 객체의 해시코드가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
	 *	     하지만 두 객체가 같으면 반드시 해시코드가 같아야한다.
	 * 4. equals()를 override하면 반드시 hashCode()도 override해야한다.
	 * 5. hashCode()는 기본적으로 Heap에 있는 각 객체에 대한 메모리 주소 매핑정보를 기반으로 한 정수값을 반환한다.
	 * 	    그러므로, 클래스에서 hashCode()를 override하지 않으면 절대로  두 객체가 같은 것으로 간주될 수 없다.
	 * 	    
	 *    -hashCode()에서 사용하는 '해싱 알고리즘'에서 서로 다른 객체에 대하여 같은 해시코드를 만들어 낼 수 있다.
	 *     그래서 객체가 같지 않더라도 해시값이 같을 수 있다.		
	 */
	
		public static void main(String[] args) {
			
			
			System.out.println("Aa의 해시코드 값: "+"Aa".hashCode());
			System.out.println("BB의 해시코드 값: "+"BB".hashCode());//같은값이 나올수 있으니까 equals사용하여 둘다오버라이드 해줘야함
			
			Person p1 = new Person(1, "홍길동");
			Person p2 = new Person(1, "홍길동");
			Person p3 = new Person(1, "이순신");
			
			System.out.println("p1.equals(p2):" + p1.equals(p2)); //new를 사용하여 새로운 객체를 만들어 false 나온다.
			System.out.println("p1 == p2 : " + (p1 == p2));
			
			Set<Person> set = new HashSet<Person>();
			
			System.out.println("add(p1) 성공여부: " + set.add(p1));
			System.out.println("add(p2) 성공여부: " + set.add(p2)); //같다고 판단을 하지 못해서 중복값이 나온다.
			System.out.println("p1,p2 등록 후 데이터: ");
			for (Person p : set) {
				System.out.println(p.getId() + " : " + p.getName());
				
			}
			System.out.println("add(p3) 성공여부: " + set.add(p3));
			System.out.println("p3등록 후 데이터 : ");
			for (Person p : set) {
				System.out.println(p.getId() + " : " + p.getName());
			}
		}

	
	}
	

class Person{
	private int id;
	private String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		
//		Person person = (Person) obj;
//	
//		return this.getId() == person.getId() && this.getName().equals(getName());//아이디와 이름이 같으면 같은 객체라고 오버라이드 해줌.
//	}
//	
//	@Override
//	public int hashCode() {
//		return (this.name +id).hashCode();//스트링클래스의 해시코드 불러서 사용.
//	}
	
}
