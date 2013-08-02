package main.java.edu.gatech.cs2340.gradebook.model;

import main.java.edu.gatech.cs2340.gradebook.dao.GradebookCategoryDAO;
/**
 * Gradebook categories have a name and a weight and are used to grade by
 * grading schemes.
 *
 * @author Andrew Osborn
 *
 */
public class GradebookCategory implements GradebookCategoryDAO {

	private String name;
	private double weight;

	public GradebookCategory(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(double percent) {
		this.weight = percent;
	}

}
