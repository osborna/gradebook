package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
/**
 * Creates a course with a subject, course number, name, and prereq courses
 *
 * @author Andrew Osborn
 */
public class Course {

    private String name;
    private String subject;
    private int courseNumber;
    private ArrayList<Course> prereq;

    public Course(String name, String subject, int courseNumber) {
        this.name = name;
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.prereq = new ArrayList<Course>();
    }

    public Course(String name, String subject, int courseNumber,
        ArrayList<Course> prereq) {
        this.name = name;
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.prereq = prereq;
    }

    public String getName() {
        return name;
	}

    public String getSubject() {
        return subject;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public ArrayList<Course> getPrereq() {
        return prereq;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setPrereq(ArrayList<Course> prereq) {
        this.prereq = prereq;
    }

    public boolean addPrereq(Course toAdd) {
        prereq.add(toAdd);
        return true;
    }

    public void removePrereq(Course toRemove) {
        prereq.remove(toRemove);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Course other = (Course) obj;
        if (!name.equals(other.getName())) {
            return false;
        }
        if (!subject.equals(other.getSubject())) {
            return false;
        }
        if (!(courseNumber == other.getCourseNumber())) {
            return false;
        }
        for (Course p : prereq) {
            if (!other.getPrereq().contains(p)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return courseNumber;
    }
}
