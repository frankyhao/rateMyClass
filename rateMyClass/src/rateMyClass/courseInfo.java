package rateMyClass;

import java.util.ArrayList;

public class courseInfo {
	private String title;
	private int sum_students;
	private double avg_gpa;
	private int number;
	private String subject;
	private String name;
	ArrayList<String> comment = new ArrayList<String>();
	int count = 0;
	
	public void addComment (String s) {
		comment.add(s);
	}
	
	public void printComment () {
		int length = comment.size();
		for (int i = 0; i < length; i ++) {
			System.out.println("[" + i + "]" + comment.get(i));
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSum_students() {
		return sum_students;
	}

	public void setSum_students(int sum_students) {
		this.sum_students = sum_students;
	}

	public double getAvg_gpa() {
		return avg_gpa;
	}

	public void setgpa(double gpa) {
		this.avg_gpa = (avg_gpa * this.getSum_students() + gpa) / (this.getSum_students() + 1);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
