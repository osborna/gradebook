package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

import main.java.edu.gatech.cs2340.gradebook.dao.StudentDAO;
/**
 * Creates a student with a name, and an ID. They can be added to sections,
 * given scores, and can report grades.
 *
 * @author Andrew Osborn
 *
 */
public class Student implements StudentDAO {

	private String name;
	private int id;
	private ArrayList<GradebookItem> grades;

	public Student(String name, int id) {
		this.name = name;
		this.id = id;
		this.grades = new ArrayList<GradebookItem>();
	}

	public Student(String name, int id, ArrayList<GradebookItem> grades) {
		this.name = name;
		this.id = id;
		this.grades = grades;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public void enroll(Section section) {
		section.addStudent(this);
	}

	@Override
	public boolean addGrade(GradebookItem grade) {
		return grades.add(grade);
	}

	@Override
	public boolean removeGrade(GradebookItem grade) {
		return grades.remove(grade);
	}

	@Override
	public void addGrades(ArrayList<GradebookItem> grades) {
		for (GradebookItem g : grades) {
			this.grades.add(g);
		}
	}

	@Override
	public void clearGrades() {
		grades.clear();
	}

	@Override
	public ArrayList<GradebookItem> getGrades() {
		return grades;
	}

	@Override
	public double getAvgScore(GradingScheme scheme) {
		return scheme.getAvgScore(this);
	}

	@Override
	public char getAvgLetterGrade(GradingScheme scheme) {
		return scheme.getAvgLetterGrade(this);
	}

}
