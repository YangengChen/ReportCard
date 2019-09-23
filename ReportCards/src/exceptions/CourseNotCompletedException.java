package exceptions;

/**
 * @author Yangeng Chen
 *
 */
public class CourseNotCompletedException extends Exception {

	/**
	 * Creates a CourseNotCompletedException; is thrown when a student did not complete a course
	 * @param msg
	 */
	public CourseNotCompletedException(String msg){
		super(msg);
	}
}
