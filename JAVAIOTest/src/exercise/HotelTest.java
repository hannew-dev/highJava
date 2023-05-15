package exercise;

import java.util.Map;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



public class HotelTest {
	public static void main(String[] args) {
		Hotel open = new Hotel();
		open.start();
	}
}


 class Hotel {
	private Scanner scan;
	private Map<String, HotelVO> hotelMap;

	public Hotel() {
		scan = new Scanner(System.in);
		hotelMap = new HashMap<String, HotelVO>();
	}

	public void displayManu() {
		System.out.println("*******************************************\r\n" + "어떤 업무를 하시겠습니까?\r\n"
				+ "1.체크인  2.체크아웃 3.객실상태 4.업무종료\r\n" + "*******************************************\r\n" + "메뉴선택 =>");
	}

	@SuppressWarnings("unchecked")
	public void start() {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		System.out.println("**************************\r\n" + "호텔 문을 열었습니다.\r\n" + "**************************\r\n");
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/hotel.bin")));

			// 불러온 파일을 저장할 객체
			Object obj = null;

			while ((obj = ois.readObject()) != null) {

				// 읽어온 데이터를 원래의 객체의 타입으로 변환 후 담기
				hotelMap = (Map<String, HotelVO>) obj;
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
				System.out.println("불러올 데이터가 없습니다");
			}
		}
		
		while (true) {

			displayManu();

			int menuNum = scan.nextInt();
			switch (menuNum) {
			case 1:
				checkIn();
				break;
			case 2:
				checkedOut();
				break;
			case 3:
				statement();
				break;
			case 4:
				System.out
						.println("**************************\r\n" + "호텔 문을 닫았습니다.\r\n" + "**************************");
				
				try {
					oos = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotel.bin")));

					oos.writeObject(hotelMap);

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
				return;

			default:
				System.out.println("잘못 입력했습니다.");

			}

		}

	}

	private void statement() {
		Set<String> keySet = hotelMap.keySet();

		if (keySet.size() == 0) {
			System.out.println("투숙중인 손님이 없습니다.");
		} else {
			Iterator<String> it = keySet.iterator();

			int list = 0;
			while (it.hasNext()) {
				list++;
				String rookNum = (String) it.next();
				HotelVO h = hotelMap.get(rookNum);
				System.out.println(" " + list + "\t방번호: " + h.getRoomNum() + ",투숙객: " + h.getName());
			}
		}
		
	}

	private void checkedOut() {
		System.out.println("어느 방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력>>");
		scan.nextLine();
		String roomNum = scan.nextLine();

		if (hotelMap.remove(roomNum) == null) {
			System.out.println(roomNum + "방에는 체크인 한 사람이 없습니다.");

		} else {

			System.out.println(roomNum + "방이 체크아웃 되었습니다");
		}
		System.out.println();

	}

	private void checkIn() {
		System.out.println("어떤 방에 체크인 하시겠습니까?");
		System.out.println("방번호 입력>>");
		scan.nextLine();
		String roomNum = scan.nextLine();

		if (hotelMap.get(roomNum) != null) {
			System.out.println(roomNum + "호에는 이미 사람이 있습니다.");
			return;
		}

		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력>>");
		String name = scan.nextLine();

		HotelVO h = new HotelVO(roomNum, name);
		hotelMap.put(roomNum, h);

		System.out.println(name + "님 체크인 되었습니다.");

	}

	
}


 class HotelVO implements Serializable{//Serializable 직렬화의 대상이라는것을 알려줌.
	private String roomNum;
	private String name;

	public HotelVO(String roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
