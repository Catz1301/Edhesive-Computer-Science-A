import java.util.*;
import java.lang.*;

class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		println("How long do you want the array?");
		int arrLen = scn.nextInt();
		double sum = 0;
		boolean invalid = false;
		double highest = 0;
		double lowest = 0;

		boolean sortedAscending = true;
		boolean sortedDescending = true;
		boolean notSorted = false;

		
		if (arrLen < 1) {
			println("Not a valid length!");
			invalid = true;
		}

		if (invalid == false) {
			double[] arr = new double[arrLen];
			for (int i = 0; i < arrLen; i++) {
				println("Enter a number");
				arr[i] = scn.nextDouble();
			}
			print("Your array is {");
			for (int i = 0; i < arrLen; i++) {
				if (i == arrLen-1)
					print(arr[i] + "}\n");
				else
					print(arr[i] + ", ");
			}

			for (int i = 0; i < arrLen; i++) {
				sum += arr[i];
			}
			double average = (double) sum / (double) arrLen;
			println("The average is " + average);

			for (int i = 0; i < arrLen; i++) {
				double tmp = arr[i];
				if (tmp > highest)
					highest = tmp;
			}
			lowest=highest;
			for (int i = 0; i < arrLen; i++) {
				double tmp = arr[i];
				if (tmp < lowest)
					lowest = tmp;
			}

			double range = highest - lowest;
			println("The range is " + range);
			double sortValue = 0;
			for (int i = 0; i < arrLen; i++) {
				double tmp = arr[i];
				if (sortedAscending == true && tmp > sortValue)
					sortedDescending = false;
				else if (sortedDescending == true &&tmp < sortValue)
					sortedAscending = false;
				else {
					sortedAscending = false;
					sortedDescending = false;
					notSorted = true;
				}
				sortValue = tmp;
			}

			/*println("notSorted=" + notSorted);
			println("sortedAscending=" + sortedAscending);
			println("sortedDescending=" + sortedDescending);
			println("lowest=" + lowest);
			println("highest=" + highest);*/
			String sortMethod = "";
			if (sortedAscending == true)
				sortMethod = "The array is sorted in increasing order";
			else if (sortedDescending == true)
				sortMethod = "The array is sorted in decreasing order";
			else if (notSorted == true)
				sortMethod = "The array is unsorted";
			println(sortMethod);
		}
	}

	public static void println(String str) {
		System.out.println(str);
	}
	public static void print(String str) {
		System.out.print(str);
	}
}
