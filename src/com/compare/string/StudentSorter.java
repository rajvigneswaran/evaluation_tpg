/**
 * 
 */
package com.compare.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajvigneswaran
 */
public class StudentSorter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("33", "Tina", "3.68"));
		students.add(new Student("85", "Louis", "3.85"));
		students.add(new Student("56", "Samil", "3.75"));
		students.add(new Student("19", "Samar", "3.75"));
		students.add(new Student("22", "Lorry", "3.76"));
		students.parallelStream().sorted(Student.studentComparator).map(student -> student.getFirstName())
				.forEach(System.out::println);
	}

}
