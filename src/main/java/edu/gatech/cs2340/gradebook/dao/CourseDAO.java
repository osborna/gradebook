package edu.gatech.cs2340.gradebook.dao;

import java.util.ArrayList;

import edu.gatech.cs2340.gradebook.model.Course;
/**
 * Interface for implementing a Course with a name, a subject, a course number,
 * and prerequisite courses.
 *
 * @author Andrew Osborn
 *
 */
public interface CourseDAO {

	String getName();

	String getSubject();

	int getCourseNumber();

	ArrayList<Course> getPrereq();

	void setName(String name);

	void setSubject(String subject);

	void setCourseNumber(int courseNumber);

	void setPrereq(ArrayList<Course> prereq);

	boolean addPrereq(Course toAdd);

	void removePrereq(Course toRemove);

	boolean equals(Object obj);

}
