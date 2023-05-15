package exercise;

public class PlanetTest {

	public enum Planet {
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(25362), 천왕성(25362), 해왕성(24622);

		// 값이 저장되는 변수선언
		private double r;

		// 생성자 만들기
		Planet(double radious) {
			r = radious;

		}

		// 값을 반환하는 메서드

		public double getR() {
			return 4 * Math.PI * r * r;
		}

	}

	public static void main(String[] args) {
		Planet[] enumArea = Planet.values();
		for (int i = 0; i < enumArea.length; i++) {
			System.out.println(enumArea[i].name() + "의 면적:" + enumArea[i].getR() + "㎢");
		}

		System.out.println();

	}
}
