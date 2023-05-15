package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 부모클래스가 Serializable 인터페이스를 구현하고 있지 않은경우 부모객체의 필드값 처리 방법
 * 
 * 1) 부모클래스가 Serializable 인터페이스를 구현하도록 해야한다. 2) 자식클래스에 WriteObject()와
 * readObject()메서드를 이용하여 부모객체의 필드값을 처리할 수 있도록 직접 구현해줘야 한다.
 * 
 * @author PC-04
 *
 */

public class T16NonSerializableParentTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("d:/D_Other/nonSerial.bin"));

		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
		oos.writeObject(child);// 직렬화

		oos.close();

		//////////////////////////////////////////////////////////////////////

		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("d:/D_Other/nonSerial.bin"));

		Child child2 = (Child)ois.readObject(); // 역직렬화 일어남
		System.out.println("parentName : " + child2.getParentName());
		System.out.println("childName : " + child2.getChildName());

		ois.close();

	}
}

//Serializable을 구현하지 않은 부모클래스
//부모가 Serializable하면 자식은 무조건 Serializable
//(Serializable까지 상속이 된다.)

class Parent {
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}

//Serializable 구현한 자식 클래스
class Child extends Parent implements Serializable {
	private String ChildName;

	public String getChildName() {
		return ChildName;
	}

	public void setChildName(String childName) {
		ChildName = childName;
	}
	
	
	
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(getParentName());//수동으로 문자열 저장
		out.defaultWriteObject();//원래 기본 기능 호출
	}
	
	
	/**
	 * 역직렬화 될 때 자동으로 호출됨.
	 * (접근제어자가 private이 아니면 자동으로 호출되지 않음.)
	 * 
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream in)  throws IOException,ClassNotFoundException{
		setParentName(in.readUTF());//수동으로 문자열 값 읽어서 세팅하기
		in.defaultReadObject();//원래 기본기능 호출
		
		
		
	}
	

}