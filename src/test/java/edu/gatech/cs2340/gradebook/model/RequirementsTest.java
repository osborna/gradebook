package test.java.edu.gatech.cs2340.gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.java.edu.gatech.cs2340.gradebook.model.Course;
import main.java.edu.gatech.cs2340.gradebook.model.GradebookCategory;
import main.java.edu.gatech.cs2340.gradebook.model.GradebookItem;
import main.java.edu.gatech.cs2340.gradebook.model.GradingScheme;
import main.java.edu.gatech.cs2340.gradebook.model.Lecture;
import main.java.edu.gatech.cs2340.gradebook.model.Section;
import main.java.edu.gatech.cs2340.gradebook.model.Student;

import org.junit.Test;

public class RequirementsTest {

	@Test
	public void testRequirements() {
		//TEST REQUIREMENT SEVEN
		GradingScheme normalScheme = new GradingScheme();
		GradingScheme firstScheme = new GradingScheme(1);
		GradingScheme secondScheme = new GradingScheme(2);
		GradingScheme thirdScheme = new GradingScheme(3);
		
		Student testStudentOne = new Student("Andrew Osborn", 902912066);
	
		Section testSection = new Section("A2");
		testSection.addStudent(testStudentOne);
		
		GradebookCategory testCategory = new GradebookCategory("Tests", 80.0);
		GradebookItem exam = new GradebookItem("Final", 80.0, testCategory);
		GradebookItem testOne = new GradebookItem("1st test", 
				90.0, testCategory);
		GradebookItem midterm = new GradebookItem("2nd test", 
				100.0, testCategory);
		GradebookItem testThree = new GradebookItem("3rd test", 
				70.0, testCategory);

		GradebookCategory homework = new GradebookCategory("Homework", 20.0);
		GradebookItem homeworkOne = new GradebookItem("Essay", 50.0, homework);
		GradebookItem homeworkTwo = new GradebookItem("Git", 60.0, homework);
		GradebookItem homeworkThree = new GradebookItem("Pulse Test", 
				100.0, homework);
		
		testStudentOne.addGrade(exam);
		testStudentOne.addGrade(testOne);
		testStudentOne.addGrade(midterm);
		testStudentOne.addGrade(testThree);

		ArrayList<GradebookItem> toAdd = new ArrayList<GradebookItem>();
		toAdd.add(homeworkOne);
		toAdd.add(homeworkTwo);
		toAdd.add(homeworkThree);
		testStudentOne.addGrades(toAdd);
		
		double studentScore = testStudentOne.getAvgScore(normalScheme);
		System.out.println("Student score normal scheme:" + studentScore);
		studentScore = testStudentOne.getAvgScore(firstScheme);
		System.out.println("Student score first scheme:" + studentScore);
		studentScore = testStudentOne.getAvgScore(secondScheme);
		System.out.println("Student score second scheme:" + studentScore);
		studentScore = testStudentOne.getAvgScore(thirdScheme);
		System.out.println("Student score third scheme:" + studentScore);
		System.out.println();
		
		//add new student
		Student testStudentTwo = new Student("Billy Osborn", 902912034);
		testSection.addStudent(testStudentTwo);
		
		 exam = new GradebookItem("Final", 70.0, testCategory);
		 testOne = new GradebookItem("1st test", 
				80.0, testCategory);
		 midterm = new GradebookItem("2nd test", 
				90.0, testCategory);
		 testThree = new GradebookItem("3rd test", 
				50.0, testCategory);

		 homework = new GradebookCategory("Homework", 20.0);
		 homeworkOne = new GradebookItem("Essay", 50.0, homework);
		 homeworkTwo = new GradebookItem("Git", 60.0, homework);
		 homeworkThree = new GradebookItem("Pulse Test", 
				50.0, homework);
		
		testStudentTwo.addGrade(exam);
		testStudentTwo.addGrade(testOne);
		testStudentTwo.addGrade(midterm);
		testStudentTwo.addGrade(testThree);

		toAdd = new ArrayList<GradebookItem>();
		toAdd.add(homeworkOne);
		toAdd.add(homeworkTwo);
		toAdd.add(homeworkThree);
		testStudentTwo.addGrades(toAdd);
		
		studentScore = testStudentTwo.getAvgScore(normalScheme);
		System.out.println("Student 2 score normal scheme:" + studentScore);
		studentScore = testStudentTwo.getAvgScore(firstScheme);
		System.out.println("Student 2 score first scheme:" + studentScore);
		studentScore = testStudentTwo.getAvgScore(secondScheme);
		System.out.println("Student 2 score second scheme:" + studentScore);
		studentScore = testStudentTwo.getAvgScore(thirdScheme);
		System.out.println("Student 2 score third scheme:" + studentScore);
		System.out.println();

		//display section scores
		double sectionScore = testSection.getAvgScore(normalScheme);
		System.out.println("Section score normal scheme:" + sectionScore);
		
		//testing making a course
		String name = "Risk Class";
		String subject = "CS";
		int courseNumber = 2340;
		ArrayList<Course> prereq = new ArrayList<Course>();
		Course testPrereq = new Course("Intro to Java", "CS", 1331);
		prereq.add(testPrereq);
		Course testCourse = new Course(name, subject, courseNumber, prereq);

		//test getters
		assertEquals("Subject getter wrong", subject, testCourse.getSubject());
		assertEquals("Name getter wrong", name, testCourse.getName());
		assertEquals("CourseNumber getter wrong", courseNumber, 
				testCourse.getCourseNumber());
		assertEquals("Prereq getter wrong", prereq, testCourse.getPrereq());

		//test setters, remove, add, and equals method
		testCourse.setName("testName");
		testCourse.setSubject("testSubject");
		testCourse.setCourseNumber(0000);
		testCourse.removePrereq(testPrereq);
		testPrereq.setName("test");
		testCourse.addPrereq(testPrereq);
		
		assertEquals("Subject setter wrong", "testSubject", 
				testCourse.getSubject());
		assertEquals("Name setter wrong", "testName", testCourse.getName());
		assertEquals("CourseNumber getter wrong", 0000, 
				testCourse.getCourseNumber());
		String rightName = "test";
		String actualName = testCourse.getPrereq().get(0).getName();
		assertEquals("prereq setter wrong", rightName, actualName);

		//test equals method
		assertEquals("equals wrong", testCourse, testCourse);
		
		//test making a lecture
		Lecture testLecture = new Lecture("MW 10:00", testCourse);
		testLecture.addSection(testSection);
		
		double score = testLecture.getAvgScore(normalScheme);
		System.out.println("Lecture avg score: " + score);
		assertEquals("letter grade wrong", 'A', testLecture.getAvgLetterGrade(normalScheme));

	}
}
