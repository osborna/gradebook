package edu.gatech.cs2340.gradebook.dao;

import edu.gatech.cs2340.gradebook.model.GradebookCategory;
import edu.gatech.cs2340.gradebook.model.GradebookItem;
/**
 * Interface for implementing a Gradebook Item with a name, score,
 * category, and a way to report grades.
 *
 * @author Andrew Osborn
 *
 */
public interface GradebookItemDAO {

	String getName();

	double getScore();

	char getLetterGrade();

	GradebookCategory getGradebookCategory();

	void setName(String name);

	void setScore(double score);

	void setGradebookCategory(GradebookCategory category);

	int compareTo(GradebookItem item);

}
