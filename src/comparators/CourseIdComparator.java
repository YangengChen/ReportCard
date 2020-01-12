package comparators;

import java.util.Comparator;

import dao.Course;

/**
 * @author Yangeng Chen
 *
 */
public class CourseIdComparator implements Comparator<Course> {
	
	/**
	 * Creates a Comparator to sort the Course by its id 
	 */
	@Override
	public int compare(Course c1, Course c2) {
		return c1.getId() - c2.getId();
	}
	
}

