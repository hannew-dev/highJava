package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T06ThreadTest {
	public static boolean inputCheck=false;
	
	public static void main(String[] args) {
		//입력 여부를 확인하기 위한 변수 선언
		//모든 스레드에서 공통으로 사용할 변수
		
		

		Thread th1 = new DataInput();
		Thread th2 = new CountDown();

		th1.start();
		th2.start();

		// 모든 스레드가 terminated되어야 프로그램이 끝난다.
		// 메인스레드부터 끝난다. 그다음에 입력하느냐에 따라 다르게 끝남(입력부터 하면 입력부분 끝나고, 카운트다운 끝난 후 모든 스레드가 끝난다)
	}

}	/**
	 * 데이터를 입력하는 스레드
	 */
	class DataInput extends Thread {
		@Override
		public void run() {

			String str = JOptionPane.showInputDialog("아무거나 입력하시오");
			// 입력이 완료되면 ionputCheck 변수를 true로 설정한다.
		      T06ThreadTest.inputCheck = true;
			System.out.println("입력한 값은 " + str + "입니다.");

		}
	}

	/**
	 * 카운트 다운 처리를 위한 스레드
	 */
	class CountDown extends Thread {
		@Override
		public void run() {
			for (int i = 10; i >= 1; i--) {
				//입력이 완료되었는지 확인하고 입력이 완료되면 run() 을 종료시킨다. 즉 현재 스레드를 종료시킨다.
				if(T06ThreadTest.inputCheck) {
					return;
				}
				System.out.println(i);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//10초가 경과되었는데도 입력값이 없으면 프로그램을 종료시키는 메서드.
			System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
			System.exit(0);
		}
	
	}
