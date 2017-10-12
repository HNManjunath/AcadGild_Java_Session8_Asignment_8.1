/**
 * 
 */
package assignment8_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author MANJUNATH, This class is to implement File copying functionality.
 *
 */
public class Assignment8_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inStream = null;
		OutputStream outStream = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter source file name to copy: \n");
		String filePath = sc.nextLine(); // Scanner class to get the input file
		File sourceFile = new File(filePath); // passing the input file path

		String destinationFileName = sourceFile.getName(); // getting source file name and assigning it to destination
															// file name
		String destinationLocation = filePath.substring(0, filePath.lastIndexOf(File.separator)) + File.separator
				+ (destinationFileName).substring(0, destinationFileName.lastIndexOf(".")) + "_destination" + "."
				+ (destinationFileName).substring(destinationFileName.lastIndexOf(".") + 1,
						destinationFileName.length()); // setting path for destination file

		try {
			inStream = new FileInputStream(sourceFile); // assigning sourcefile to input stream
			outStream = new FileOutputStream(destinationLocation); // assigning output file to output stream
			byte[] buffer = new byte[1024];
			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
			sc.close(); // closing scanner class object
			inStream.close(); // Closing the input stream
			outStream.close(); // Closing the output stream.
			System.out.println(
					"File Copied Successfully, check the copied file with the file name ending _destination.txt followed by ur file name");
			
			System.out.println("Copied file name with Location: \t"+destinationLocation);
		} catch (IOException e) {
			e.printStackTrace(); // catch exception if file path is incorrect.
		}

	}
}
