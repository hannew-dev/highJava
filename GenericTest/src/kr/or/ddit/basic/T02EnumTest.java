package kr.or.ddit.basic;

public class T02EnumTest {
	/*
	 * 열거형 => 상수값들을 선언하는 방법
	 * 
	 * static final int A = 0;
	 * static final int A = 1;
	 * static final int A = 2;
	 * static final int A = 3;
	 * 
	 * enum Data {A,B,C,D}
	 * ->상수를 객체로 만든다.
	 * ->자기만의 타입이 있다. ex)Data타입 
	 * 
	 * 열거형 선언하는 방법
	 * enum 열거형 이름{상수값1, 상수값2,..., 상수값 n}
	 */
	
	public enum HomeTown{광주, 대전, 대구, 부산, 서울}

	// City 열거형 상수 선언하기 ( 기본값을 이용하는 열거형)
	public enum City{서울, 부산, 대구, 광주, 대전};
	//city타입의 객체 서울, 부산, 대구, 광주, 대전
	
	//데이터 값을 임의로 지정한 열거형 객체 선언
	//데이터 값을 정해 줄 경우에는 생성자를 만들어서 괄호속의 값이 변수에 저장되도록 해야한다.
	//comparable 가지고있다.
	
	public enum Season{//클래스 선언하는것과 비슷.
		봄("3월부터 5월까지"),여름("6월부터 8월까지"), 가을("9월부터 11월까지"), 겨울("12월부터 2월까지");
		
		//괄호속의 값이 저장될 변수 선언
		private String str;
		
		//생성자 만들기(열거형의 생성자는 제어자가 묵시적으로 'private'이다.),디폴트값이 private임
		//모든클래스는 생성자가 필요하다 디폴드값은 자동으로 생성자 정의가 된다. 
		Season(String data){//외부에서 객체생성 할수없다.->항상 값이 같아서 객체생성개수 통제하기위해.
			str = data;
		}
		
		//값을 반환하는 메서드
		public String getStr() {
			return str;
		}
	}
	
	
	
 public static void main(String[] args) {
	/*
	 * 열거형에서 사용되는 메서드
	 * 
	 * 1.name() => 열거형 상수의 이름을 문자열로 반환한다.
	 * 2.ordinal() => 열거형 상수가 정의된 수서값을 반환한다.(기본적으로 0부터 시작)
	 * 3.valueOf("열거형 상수이름") => 지정된 열거형에서 '열거상수이름'과 일치하는 열거형 상수를 반환한다.
	 * 
	 * 
	 */
 
	 
	 	City myCity1;//열거형 객체변수 선언하기
	 	City myCity2;
	 	
	 	//열거형 객체변수에 값을 저장하기
	 	myCity1 =City.서울;
	 	myCity2 = City.valueOf("서울");//위 아래 똑같음! "서울"에 해당하는 내용 불러옴.
	 	
	 	System.out.println("myCity1 :" + myCity1.name());
	 	System.out.println("myCity1의 ordinal : "+myCity1.ordinal());
	 	System.out.println();
	 	
	 	
	 	System.out.println("myCity2 :" + myCity2.name());//name은 열거형 상수객체를 선언할때 만든 이름호출.
	 	System.out.println("myCity2의 ordinal : "+myCity2.ordinal());//나열된 순서번호 알수잇음. 서울이 몇번째 열거형상수 위치에 있는지 
	 	System.out.println("=========================================");
	 	
	 	
	 	Season ss = Season.valueOf("여름");
	 	System.out.println("name => " + ss.name());
	 	System.out.println("ordinal => " + ss.ordinal());
	 	System.out.println("get메서드 => "+ss.getStr());
	 	System.out.println("------------------------------------------");
	 	
	 	//열거형 이름.value() =>데이터를 배열로 가져온다.
	 	//name은 열거형 상수객체를 선언할때 만든 이름호출.
	 	Season[] enumArr = Season.values();
	 	for (int i= 0; i < enumArr.length;i ++) {
			System.out.println(enumArr[i].name()+" : "+enumArr[i].getStr());
		}
	 	
	 	System.out.println(	);
	 	
	 	
	 	for (City city : City.values()) {
			System.out.println( city + " : " + city.ordinal());
		}
	 
	 	City city = City.대구;
	 	
	 	System.out.println(city == City.대전);
	 	System.out.println(city == City.대구);
	 	
	 //	System.out.println(City.대전 == HomeTown.대전); 불가하다.
	 	
	 	System.out.println("대구 => "+city.compareTo(City.대구));
	 	System.out.println("서울 => "+city.compareTo(City.서울));
	 	System.out.println("대전 => "+city.compareTo(City.대전));
 }
 
 
}




















