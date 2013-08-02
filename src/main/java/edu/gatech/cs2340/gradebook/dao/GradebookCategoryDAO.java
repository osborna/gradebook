package main.java.edu.gatech.cs2340.gradebook.dao;
/**
 * Interface for implementing a Gradebook Category with a name
 * and a weight.
 *
 * @author Andrew Osborn
 *
 */
public interface GradebookCategoryDAO {

	String getName();

	double getWeight();

	void setWeight(double percent);

}
