package exercise06;

public class Time {
	//필드
	private int hour;
	private int minute;
	private int second;
	
	// 생성자
	public Time() {
		this.hour=0;
		this.minute=0;
		this.second=0;
	}
	public Time(int hour, int minute, int second) {
		super();
		if (hour>=0&&hour<=23) {
			this.hour = hour;
		}else {
			hour = 0;
		}
		if (minute>=0&&minute<=59) {
			this.minute = minute;
			
		} else {
			minute = 0;
		}
		if (second>=0&&second<=59) {
			this.second = second;
			
		} else {
			second = 0;
		}
	}

	
	//메소드
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour,minute,second);
	}
	
	
	
	
	
}
