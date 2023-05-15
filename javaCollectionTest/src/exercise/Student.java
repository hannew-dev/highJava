package exercise;

class Student implements Comparable<Student>{
		private String stuNum;
		private String name;
		private int korean;
		private int math;
		private int english;
		private int sum;
		private int Rank;
		
		
		public Student( String stuNum, String name, int korean, int math, int english) {
			super();
			this.stuNum = stuNum;
			this.name = name;
			this.korean = korean;
			this.math = math;
			this.english = english;
			this.sum = korean+math+english;
		}
		
		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}



		public String getStuNum() {
			return stuNum;
		}



		public void setStuNum(String stuNum) {
			this.stuNum = stuNum;
		}


		public int getKorean() {
			return korean;
		}


		public void setKorean(int korean) {
			this.korean = korean;
		}

		
		public int getMath() {
			return math;
		}


		public void setMath(int math) {
			this.math = math;
		}



		public int getEnglish() {
			return english;
		}



		public void setEnglish(int english) {
			this.english = english;
		}


		public int getSum() {
			return korean + math + english;
		}



		public void setSum(int sum) {
			this.sum = sum;
		}



		public int getRank() {
			return Rank;
		}


		public void setRank(int Rank) {
			this.Rank = Rank;
		}


		@Override
		public String toString() {
			return "이름: " + name + ", 학번: " + stuNum + ", 국어: " + korean + ", 수학: " + math + ", 영어: "
					+ english +" 총점: " + sum ;
		}

	

		@Override
		public int compareTo(Student s) {
			return this.getStuNum().compareTo(s.getStuNum());
		}



	}


	

