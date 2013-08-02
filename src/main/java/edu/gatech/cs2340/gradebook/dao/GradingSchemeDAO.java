package main.java.edu.gatech.cs2340.gradebook.dao;

import main.java.edu.gatech.cs2340.gradebook.model.Student;
/**
 * The interface for implementing a GradingScheme that has a grading scheme
 * and methods to report scores using that scheme
 *
 * @author Andrew Osborn
 *
 */
public interface GradingSchemeDAO {

	char getAvgLetterGrade(Student toGrade);

	double getAvgScore(Student toGrade);

}
