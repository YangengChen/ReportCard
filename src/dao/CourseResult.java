package dao;

/**
 * @author Yangeng Chen
 *
 */
public class CourseResult {

	private double weightedTotal;
	private int testsTaken;
	
	/**
	 * Creates a CourseResult object which stores the weightedTotal or final score, and the number of tests taken 
	 * @param weightedTotal The weighted total of the entire course, or final score
	 * @param testsTaken The number of tests taken by the student
	 */
	public CourseResult(double weightedTotal, int testsTaken) {
		this.weightedTotal = weightedTotal;
		this.testsTaken = testsTaken;
	}
	
	public double getWeightedTotal() {
		return weightedTotal;
	}
	public void setWeightedTotal(double weightedTotal) {
		this.weightedTotal = weightedTotal;
	}
	public int getTestsTaken() {
		return testsTaken;
	}
	public void setTestsTaken(int testsTaken) {
		this.testsTaken = testsTaken;
	}

	/**
	 * Adds the following weighted score into the weighted total
	 * @param weightedScore A weighted score that is to be added to the total
	 */
	public void addWeightedScore(double weightedScore) {
		weightedTotal += weightedScore;
	}
	
	/**
	 * Increments the number of tests taken by 1
	 */
	/**
	 * 
	 */
	public void testsTakenPlusOne() {
		testsTaken += 1;
	}
	
}
