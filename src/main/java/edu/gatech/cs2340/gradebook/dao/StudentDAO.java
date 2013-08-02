package edu.gatech.cs2340.gradebook.dao;

import java.util.ArrayList;

import edu.gatech.cs2340.gradebook.model.GradebookItem;
import edu.gatech.cs2340.gradebook.model.GradingScheme;
import edu.gatech.cs2340.gradebook.model.Section;
/**
 * Interface for implementing a Student with an ID, a name, grades, and
 * a way to report scores.
 *
 * @author Andrew Osborn
 *
 */
public interface StudentDAO {

	String getName();

	int getID();

	void enroll(Section section);

	boolean addGrade(GradebookItem grade);

	boolean removeGrade(GradebookItem grade);

	void addGrades(ArrayList<GradebookItem> grades);

	void clearGrades();

	ArrayList<GradebookItem> getGrades();

	double getAvgScore(GradingScheme scheme);

	char getAvgLetterGrade(GradingScheme scheme);

}
