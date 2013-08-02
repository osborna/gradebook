package edu.gatech.cs2340.gradebook.dao;

import java.util.ArrayList;

import edu.gatech.cs2340.gradebook.model.GradingScheme;
import edu.gatech.cs2340.gradebook.model.Student;
/**
 * Interface for implementing a Section with a name, students, and a way
 * to report scores of those students using a specified grading scheme
 *
 * @author Andrew Osborn
 *
 */
public interface SectionDAO {

	 String getName();

	 void setName(String name);

	 int getSize();

	 void addStudents(ArrayList<Student> studentsToAdd);

	 void addStudent(Student studentToAdd);

	 Student getStudent(int id);

	 Student removeStudent(int id);

	 void clearStudents();

	 double getAvgScore(GradingScheme scheme);

	 char getAvgLetterGrade(GradingScheme scheme);

}
