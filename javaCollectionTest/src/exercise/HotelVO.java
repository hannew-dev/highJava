package exercise;

public class HotelVO {
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

	@Override
	public String toString() {
		return "HotelVO [roomNum=" + roomNum + ", name=" + name + "]";
	}

}
