package kr.or.ddit.basic;

public class T04ThreadTest {
/*
  	1~20억까지의 합계를 구하는데 걸린 시간 체크하기
  	전체 합계를 구하는 작업을 단독으로 했을 때 (1개의 스레드를 사용했을 때)와
  	여러 스레드로 분할하여 작업했을때의 시간 확인해보기
 */
	public static void main(String[] args) {
		
		//단독으로 처리할때!!!!
		SumThread sm = new SumThread(1, 2000000000L);
		
		long startTime = System.currentTimeMillis();
		
		sm.start();
		
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독으로 처리했을 때의 시간: " + (endTime-startTime)+"(ms)");
		System.out.println("-------------------------------------------------");
		
		
		//여러개의 스레드를 사용하여 처리할때
		SumThread[] sumThs = new SumThread[] {
				new SumThread(1L,            500000000L),
				new SumThread(500000001L,   1000000000L),
				new SumThread(1000000001L,  1500000000L),
				new SumThread(1500000001L,  2000000000L)};
		startTime = System.currentTimeMillis();
		
		for (Thread th 	: sumThs) {
			th.start();
			
		}
				for (Thread th : sumThs) {
					try {
						th.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				endTime =System.currentTimeMillis();
				System.out.println("협력처리 했을때의 처리 시간: "+ (endTime-startTime)+"(ms)");
		}
	}


class SumThread extends Thread{
	private long min, max;
	
	public SumThread(long min,long max) {
		this.min = min;
		this.max = max;
	}
	
	public void run() {
		long sum =0;
		
		for (long i = min; i <=max; i++) {
			sum +=i;
		}
		System.out.println(min+" ~ " + max +"까지의 합: "+sum);
	}
}