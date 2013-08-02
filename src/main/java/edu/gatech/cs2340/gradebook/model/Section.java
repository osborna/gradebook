package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.cs2340.gradebook.dao.SectionDAO;
import edu.gatech.cs2340.gradebook.util.GradingSchemeUtil;
/**
 * Creates a section that belongs to a lecture and contains students,
 * and reports scores and a letter grade.
 *
 * @author Andrew Osborn
 *
 */
public class Section implements SectionDAO {

	private String name;
	private HashMap<Integer, Student> students;

	public Section(String name) {
		this.name = name;
		students = new HashMap<Integer, Student>();
	}

	public Section(String name, ArrayList<Student> studentsToAdd) {
		this.name = name;
		for (Student s : studentsToAdd) {
			this.students.put(s.getID(), s);
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getSize() {
		return students.size();
	}

	@Override
	public void addStudents(ArrayList<Student> studentsToAdd) {
		for (Student s : studentsToAdd) {
			students.put(s.getID(), s);
		}
	}

	@Override
	public void addStudent(Student studentToAdd) {
		students.put(studentToAdd.getID(), studentToAdd);
	}

	@Override
	public Student getStudent(int id) {
		return students.get(id);
	}

	@Override
	public Student removeStudent(int id) {
		return students.remove(id);
	}

	@Override
	public void clearStudents() {
		students.clear();
	}

	@Override
	public double getAvgScore(GradingScheme scheme) {
		double averageScore = 0.0;
		for (Student s : students.values()) {
			averageScore += s.getAvgScore(scheme);
		}
		return averageScore / getSize();
	}

	@Override
	public char getAvgLetterGrade(GradingScheme scheme) {
		double averageScore = getAvgScore(scheme);
		return GradingSchemeUtil.determineLetterGrade(averageScore);
	}

}
