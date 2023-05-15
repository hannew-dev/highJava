package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 기본타입 입출력 보조 스트림 예쩨
 * @author PC-04
 *
 */
public class T13DataIOStreamTest {
	public static void main(String[] args) {
		
		FileOutputStream fos= null;
		//DataOutputStream => 출력용 데이터를 자료형에 맞게 출력해준다.
		DataOutputStream dos = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream("d:/D_Other/test.dat"));
			
			dos.writeUTF("홍길동");	//문자열 데이터 출력 (UTF-8)
			dos.writeInt(17);		//정수형데이터 출력
			dos.writeFloat(3.14f);	//실수형(Float)으로 출력
			dos.writeDouble(3.14);	//실수형(Double)으로 출력
			dos.writeBoolean(true);	//논리형으로 출력
			System.out.println("출력 완료!");
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//읽기시작
		DataInputStream dis = null;
		
		try {
			dis = new DataInputStream(
					new FileInputStream("d:/D_Other/test.dat"));
			
			System.out.println("문자열 자료: " + dis.readUTF());
			System.out.println("정수형 자료: " + dis.readInt());//저장한 순서(타입)가 잘 맞아야한다. 
			System.out.println("실수형(Float) 자료: " + dis.readFloat());
			System.out.println("실수형(Double) 자료: " + dis.readDouble());
			System.out.println("논리형 자료: " + dis.readBoolean());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
