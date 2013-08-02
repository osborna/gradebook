package edu.gatech.cs2340.gradebook.util;

import java.util.ArrayList;

import edu.gatech.cs2340.gradebook.model.GradebookCategory;
import edu.gatech.cs2340.gradebook.model.GradebookItem;
import edu.gatech.cs2340.gradebook.model.Student;
/**
 * A class used by GradebookScheme filled with helper methods that
 * carry out different grading methods.
 * @author Andrew Osborn
 *
 */
public class GradingSchemeUtil {

	public static char determineLetterGrade(double score) {
		if (score < 60) {
			return 'F';
		} else if (score < 70) {
			return 'D';
		} else if (score < 80) {
			return 'C';
		} else if (score < 90) {
			return 'B';
		}
		return 'A';
	}

	public static double grade(Student toGrade) {
		ArrayList<GradebookItem> grades = toGrade.getGrades();
		ArrayList<GradebookCategory> checked =
			new ArrayList<GradebookCategory>();
		double grade = 0.0;
		for (GradebookItem g : grades) {
			if (!checked.contains(g.getGradebookCategory())) {
				GradebookCategory current = g.getGradebookCategory();
				checked.add(current);
				ArrayList<Double> scores = new ArrayList<Double>();
				for (GradebookItem item : grades) {
					if (item.getGradebookCategory().equals(current)) {
						scores.add(item.getScore());
					}
				}
				double categoryScore = 0.0;
				for (int i = 0; i < scores.size(); i++) {
					categoryScore += scores.get(i);
				}
				categoryScore = categoryScore / scores.size();
				categoryScore = categoryScore * (current.getWeight() / 100);
				grade += categoryScore;
			}
		}
		return grade;
	}

	private static GradebookItem getLowestOverall(Student toGrade) {
		GradebookItem lowestGrade = toGrade.getGrades().get(0);
		for (GradebookItem grade : toGrade.getGrades()) {
			if (grade.compareTo(lowestGrade) < 0) {
				lowestGrade = grade;
			}
		}
		return lowestGrade;
	}

	public static Student removeLowestOverall(Student toGrade) {
		GradebookItem lowestGrade = getLowestOverall(toGrade);
		toGrade.removeGrade(lowestGrade);
		return toGrade;
	}

	public static Student replaceLowestWithHighest(Student toGrade) {

		GradebookItem lowestGrade = getLowestOverall(toGrade);

		GradebookItem highestGrade =
				new GradebookItem("Replaced", 0.0, null);

		for (GradebookItem grade : toGrade.getGrades()) {
			if (grade.compareTo(highestGrade) > 0) {
				highestGrade = grade;
			}
		}

		lowestGrade.setScore(highestGrade.getScore());

		return toGrade;
	}

	public static Student replaceLowestWithAverage(Student toGrade) {

		GradebookItem lowestGrade = toGrade.getGrades().get(0);
		for (GradebookItem grade : toGrade.getGrades()) {
			if (grade.compareTo(lowestGrade) < 0) {
				lowestGrade = grade;
			}
		}

		lowestGrade.setScore(grade(toGrade));

		return toGrade;
	}
}
