package exercise06;

public class Circle {
	//필드
	 double radius;
	 double x;
	 double y;
	 
	 //생성자
	 public Circle() {
		 }
	 
	public Circle(double radius, double x, double y) {
		super();
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
	
	//메소드
	public double getArea(){
		return Math.PI*radius*radius;
	}
	public double getRadius() {
		if (radius>0) {
			return radius;
		} else {
			return 0.0;
		}
		
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
	
	
}
