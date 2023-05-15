package kr.or.ddit.basic;

import java.util.LinkedList;

public class T02StackQueueTest {
	public static void main(String[] args) {
		/*
		 * stack의 명령(선입후출)
		 * 1)자료 입력: push (저장할 값)
		 * 2)자료 출력: pop()=>자료를 꺼낸 후 꺼내온 자료를 stack에서 삭제한다.
		 */
		
		LinkedList<String> stack = new LinkedList<String>();//<타입> 다른타입의 객체가 들어가는것을 막아준다 <>: generic
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		System.out.println("현재 stack값들 : "+ stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 자료: "+ data);
		System.out.println("꺼내온 자료: "+ stack.pop());
		System.out.println("현재 stack값들: "+ stack);
		
		stack.push("성춘향");
		System.out.println("현재 stack값들: "+stack);
		System.out.println("꺼내온 자료 : "+stack.pop());
		System.out.println("================================================");
		System.out.println();
		
		/*
		 * Queue방식의 명령(선입선출)
		 * 1)자료입력: offer (저장할 값)
		 * 2)자료 출력: poll() => 자료를 꺼내온 후 꺼내온 자료는 Queue에서 삭제된다.
		 */
		LinkedList<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		System.out.println("현재 queue의 값: "+ queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 자료: "+ temp);
		System.out.println("꺼내온 자료: "+ queue.poll());
		System.out.println("현재 queue의 값: "+ queue);
		
		if (queue.offer("성춘향")) {
			System.out.println("신규등록자료: 성춘향");
			
		}
		
		System.out.println("현재 queue의 값: "+ queue);
		System.out.println("꺼내온 자료: "+ queue.poll());
		
		
		
	}
}
