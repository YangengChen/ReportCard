package dao;

/**
 * @author Yangeng Chen
 *
 */
public class Mark {

	private int testId;
	private int studentId;
	private int score;

	/**
	 * Creates a mark object which stores the test id, student id, and the score
	 * @param testId The id of the test
	 * @param studentId The id of the student who took the test
	 * @param score The score that the student got on this test
	 */
	public Mark(int testId, int studentId, int score) {
		this.testId = testId;
		this.studentId = studentId;
		this.score = score;
	}
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
