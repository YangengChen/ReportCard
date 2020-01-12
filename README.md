How to Run this Application

On Windows:

Using command prompt, go to the source repository, the directory where Application.java file
is resting. In my case, it is C:\Users\yan\workspace\ReportCards\src. Once you are at the
source repository, enter this command: 
						javac Application.java 

If it says missing classes or doesn't work, use this command instead: 
						javac -classpath . Application.java
						
That should let you compile the source files. Once that's done, you should see .class files,
and now you can run the program using the following command:
						java Application [csv1] [csv2] [csv3] [csv4]		or
						java -cp . Application [csv1] [csv2] [csv3] [csv4]
where csv1, csv2, csv3, csv4 are the paths to the input csv files
						
*NOTE*: VERY IMPORTANT. 
csv1 must be the courses.csv file 
csv2 must be the students.csv file
csv3 must be the tests.csv file
csv4 must be the marks.csv 

Otherwise, the arguments will be wrongly read and the program will not work. 

I have only tested Windows so far, and haven't tried on other operating systems.


About this Program:
The main purpose of this program is to generate report cards of each student provided by 
the data files from the input. The report cards will be written out into a text file that
can be written into any time, as well as open. The program will display the calculated 
final grade of each course enrolled and completed by each student, as well as the overall 
average, name of the course and teacher.