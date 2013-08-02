package main.java.edu.gatech.cs2340.gradebook.model;

import main.java.edu.gatech.cs2340.gradebook.dao.GradebookItemDAO;
import main.java.edu.gatech.cs2340.gradebook.util.GradingSchemeUtil;
/**
 * Gradebook Item has a name and a gradebook
 * category to be used as a weight
 * @author Andrew Osborn
 *
 */
public class GradebookItem implements GradebookItemDAO {

	private String name;
	private double score;
	private GradebookCategory category;

	public GradebookItem(String name, GradebookCategory category) {
		this.name = name;
		this.category = category;
		score = 0.0;
	}
	public GradebookItem(String name, double score,
			GradebookCategory category) {
		this.name = name;
		this.score = score;
		this.category = category;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public GradebookCategory getGradebookCategory() {
		return category;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setGradebookCategory(GradebookCategory category) {
		this.category = category;
	}

	@Override
	public double getScore() {
		return score;
	}

	@Override
	public char getLetterGrade() {
		return GradingSchemeUtil.determineLetterGrade(score);
	}

	@Override
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public int compareTo(GradebookItem item) {
		if (this.score < item.score) {
			return -1;
		} else if (this.score > item.score) {
			return 1;
		} else {
			return 0;
		}
	}

}
