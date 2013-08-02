package edu.gatech.cs2340.gradebook.dao;

import java.util.ArrayList;

import edu.gatech.cs2340.gradebook.model.Course;
import edu.gatech.cs2340.gradebook.model.GradingScheme;
import edu.gatech.cs2340.gradebook.model.Section;
/**
 * Interface for implementing a Lecture with a name, a course, sections,
 * and ways to report scores using a specified grading scheme.
 *
 * @author Andrew Osborn
 *
 */
public interface LectureDAO {

	 String getName();

	 Course getCourse();

	 ArrayList<Section> getSections();

	 boolean addSection(Section toAdd);

	 void setSections(ArrayList<Section> sections);

	 boolean removeSection(Section toRemove);

	 double getAvgScore(GradingScheme scheme);

	 char getAvgLetterGrade(GradingScheme scheme);

}
