package kr.or.ddit.basic;

public class T19WaitNotifyTest {
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
		
	}
}
//공통으로 사용할 객체

class WorkObject{
	public synchronized void methodA() {
		System.out.println("methodA() 메서드에서 작업 중...");
		
		System.out.println(Thread.currentThread().getName()
				+"notify() 호출");
		notify();
		
		try {
			System.out.println(Thread.currentThread().getName()
					+"wait() 호출");
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void methodB() {
		System.out.println("methodB() 메서드에서 작업 중...");
		System.out.println(Thread.currentThread().getName()
				+"notify() 호출");//공유객체에서 기다리는것 깨우기위해.
		
		notify();
		
		try {
			System.out.println(Thread.currentThread().getName()
					+"wait() 호출");
			wait(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//WorkObject의 methodA만 호출하는 스레드 클래스.
class ThreadA extends Thread{
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		super("ThreadA ");
		this.workObj = workObj;
		
	}
	
	@Override
	public void run() {
		for (int i = 1; i <=10; i++) {
			workObj.methodA();
		}
		System.out.println("ThreadA 종료");
	}
}

//WorkObject의 methodB만 호출하는 스레드 클래스.
class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		super("ThreadB ");
		this.workObj = workObj;
		
	}
	
	@Override
	public void run() {
		for (int i = 1; i <=10; i++) {
			workObj.methodB();
		}
		System.out.println("ThreadB 종료");
	}
}