package dao;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * @author Yangeng Chen
 *
 */
public class Student {

	private int id;
	private String name;
	
	/**
	 * A unique set of courses that each student is enrolled in
	 */
	private Set<Course> courses;
	
	/**
	 * A map that maps the corresponding Course to its CourseResult object 
	 */
	private Map<Course, CourseResult> courseResults;
	
	/**
	 * Creates a student with the specified id, name 
	 * @param id the id of the student
	 * @param name the name of the student
	 */
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		courses = new HashSet<Course>();
		courseResults = new HashMap<Course, CourseResult>(); 
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Map<Course, CourseResult> getCourseResults() {
		return courseResults;
	}

	public void setCourseResults(Map<Course, CourseResult> courseResults) {
		this.courseResults = courseResults;
	}


}
