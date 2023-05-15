package exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import java.util.Map;
import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, String> map = new HashMap<Integer, String>();

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		System.out.println("***************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("***************************");
		System.out.println();

		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/member.bin")));

			// 불러온 파일을 저장할 객체
			Object obj = null;

			while ((obj = ois.readObject()) != null) {

				// 읽어온 데이터를 원래의 객체의 타입으로 변환 후 담기
				map = (Map<Integer, String>) obj;
			}
		} catch (IOException e) {
			// System.out.println("출력 작업 끝...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();

			} catch (IOException e) {
				System.out.println();

			} catch (NullPointerException e) {
				System.out.println("데이터가 없습니다");
			}
		}

		while (true) {
			int roomNum = 0;
			String name;
			System.out.println("***************************");
			System.out.println("어떤 업무를 하시겠습니까?\n");
			System.out.println("1.체크인 2.체크아웃 3.객실상태  4.업무종료");
			System.out.println("***************************");
			System.out.print("메뉴선택 => ");
			int menuNum = Integer.parseInt(sc.nextLine());
			if (menuNum == 1) {
				System.out.println("어느방에 체크인 하시겟습니까?");
				System.out.print("방번호 입력 => ");
				roomNum = Integer.parseInt(sc.nextLine());
				while (true) {
					if (map.keySet().contains(roomNum) == true) {
						System.out.println("해당 방은 체크인 되었습니다.");
						System.out.print("방번호 다시 입력 =>");
						roomNum = Integer.parseInt(sc.nextLine());
						break;
					}
					break;
				}
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 => ");
				name = sc.nextLine();
				map.put(roomNum, name);
				System.out.println("체크인 되었습니다.\n");
			} else if (menuNum == 2) {
				System.out.println("어느방을 체크아웃 하시겠습니까?");
				System.out.print("방번호 입력 => ");
				roomNum = Integer.parseInt(sc.nextLine());
				if (map.get(roomNum) != null) {
					map.remove(roomNum);
					System.out.println("체크아웃되었습니다.");
				} else {
					System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
				}
			} else if (menuNum == 3) {
				Set<Integer> set = map.keySet();
				Iterator<Integer> it = set.iterator();
				if (set.size() == 0) {
					System.out.println("투숙중인 고객이 없습니다.");
				} else {
					while (it.hasNext()) {
						roomNum = it.next();
						System.out.println("방번호 : " + roomNum + ", 투숙객 : " + map.get(roomNum));
					}
				}
			} else {
				System.out.println("***************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("***************************\n");
				try {
					oos = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream("d:/D_Other/member.bin")));

					oos.writeObject(map);

					System.out.println("데이터 저장 완료");
				} catch (IOException ex) {
					ex.printStackTrace();

				} finally {
					try {
						oos.close();

					} catch (IOException e) {
						e.printStackTrace();

					}
				}
				break;
			}
		}
	}
}
