package kr.or.ddit.basic;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
	 컴퓨터와 가위바위 보를 진행하는 프로그램을 작성하시오.
	 컴퓨터의 가위바위보는 난수를 이용하여 구하고
	 사용자의 가위바위보는 showinputDialog()메서드를 이용하여 입력받는다
	 입력시간은 5초로 제한하고 카운트다운을 진행한다.
	 5초안에 입력이 없으면 게임을 진 것으로 처리한다.
	 5초안에 입력이 완료되면 승패를 출력한다.

	 */
public class T07ThreadGame {
	public static boolean inputcheck = false;

	public static void main(String[] args) {

		Thread th1 = new Game();
		Thread th2 = new CountDown();

		th1.start();
		th2.start();

	}

}

class Game extends Thread {
	@Override
	public void run() {
		Random random = new Random();
		String str = JOptionPane.showInputDialog("가위바위보를 입력하시오.");
	

		// 입력이 완료되면 inputCheck 변수를 ture로 설정
		int num = random.nextInt(3);
		System.out.println("USER: "+str);
		if (num == 0) {
			System.out.println("컴퓨터: 가위");
			if (str.equals("가위")) {
				System.out.println("비겼습니다.");
			} else if (str.equals("바위")) {
				System.out.println("이겼습니다.");

			} else {
				System.out.println("졌습니다.");

			}

		} else if (num == 1) {
			System.out.println("컴퓨터: 바위");
			if (str.equals("가위")) {
				System.out.println("졌습니다");
			} else if (str.equals("바위")) {
				System.out.println("비겼습니다.");

			} else {
				System.out.println("이겼습니다.");

			}

		} else {System.out.println("컴퓨터: 보");
		if (str.equals("가위")) {
			System.out.println("이겼습니다");
		} else if (str.equals("바위")) {
			System.out.println("졌습니다.");

		} else {
			System.out.println("비겼습니다.");

		}

		}

		T07ThreadGame.inputcheck = true;

		
	}
}

class Count extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			// 입력이 완료되었는지 확인하고 입력이 완료되면 run() 을 종료시킨다. 즉 현재 스레드를 종료시킨다.
			if (T07ThreadGame.inputcheck == true) {
				return;
			}
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 10초가 경과되었는데도 입력값이 없으면 프로그램을 종료시키는 메서드.
		System.out.println("5초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}

}
