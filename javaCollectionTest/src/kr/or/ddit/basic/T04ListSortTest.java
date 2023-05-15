package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04ListSortTest {
	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1,"홍길동","010-1111-1111"));
		memList.add(new Member(2,"변학도","010-1111-2222"));
		memList.add(new Member(3,"성춘향","010-1111-3333"));
		memList.add(new Member(4,"이순신","010-1111-4444"));
		memList.add(new Member(5,"강감찬","010-1111-5555"));
		memList.add(new Member(6,"일지매","010-1111-6666"));
		
		System.out.println("정렬 전: ");
		for (Member m : memList) {
			System.out.println(m);
		}
		System.out.println("-----------------------------------------");
		
		Collections.sort(memList);
		
		System.out.println("이름의 오름차순으로 정렬 후: ");
		for (Member m : memList) {
			System.out.println(m);
		}
		System.out.println("-----------------------------------------");
		
		Collections.shuffle(memList);//섞어주기
		
		Collections.sort(memList,new SortNumDesc());
		
		System.out.println("번호의 내림차순으로 정렬 후: ");
		for (Member m : memList) {
			System.out.println(m);
		}
		
		System.out.println("-----------------------------------------");
		
		
		
	}
}

class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		// TODO Auto-generated method stub
		if(mem1.getNum() > mem2.getNum()) {
		 return -1;//내림차순
		}else if(mem1.getNum() ==  mem2.getNum())
		
		return 0;
		else {
			return 1;
		}
	}
	
}

class Member implements Comparable<Member>{
	
	private int num;
	private String name;
	private String tel;
	
	
	
	public Member(int num, String name, String tell) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tell;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}






	}
	
