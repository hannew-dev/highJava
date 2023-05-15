package exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean run = true;
		while (run) {
			System.out.println("=====================================\n" + "Lotto 프로그램\n"
					+ "-------------------------------------\n" + "1.Lotto 구입\n" + "2.프로그램 종료\n"
					+ "=====================================\n");
			System.out.print("메뉴선택: ");
			int menu = scanner.nextInt();
			System.out.println();

			if (menu == 1) {
				System.out.println(" Lotto 구입 시작");
				System.out.println();
				System.out.println("(1000원에 로또번호 하나 입니다.)");
				System.out.print("금액입력: ");
				int coin = scanner.nextInt();
				System.out.println();
				System.out.println("행운의 로또 번호는 아래와 같습니다.");
				int num = coin / 1000;
				int remainder = coin % 1000;

				Set<Integer> set = new HashSet<Integer>();
				for (int i = 0; i < num; i++) {
					while (set.size() < 6) {
						int LottoNum = (int) (Math.random() * 45 + 1);
						set.add(LottoNum);

					}
					System.out.print("로또 번호 " + (i + 1) + " : ");
					// Iterator<Integer> it = set.iterator();
					System.out.println(set);
					set.clear();

				}
				System.out.println("\n받은 금액은 " + coin + "원이고 거스름돈은 " + remainder + "입니다.");
			} else {
				System.out.println("감사합니다");
				System.exit(0);
				run = false;
			}
		}
	}
}
