package dao;

/**
 * @author Yangeng Chen
 *
 */
public class Test {

	private int id;
	private int courseId;
	private int weight;
	
	/**
	 * Creates a test object that stores its id, the course id, and the weight of the test
	 * @param id The id of the test
	 * @param courseId The id of the course that the test corresponds to
	 * @param weight The weight of the test from 0-100
	 */
	public Test(int id, int courseId, int weight) {
		this.id = id;
		this.courseId = courseId;
		this.weight = weight;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourse_id(int courseId) {
		this.courseId = courseId;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
