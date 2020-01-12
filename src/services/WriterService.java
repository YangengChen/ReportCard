package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.filechooser.FileSystemView;

/**
 * @author Yangeng Chen
 *
 */
public class WriterService {
	
	/**
	 * This method takes in the student report to write from. Writes the text file "reportcard.txt" into desktop.
	 * It also appends to the file if existing, if not, creates a new file
	 * @param report
	 */
	public void createReportCard(String report) {
		FileSystemView filesys = FileSystemView.getFileSystemView();
		File[] roots = filesys.getRoots();
		File userHomeFolder = filesys.getHomeDirectory();
		File textFile = new File(userHomeFolder, "reportcard.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(textFile, true));
				 PrintWriter writer = new PrintWriter(bw)) 
		{
			writer.println(report);
		} catch (IOException e) {
			System.out.println("Invalid file");
		}
	}
	
}


