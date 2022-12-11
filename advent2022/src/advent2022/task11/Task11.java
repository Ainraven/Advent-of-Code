package advent2022.task11;

import java.util.*;
import java.math.BigInteger;

public class Task11 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int start = 18;
		final int opChar = 23;
		final int opVal = 25;
		final int testVal = 21;
		final int trueVal = 29;
		final int falseVal = 30;
		
		final int rounds = 10000;
		final int amountOfMonkeys = 8;
		
		Monkey[] monkeys = new Monkey[amountOfMonkeys];
		
		for(int i = 0; i < amountOfMonkeys; i++) {
			// Get all input for one monkey
			scan.nextLine();
			String two = scan.nextLine();
			String three = scan.nextLine();
			String four = scan.nextLine();
			String five = scan.nextLine();
			String six = scan.nextLine();
			scan.nextLine();
			
			// Get starting items
			ArrayList<Long> items = splitInts(two.substring(start));
			
			// Get operator and it's value
			char op = 'n';
			int value = 0;
			if(three.charAt(opVal) == 'o') {
				op = 's';
			}
			else {
				op = three.charAt(opChar);				
				value = Integer.valueOf(three.substring(opVal));
			}
			
			// Get test value
			int testV = Integer.valueOf(four.substring(testVal));
			
			// Get true and false monkey
			int tm = Integer.valueOf(five.substring(trueVal));
			int fm = Integer.valueOf(six.substring(falseVal));
			
			// Create a new monkey
			monkeys[i] = new Monkey(items, op, value, testV, tm, fm);
		}
		
		int div = 1;
		
		for(Monkey mon : monkeys) {
			System.out.print("Monkey x: ");
			mon.print();
			div *= mon.testValue;
		}
		
		System.out.println(div);
		
		for(int i = 0; i < rounds; i++) {
			//System.out.println("\n-------------------- Round " + (i + 1));
			for(int j = 0; j < amountOfMonkeys; j++) {
				int size = monkeys[j].items.size();
				for(int k = 0; k < size; k++) {
					long worryLevel = monkeys[j].items.get(0);
					worryLevel = monkeys[j].operation(worryLevel);
					//worryLevel = monkeys[j].bored(worryLevel);
					worryLevel = monkeys[j].cut(worryLevel, div);
					int nextMonkey = monkeys[j].test(worryLevel) ? monkeys[j].trueMonkey : monkeys[j].falseMonkey;
					monkeys[nextMonkey].items.add(worryLevel);
					monkeys[j].items.remove(0);
					//System.out.println("-- Monkey " + j + " threw item " + worryLevel + " to the Monkey " + nextMonkey + " --");
					monkeys[j].itemsInspected++;
				}
				//System.out.print("Monkey " + j + ": ");
				//monkeys[j].print();
			}
			//System.out.println("round " + i);
		}
		
		long[] activity = new long[amountOfMonkeys];
		for(int i = 0; i < amountOfMonkeys; i++) {
			activity[i] = monkeys[i].itemsInspected;
		}
		
		Arrays.sort(activity);
		
		//System.out.println(activity[3]);
		
		long monkeyBussiness = activity[amountOfMonkeys - 1] * activity[amountOfMonkeys - 2];
		
		System.out.println("Monkey bussiness: " + monkeyBussiness);

		scan.close();
	}
	
	public static ArrayList<Long> splitInts(String itemList) {
		String[] splittedItems = itemList.split(", ");
		ArrayList<Long> items = new ArrayList<Long>();
		for(int j = 0; j < splittedItems.length; j++)
			items.add(Long.valueOf(splittedItems[j]));
		return items;
	}
}
