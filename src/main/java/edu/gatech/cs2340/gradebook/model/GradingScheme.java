package main.java.edu.gatech.cs2340.gradebook.model;

import main.java.edu.gatech.cs2340.gradebook.dao.GradingSchemeDAO;
import main.java.edu.gatech.cs2340.gradebook.util.GradingSchemeUtil;
/**
 * A grading scheme grades based on a user input described in the
 * constructors javadoc
 * @author Andrew Osborn
 *
 */
public class GradingScheme implements GradingSchemeDAO {

	private int methodNum;

	public GradingScheme() {
		methodNum = 0;
	}

	/**
	 *
	 * @param methodNum: 0 : Grade normally;
	 * 1 : Remove lowest grade overall;
	 * 2 : Replace lowest grade with the highest grade;
	 * 3 : Replace lowest grade with the average grade;
	 * number not listed will revert back to classic grading scheme
	 */
	public GradingScheme(int methodNum) {
		int numMethods = 4;
		if (methodNum < 1 || methodNum > numMethods) {
			this.methodNum = 0;
		} else {
			this.methodNum = methodNum;
		}
	}

	@Override
	public double getAvgScore(Student toGrade) {

		switch(methodNum) {
			case 0:
				return GradingSchemeUtil.grade(toGrade);
			case 1:
				toGrade =
					GradingSchemeUtil.removeLowestOverall(toGrade);
			case 2:
				toGrade =
					GradingSchemeUtil.replaceLowestWithHighest(toGrade);
			case 3:
				toGrade =
					GradingSchemeUtil.replaceLowestWithAverage(toGrade);
			default:
				return GradingSchemeUtil.grade(toGrade);
		}
	}

	@Override
	public char getAvgLetterGrade(Student toGrade) {
		double grade = GradingSchemeUtil.grade(toGrade);
		return GradingSchemeUtil.determineLetterGrade(grade);
	}

}
