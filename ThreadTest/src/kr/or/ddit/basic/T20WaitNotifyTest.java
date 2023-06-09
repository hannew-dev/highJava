package kr.or.ddit.basic;

public class T20WaitNotifyTest {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();

		ProducerThread pth = new ProducerThread(dataBox);
		ConsumerThread cth = new ConsumerThread(dataBox);

		pth.start();
		cth.start();
	}
}

class DataBox {
	private String data;

	/**
	 * data가 null이 아닐때 data값을 반환하는 메서드
	 * 
	 * @return
	 */
	public synchronized String getData() {
		if (this.data == null) {
			try {
				System.out.println(Thread.currentThread().getName() + "wait()호출");
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String returnData = this.data;
		System.out.println("읽어온 데이터: " + returnData);
		this.data = null;// 데이터제거
		System.out.println(Thread.currentThread().getName() + "notify()호출");
		notify();

		return returnData;

	}

	public synchronized void setData(String data) {
		if (this.data != null) {
			try {
				System.out.println(Thread.currentThread().getName() + "wait()호출");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		this.data = data;// 데이터 설정
		System.out.println("셋팅한 데이터: " + this.data);
	
		System.out.println(Thread.currentThread().getName() + "notify()호출");
		notify();
	}
}

//데이터를 세팅만 하는 스레드

class ProducerThread extends Thread {
	private DataBox dataBox;

	public ProducerThread(DataBox dataBox) {
		super("ProducerThread");
		this.dataBox = dataBox;

	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			String data = "Data-" + i;
			System.out.println("dataBox.setData(" + data + ") 호출");
			dataBox.setData(data);
		}
	}
}

//데이터를 가져오기만 하는 스레드

class ConsumerThread extends Thread {
	private DataBox dataBox;

	public ConsumerThread(DataBox dataBox) {
		super("ConsumerThread");
		this.dataBox = dataBox;

	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			String data = dataBox.getData();
			System.out.println("dataBox.getData(): " + data);
		}

	}

}