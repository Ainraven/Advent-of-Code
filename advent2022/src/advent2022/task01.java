package advent2022;

import java.util.*;

public class task01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input: ");
		ArrayList<Integer> cals = new ArrayList<Integer>();
		int current = 0;
		String next = "0";
		
		while(!next.equals("end")) {
			if(next.isEmpty()) {
				cals.add(current);
				current = 0;
				next = scan.nextLine();
				continue;
			}
			current += Integer.valueOf(next);
			next = scan.nextLine();
		}
		
		int length = cals.size();
		
		Collections.sort(cals);
		
		int sum = 0;
		
		for(int i = length-1; i > length-4; i--)
			sum += cals.get(i);
		
		System.out.println(sum);
		
	}
}
