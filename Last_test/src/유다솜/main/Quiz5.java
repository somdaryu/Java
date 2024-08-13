package 유다솜.main;

import java.util.ArrayList;

public class Quiz5 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1001, "둘리"));
		list.add(new Student(1002, "또치"));
		list.add(new Student(1003, "도우너"));
		
		for(Student value : list) {
			System.out.println(value.toString());
		}
	}

}

class Student {
	int no;
	String name;
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + "]";
	}
	
	
}