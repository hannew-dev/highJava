package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("1", "홍길동", 50, 60, 80));
		studentList.add(new Student("2", "강감찬", 50, 60, 70));
		studentList.add(new Student("3", "이순신", 80, 30, 60));
		studentList.add(new Student("4", "변학도", 60, 70, 90));
		studentList.add(new Student("5", "성춘향", 70, 60, 90));
		studentList.add(new Student("6", "이몽룡", 90, 60, 60));
		studentList.add(new Student("7", "월매", 80, 70, 80));

		System.out.println("학번의 오름차순으로 정렬 후: ");
		for (Student s : studentList) {
			System.out.println(s);
		}
		System.out.println("===================================================================================");

		System.out.println("총점의 역순으로 정렬");
		Collections.sort(studentList, new totalScoreDesc());
		for (Student s : studentList) {
			System.out.println(s);
		}

	}
}

class totalScoreDesc implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		// TODO Auto-generated method stub
		if (stu1.getSum() > stu2.getSum()) {
			return -1;

		} else if (stu1.getSum() == stu2.getSum()) {
			return 1;

		} else {
			return stu1.getStuNum().compareTo(stu2.getStuNum());

		}
	}
}
