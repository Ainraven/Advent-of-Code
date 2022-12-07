package advent2022;

import java.util.*;

public class Task06 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String datastream = scan.nextLine();
		
		for(int i = 14; i < datastream.length(); i++) {
			//String subFour = datastream.substring(i - 4, i);
			String subFourteen = datastream.substring(i - 14, i);
			
			if(hasUniqueChars(subFourteen)) {
				System.out.println("Answer: " + i);
				break;
			}
			
		}
		
	}
	
	private static boolean hasUniqueChars(String str) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = i+1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}

}
