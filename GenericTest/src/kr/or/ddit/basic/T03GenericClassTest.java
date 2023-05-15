package kr.or.ddit.basic;

public class T03GenericClassTest {
	/*
	 * 제너릭 클래스를 생성하는 방법
	 * 
	 * 형식)
	 * 		class 클래스명<제너릭 타입 글자>{
	 * 
	 * 			제너릭 타입글자 변수명; // 변수선언에서 제너릭을 사용하는 경우...
	 * 
	 * 			제너릭 타입글자 메서드명(){// 반환값이 있는 메서드에서 제너릭을 사용하는 경우
	 * 				...
	 * 				return 값;
	 * 			}
	 * 			...
	 * 		}
	 * 
	 *
	 *-제너릭 타입 글자-
	 *T => type
	 *K => Key
	 *V => Value
	 *E => Element
	 * 
	 */
		
	public static void main(String[] args) {
		
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnVal1 = (String)ng1.getVal();//캐스팅 안해주면 에러난다.
		System.out.println("문자열 반환 값 rtnVal1 => " + rtnVal1);
		
		Integer iRtnVal2 = (Integer) ng2.getVal();
		System.out.println("정수 반환 값 iRtnVal2 => "+ iRtnVal2);
		///////////////////////////////////////////////////////////
		
		
		MyGeneric<String> mg1 = new MyGeneric<String>();//사용타입을 캐스팅없이 바로 바꿔줄수있다!
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnVal1 = mg1.getVal();
		iRtnVal2 = mg2.getVal();
		
		System.err.println("제너릭 문자열 반환값 =>" + rtnVal1);
		System.err.println("제너릭 정수형 반환값 =>" + iRtnVal2);
	}
}


class NonGenericClass{
	//object로 사용하면 뭐든지 다 넣을 수 있기때문에 내가 원치않는 타입까지도 들어갈 수 있다. 
	//그 객체만이 가지고있는 해당 메서드를 쓸때 캐스팅 해줘야한다.(번거로움)
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}

}

class MyGeneric<T>{
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}
