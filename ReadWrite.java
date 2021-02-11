package readWrite;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;



public class ReadWrite {

	
	public static <T> T readText(T object) {
		Scanner scan = new Scanner(System.in);

		BufferedReader bf = null;

		try {
			// Open the file.
			bf = openRead();

			// read in the first line
			String line = "";
			try {
				line = bf.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String temp;
			// while there is more data in the file, process it
			// delim is where you want to break it at
			while (line != null) {
				StringTokenizer st = new StringTokenizer(line, "-");
				while (st.hasMoreTokens()) {

					//temp = st.nextToken().trim();
					//temp = temp.replaceAll("[^a-zA-Z]", "");
					//if (!temp.isEmpty())
					//	dictionary.add(temp);

				}
				// read in the next line
				try {
					line = bf.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // end of reading in the data.

		}
		// catch any other type of exception
		catch (Exception e) {
			System.out.println("Format of the file is incorect, please choose another file");
		} finally {
			try {
				bf.close();
			} catch (Exception e) {
			}
		}
		return object;
	}

	public static BufferedReader openRead() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for reading your file", FileDialog.LOAD);
		System.out.println(
				"The dialog box will appear behind Eclipse.  " + "\n   Choose where you would like to read from.");
		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		// create a file instance for the absolute path
		File inFile = new File(dirPath + foName);

		while (!inFile.exists()) {
			System.out.println(" ");
			System.out.println("File does not exist, please choose another file");
			System.out.println(
					"The dialog box will appear behind Eclipse.  " + "\n   Choose where you would like to read from.");
			foBox.setVisible(true);
			// get the absolute path to the file
			foName = foBox.getFile();
			dirPath = foBox.getDirectory();

			// create a file instance for the absolute path
			inFile = new File(dirPath + foName);
		}

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inFile));
		} catch (IOException e) {
			System.out.println("You threw an exception");

		}
		return in;

	}

	public static <T> void writeText(T object) {

		PrintWriter out = null;
		try {
			out = openWrite();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    //List keys = new ArrayList(quiz.keySet());

		// this writes to a file.
		//for (int i = 0; i < quiz.size(); i++) {
			//Employee emp = e.get(i);
			//out.println(emp.toStringF());
		
		out.close();

		System.out.println("The data was saved to a file");
	}

	public static PrintWriter openWrite() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for writing your file", FileDialog.SAVE);
		System.out.println("The dialog box will appear behind Eclipse.  "
				+ "\n   Choose where you would like to write your data.");
		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		// create a file instance for the absolute path
		File outFile = new File(dirPath + foName);
		PrintWriter out = null;

		try {
			out = new PrintWriter(outFile);
		} catch (IOException e) {
			System.out.println("You threw an exception");
		}
		return out;
	}
}
