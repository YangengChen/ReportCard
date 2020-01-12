package dao;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import comparators.CourseIdComparator;
import exceptions.CourseNotCompletedException;

/**
 * @author Yangeng Chen
 *
 */
public class ReportCard {

	private Student student;
	
	/**
	 * The average of the total of all courses combined   
	 */
	private double totalAvg;
	private Map<Course, CourseResult> courseResults;
	
	/**
	 * Creates a report card of the specified Student
	 * @param student
	 */
	public ReportCard(Student student) {
		this.student = student;
		totalAvg = 0;
		courseResults = student.getCourseResults();
		try {
			checkCourseCompletion();
		} catch (CourseNotCompletedException e) {
			System.out.println(e.getMessage());
		}
		calculateTotalAvg();
	}
	
	/**
	 * This method checks if the student has completed every course he's enrolled in
	 * @throws CourseNotCompletedException: Thrown if the number of tests taken is less than the course normal
	 */
	public void checkCourseCompletion() throws CourseNotCompletedException {
		for(Course course : student.getCourses()) {
			CourseResult courseResult = courseResults.get(course);
			if(course.getTests().size() > courseResult.getTestsTaken()) {
				throw new CourseNotCompletedException("Student " + student.getName() + "has not completed Course " + course.getName());
			}
		}
	}
	
	/**
	 * This method calculates the total average of all courses scores combined
	 */
	public void calculateTotalAvg() {
		double coursesTotal = 0;
		int courseCount = 0;
		for(Map.Entry<Course, CourseResult> entry : courseResults.entrySet()) {
			coursesTotal += entry.getValue().getWeightedTotal();
			courseCount++;
		}
		setTotalAvg(coursesTotal / courseCount);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public double getTotalAvg() {
		return totalAvg;
	}

	public void setTotalAvg(double totalAvg) {
		this.totalAvg = totalAvg;
	}
	
	/**
	 * Creates a String representation of the Report Card  
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"Student Id: " + student.getId() + ", name: " + student.getName() 
				+ "\nTotal Average:	" + String.format("%.2f", totalAvg) + "%\n\n"
				);
		
		Set<Course> courses = new TreeSet<Course>(new CourseIdComparator());
		courses.addAll(courseResults.keySet());
		for(Course course : courses) {
			double finalScore = courseResults.get(course).getWeightedTotal();
			sb.append(
					"		Course: " + course.getName() + ", Teacher: " + course.getTeacher()
				+"\n		Final Grade:	" + String.format("%.2f", finalScore) + "%\n\n"
				); 
		}
		
		return sb.toString();
	}
	
}
