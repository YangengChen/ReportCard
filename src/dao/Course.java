package dao;
import java.util.Set;
import java.util.HashSet;;


/**
 * @author Yangeng Chen
 *
 */
public class Course {

	private int id;
	private String name;
	private String teacher;
	
	/**
	 * An unique set of tests that each course has 
	 */
	private Set<Test> tests;
	
	/**
	 * Creates a Course object with the specified id, name, and teacher
	 * @param id 	the id of the course
	 * @param name 	the name of the course
	 * @param teacher 	the teacher of the course
	 */
	public Course(int id, String name, String teacher) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		tests = new HashSet<Test>();
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
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}


	
	
}
