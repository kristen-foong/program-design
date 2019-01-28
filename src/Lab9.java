/**
 * 
 * @author kfoong00
 * Nov 20, 2017
 * Takes information from the text file and sorts them by month or by name
 * without using arrays.sort 
 *
 */

import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;

public class Lab9 {

	public static void main(String[] args) throws IOException {

		String filename = "releasedates.txt";
		String[] releasedates = input(filename);
		output("newreleasedates.txt", releasedates);
		output("SortedByDate.txt", sortByMonth(releasedates));
		output("SortedByName.txt", sortByName(releasedates));
		//check output
		//System.out.println(Arrays.toString(sortByMonth(releasedates)));
		//System.out.println(Arrays.toString(sortByName(releasedates)));
	}

	public static String[] input(String filename) throws IOException {

		Scanner scan = new Scanner(new File(filename));
		int count = 0;
		//measures length of list
		while (scan.hasNextLine()) {
			scan.nextLine();
			count++;
		}
		//scan file
		scan = new Scanner(new File(filename));
		String[] releasedates = new String[count];
		//copies from one file into new string
		for (int i = 0; i < count; i++) {
			if (scan.hasNextLine()) {
				releasedates[i] = scan.nextLine();
			}
		}
		scan.close();

		return releasedates;

	}

	public static void output(String filename, String[] info)
			throws IOException {
		
		PrintWriter dothething = new PrintWriter(new File(filename));
		for (int i = 0; i < info.length; i++) {
			//prints into new file
			dothething.println(info[i]);
		}
		dothething.close();
	}

	public static String[] sortByMonth(String[] info) {
		
		String[] checkDate = new String[info.length];

		for (int s = 0; s < info.length; s++) {
			//cuts the information to only contain the date
			String name = info[s].substring(0,8);
			checkDate[s] = name;
		}
		
		//returns the sorted info array, sorted by date
		return selectionSort(checkDate, info);

	}


	public static String[] sortByName(String[] info) {

		String[] checkName = new String[info.length];

		for (int s = 0; s < info.length; s++) {
			// cuts it such that the name array only has the titles
			String name = info[s].substring(8, info[s].length());
			checkName[s] = name;
		}
		
		//returns the sorted info array, sorted by name
		return selectionSort(checkName, info);

	}

	public static String[] selectionSort(String[] stuff, String[] info) {

		// compares and sorts checkMonth
		for (int i = 0; i < stuff.length - 1; i++) {
			for (int j = i + 1; j < stuff.length; j++) {
				if (stuff[i].compareTo(stuff[j]) > 0) {
					//swaps the stuff array
					String temp = stuff[j];
					stuff[j] = stuff[i];
					stuff[i] = temp;
					//swaps the info array to match
					String temp2 = info[j];
					info[j] = info[i];
					info[i] = temp2;
				}
			}
		}

		return info;
	}

}
