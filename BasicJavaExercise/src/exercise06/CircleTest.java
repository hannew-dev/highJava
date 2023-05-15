package exercise06;

public class CircleTest {
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.setRadius(3.6);
		circle.setX(0.0);
		circle.setY(1.5);
		
		System.out.println("반지름: "+circle.getRadius());
		System.out.println("중심좌표: ("+circle.getX()+", "+circle.getY()+")");
		System.out.printf("넓이: %.2f\n",circle.getArea());
		
		Circle circle2 = new Circle();
		circle.setRadius(-5.0);
		circle.setX(1.0);
		circle.setY(2.2);
		
		System.out.println("반지름: "+circle.getRadius());
		System.out.println("중심좌표: ("+circle.getX()+", "+circle.getY()+")");
		System.out.printf("넓이: %.2f\n",circle.getArea());
	}
}
