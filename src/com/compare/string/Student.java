/**
 * 
 */
package com.compare.string;

import java.util.Comparator;

/**
 * @author Rajvigneswaran
 */
public class Student {
	private String id;
	private String firstName;
	private String gpa;

	Student(String id, String firstName, String gpa) {
		this.id = id;
		this.firstName = firstName;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public static final Comparator<Student> studentComparator = new Comparator<Student>() {
		@Override
		public int compare(Student student1, Student student2) {
			int i = student1.getGpa().compareTo(student2.getGpa());
			if (i != 0) {
				return -i;
			}

			i = student1.getFirstName().compareTo(student2.getFirstName());
			if (i != 0) {
				return i;
			}

			i = student1.getId().compareTo(student2.getId());
			if (i != 0) {
				return i;
			}

			return 0;
		}
	};
}
