package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

import edu.gatech.cs2340.gradebook.dao.LectureDAO;
import edu.gatech.cs2340.gradebook.util.GradingSchemeUtil;
/**
 * Creates a lecture that contains sections and reports an average score
 * and an average letter grade
 *
 * @author Andrew Osborn
 *
 */
public class Lecture implements LectureDAO {
	private String name;
	private Course course;
	private ArrayList<Section> sections;

	public Lecture(String name, Course course) {
		this.name = name;
		this.course = course;
		this.sections = new ArrayList<Section>();
	}

	public Lecture(String name, Course course,
			ArrayList<Section> sections) {
		this.name = name;
		this.course = course;
		this.sections = sections;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Course getCourse() {
		return course;
	}

	@Override
	public ArrayList<Section> getSections() {
		return sections;
	}

	@Override
	public boolean addSection(Section toAdd) {
		return sections.add(toAdd);
	}

	@Override
	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}

	@Override
	public boolean removeSection(Section toRemove) {
		return sections.remove(toRemove);
	}

	@Override
	public double getAvgScore(GradingScheme scheme) {
		double averageScore = 0.0;
		for (Section s : sections) {
			averageScore = s.getAvgScore(scheme);
		}
		return averageScore / sections.size();
	}

	@Override
	public char getAvgLetterGrade(GradingScheme scheme) {
		double averageScore = getAvgScore(scheme);
		return GradingSchemeUtil.determineLetterGrade(averageScore);
	}

}
