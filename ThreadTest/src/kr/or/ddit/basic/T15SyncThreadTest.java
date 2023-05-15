package kr.or.ddit.basic;

public class T15SyncThreadTest {
	public static void main(String[] args) {
		
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번 스레드", sObj);
		WorkerThread th2 = new WorkerThread("2번 스레드", sObj);
		th1.start();
		th2.start();
		
	}
}

//공통으로 사용할 객체
class ShareObject{
	private int sum = 0;
	
	
	
	
	//동기화 : 이상증상이 나타나지 않음, 나혼자 객체 쓰고 그다음에 다음객체 들어와서 사용.느리다.->가급적 사용하지 않는것이 좋음.
	//공유객체에서 순서대로 사용하게 교통정리해줌!
	
	//동기화 하는 방법 1: 메서드 자체에 동기화 설정하기.
 	//synchronized public void add() {
	
	
		public void add() {
			//동기화 하는 방법2: 동기화 블럭으로 설정하기.
			//mutex: 공유객체(나 자신일떄: this)
			//synchronized (this) {
				
		for (int i = 0; i < 1000000000; i++) {} // 동기화 처리 전까지 시간벌기용
		int n = sum;
		
		n+= 10;
		
		sum = n;
		
		System.out.println(Thread.currentThread().getName()+ "합계 : "+sum);
			}
	}
//}

//작업을 수행하는 스레드
class WorkerThread extends Thread{
	private ShareObject sObj;
	
	public WorkerThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}	
	
	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			//동기화 하는 방법3.
			synchronized (sObj) {
				sObj.add();
				
			}
		}
	
	}
	
}

