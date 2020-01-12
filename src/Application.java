import java.util.Set;
import java.util.TreeSet;

import dao.ReportCard;
import dao.Student;
import services.ReaderService;
import services.WriterService;

/**
 * @author Yangeng Chen
 *
 */
public class Application {

	/**
	 * The main method will take the 4 input arguments and process them one by one by the ReaderService
	 * Then it will use the WriterService to generate the Report Card of each student sorted by their id number 
	 * @param args
	 */
	public static void main(String[] args) {
		ReaderService readerService = new ReaderService();
		String courseFile = args[0];
		String studentFile = args[1];
		String testFile = args[2];
		String markFile = args[3];
		readerService.setUpCourses(courseFile);
		readerService.setUpStudents(studentFile);
		readerService.setUpTests(testFile);
		readerService.setUpMarks(markFile);
		readerService.setUpStudentScores();
		Set<Integer> studentIds = new TreeSet<Integer>(readerService.getStudents().keySet());
		for(int id : studentIds) {
			Student student = readerService.getStudents().get(id);
			ReportCard reportCard = new ReportCard(student);
			WriterService writerService = new WriterService();
			writerService.createReportCard(reportCard.toString());
		}
	}

}
