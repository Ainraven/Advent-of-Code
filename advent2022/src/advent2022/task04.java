package advent2022;

import java.util.*;

public class task04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> input = new ArrayList<String>();
		System.out.println("Input: ");
		String scanned = scan.nextLine();
		
		while(!scanned.equals("end")) {
			input.add(scanned);
			
			scanned = scan.nextLine();
		}
		
		int overlapping = 0;
		
		// Part One
		/*
		for(String line : input) {
			int[] areas = splitID(line);
			if(		(areas[0] <= areas[2] && areas[1] >= areas[3]) ||
					(areas[0] >= areas[2] && areas[1] <= areas[3]))
				overlapping++;
		}
		*/
		
		// Part Two
		
		for(String line : input) {
			int[] areas = splitID(line);
			if(		(areas[0] >= areas[2] && areas[0] <= areas[3]) ||
					(areas[1] >= areas[2] && areas[1] <= areas[3]) ||
					(areas[2] >= areas[0] && areas[2] <= areas[1]) ||
					(areas[3] >= areas[0] && areas[3] <= areas[1]) )
				overlapping++;
		}
		
		System.out.println("Answer: " + overlapping);

	}
	
	private static int[] splitID(String str) {
		String[] substrings = str.split(",");
		String[] first = substrings[0].split("-");
		String[] second = substrings[1].split("-");
		
		int[] ids = new int[4];
		int i = 0;
		
		ids[i++] = Integer.valueOf(first[0]);
		ids[i++] = Integer.valueOf(first[1]);
		ids[i++] = Integer.valueOf(second[0]);
		ids[i++] = Integer.valueOf(second[1]);
		
		return ids;
	}
	
}
