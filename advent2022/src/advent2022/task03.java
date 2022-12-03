package advent2022;

import java.util.*;
import java.util.stream.*;

public class task03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> rucksack = new ArrayList<String>();
		
		System.out.println("Input: ");
		
		String scanned = scan.nextLine();
		while(!scanned.equals("end")) {
			rucksack.add(scanned);
			scanned = scan.nextLine();
		}
		
		// First part
		/*
		int[] items = new int[rucksack.size()];
		int i = 0;
		
		for(String oneSack : rucksack) {
			items[i++] = checkRucksack(oneSack);
		}
		
		System.out.println("Sum: " + IntStream.of(items).sum());
		*/
		
		// Second part
		
		int sum = 0;
		
		for(int i = 0; i < rucksack.size(); i+=3) {
			sum += groupBadge(	rucksack.get(i),
								rucksack.get(i + 1),
								rucksack.get(i + 2));
		}
		
		System.out.println("Sum: " + sum);
		
		scan.close();

	}
	
	private static int checkRucksack(String contents) {
	
		String first = contents.substring(0, contents.length()/2);
		String second = contents.substring(contents.length()/2);
		
		int[] alphabet = new int[53];
		
		for(int i = 0; i < 53; i++)
			alphabet[i] = 0;
		
		for(char c : first.toCharArray()) {
			alphabet[itemValue(c)]++;
		}
		
		for(char c : second.toCharArray()) {
			if(alphabet[itemValue(c)] > 0)
				return itemValue(c);
		}
		
		return 0;
		
	}
	
	private static int groupBadge(String one, String two, String three) {
		
		int[] alphabet = new int[53];
		for(int i = 0; i < 53; i++)
			alphabet[i] = 0;
		
		for(char c : one.toCharArray()) {
			if(alphabet[itemValue(c)] == 0)
				alphabet[itemValue(c)]++;
		}
		
		for(char c : two.toCharArray()) {
			if(alphabet[itemValue(c)] == 1)
				alphabet[itemValue(c)]++;
		}
		
		for(char c : three.toCharArray()) {
			if(alphabet[itemValue(c)] == 2)
				alphabet[itemValue(c)]++;
		}
		
		for(int i = 1; i < 53; i++) {
			if(alphabet[i] == 3)
				return i;
		}
		
		return 0;
	}
	
	private static int itemValue(char item) {
		
		int value;
		
		if(item > 90)
			value = item - 96;
		else
			value = item - 38;
		
		return value;
		
	}
	
}
