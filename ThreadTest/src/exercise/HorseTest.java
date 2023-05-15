package exercise;

public class HorseTest {
	public static int CURR_RANK = 1;
}


	

class Horse implements Comparable<Horse>  {
	
	private String name;
	public int rank;

	public Horse() {
	}

	public Horse(String name, int rank) {
		super();
		this.name = name;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	
	@Override
	public int compareTo(Horse rank) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(rank.getName());
	}
	
	public void run() {
		for (int i = 0; i <50; i++) {
			System.out.println("\n" + name + " : ");
			for (int j= 0; j < i; j++) {
				System.out.println("-");
				
				
			}
			for (int j = 49; j >i ; j--) {
				System.out.println("-");
			}
			System.out.println();
			System.out.println();
			System.out.println();
			
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " 완주!");
		setRank(HorseTest.CURR_RANK++);
		
	}

}
