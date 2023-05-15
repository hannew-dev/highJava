package kr.or.ddit.basic;

public class T02ThreadTest {
	public static void main(String[] args) {
		//멀티스레드 프로그램 방식
		//thread는 반드시 start로 실행을  시작한다.
		//start는 새로운 스레드를 생성한다. 스레드가 작업하는데 사용될 호출스택을 생성한다.
		//start를 호출하지않고 run만 호출한다면 메인스레드만 사용되어진다.

		
		// 방법1: *Thread클래스를 상속*한 class의 인스턴스를 생성한 후
		// 이 인스턴스의 start()를 호출한다.
		// 다중상속이 되지 않기때문에 다중상속시에는 2번방법을 사용한다.
		
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		
		//방법2: *Runnable인터페이스를 구현*한class의 인스턴스를 생성 한 후
		//이 인스턴스를 Thread객체의 인스턴스를 생성할 때 생성자의 매개변수로 넘겨준다.
		//이렇게 생성된 Thread객체의 인스턴스의 start() 호출한다
		//언제든지 사용가능.
		
		
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();
		
		
		//방법3: 익명클래스를 이용하는 방법
		//Runnable 인터페이스를 구현한 익명클래스를 Thread 인스턴스를 생성할 때 매개변수로 넘겨준다.
		//1회성이라 내가 필요한시점마다 오버라이드 해줘야함
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=200 ; i++) {
					System.out.print("@");
					
					//Thread.sleep(시간 )=>주어진 시간동안 작업을 잠시 멈춘다.
					//시간은 밀리세컨드 단위사용한다. 즉, 1000은 1초를 의미한다.
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		th3.start();
	}
	
	
}


class MyThread1 extends Thread {
	//thread의 메인메서드 역할 (필요한 작업물 작성) 은  run이라는 메서드가 한다, run안에 필요한 메서드 다 작성해야함.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <=200 ; i++) {
			System.out.print("*");
			
			//Thread.sleep(시간 )=>주어진 시간동안 작업을 잠시 멈춘다.
			//시간은 밀리세컨드 단위사용한다. 즉, 1000은 1초를 의미한다.
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}
	
}
class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <=200 ; i++) {
			System.out.print("$");
			
			//Thread.sleep(시간 )=>주어진 시간동안 작업을 잠시 멈춘다.
			//시간은 밀리세컨드 단위사용한다. 즉, 1000은 1초를 의미한다.
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

