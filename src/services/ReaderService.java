package services;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.Course;
import dao.CourseResult;
import dao.Mark;
import dao.Student;
import dao.Test;

import java.util.HashMap;

/**
 * @author Yangeng Chen
 *
 */
public class ReaderService {

	private Map<Integer, Student> students;
	private Map<Integer, Course> courses;
	private Map<Integer, Test> tests;
	private List<Mark> marks;
	
	/**
	 * Creates a reading service which will import the data from the files into objects stored inside HashMap and ArrayList
	 */
	public ReaderService() {
		students = new HashMap<Integer, Student>();
		courses = new HashMap<Integer, Course>();
		tests = new HashMap<Integer, Test>();
		marks = new ArrayList<Mark>();
	}

	/**
	 * Reads the student data file and creates Student objects to be stored inside HashMap
	 * @param studentFile The student data file that is being read from
	 */
	public void setUpStudents(String studentFile) {
		File file = new File(studentFile);
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String row = reader.readLine(); // to skip header
			while ((row = reader.readLine()) != null) {
				String[] data = row.split(",");
				int id = Integer.parseInt(data[0].trim());
				String name = data[1].trim();
				Student student = new Student(id, name);
				students.put(id, student);
			}
		} catch (IOException e) {
			System.out.println("Student file could not be found.");
		} 
	}
	
	/**
	 * Reads the course data file and creates Course objects to be stored inside HashMap
	 * @param courseFile The course data file that is being read from
	 */
	public void setUpCourses(String courseFile) {
		File file = new File(courseFile);
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String row = reader.readLine(); // to skip header
			while ((row = reader.readLine()) != null) {
				String[] data = row.split(",");
				int id = Integer.parseInt(data[0].trim());
				String name = data[1].trim();
				String teacher = data[2].trim();
				Course course = new Course(id, name, teacher);
				courses.put(id, course);
			}
		} catch (IOException e) {
			System.out.println("Course file could not be found.");
		} 
	}
	
	/**
	 * Reads the test data file and creates Test objects to be stored inside HashMap
	 * @param testFile The test data file that is being read from
	 */
	public void setUpTests(String testFile) {
		File file = new File(testFile);
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String row = reader.readLine(); // to skip header
			while ((row = reader.readLine()) != null) {
				String[] data = row.split(",");
				int id = Integer.parseInt(data[0].trim());
				int course_id = Integer.parseInt(data[1].trim());
				int weight = Integer.parseInt(data[2].trim());
				Test test = new Test(id, course_id, weight);
				tests.put(id, test);
			}
		} catch (IOException e) {
			System.out.println("Test file could not be found.");
		} 
	}
	
	/**
	 * Reads the mark data file and creates Mark objects to be stored inside ArrayList
	 * @param markFile The mark data file that is being read from
	 */
	public void setUpMarks(String markFile) {
		File file = new File(markFile);
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String row = reader.readLine(); // to skip header
			while ((row = reader.readLine()) != null) {
				String[] data = row.split(",");
				int testId = Integer.parseInt(data[0].trim());
				int studentId = Integer.parseInt(data[1].trim());
				int score = Integer.parseInt(data[2].trim());
				Mark mark = new Mark(testId, studentId, score);
				marks.add(mark);
			}
		} catch (IOException e) {
			System.out.println("Mark file could not be found.");
		} 
	}
	
	/**
	 * This method adds the courses that the student is enrolled in into the Student object's Course list
	 * It also calculates the total weighted score of each course that the student is enrolled in
	 */
	public void setUpStudentScores() {
		for(Mark mark : marks) {
			Test test = tests.get(mark.getTestId());
			Course course = courses.get(test.getCourseId());
			Student student = students.get(mark.getStudentId());
			course.getTests().add(test);
			CourseResult courseResult;
			if(student.getCourses().add(course)) {
				courseResult = new CourseResult(0, 0);
				student.getCourseResults().put(course, courseResult);
			}
			courseResult = student.getCourseResults().get(course);
			int weight = test.getWeight();
			int score = mark.getScore();
			double weightedScore = score * ((double) weight / 100);
			courseResult.addWeightedScore(weightedScore);
			courseResult.testsTakenPlusOne();
		}
	}

	public Map<Integer, Student> getStudents() {
		return students;
	}

	public void setStudents(Map<Integer, Student> students) {
		this.students = students;
	}

	public Map<Integer, Course> getCourses() {
		return courses;
	}

	public void setCourses(Map<Integer, Course> courses) {
		this.courses = courses;
	}

	public Map<Integer, Test> getTests() {
		return tests;
	}

	public void setTests(Map<Integer, Test> tests) {
		this.tests = tests;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
}
