package org.com.exam.module1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}
class Check implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int scoreComapre = Double.compare(o2.getCgpa(),o1.getCgpa());
		int nameCompare = scoreComapre == 0 ? o1.getFname().compareTo(o2.getFname()) : scoreComapre;
		int idCompare = nameCompare ==0 ? o1.getId() - o2.getId() : nameCompare;
		return idCompare;
	}

}
public class ComparatorSortQuestion {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		Check check = new Check();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
		Collections.sort(studentList,check);
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
