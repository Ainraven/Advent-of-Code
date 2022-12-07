package advent2022;

import java.util.*;

public class Task05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Stack<String>[] stacks = new Stack[10];
		for(int i = 0; i < 10; i++) {
			stacks[i] = new Stack<String>();
		}

		stacks = stacksInit(stacks);
		
		String scanned = scan.next();
		
		// Part one
		
		/*
		while(!scanned.equals("end")) {
			int amount = scan.nextInt();
			scan.next();
			int fromCrate = scan.nextInt();
			scan.next();
			int toCrate = scan.nextInt();
			scanned = scan.next();
			
			for(int i = 0; i < amount; i++) {
				stacks[toCrate].push(stacks[fromCrate].pop());
			}
		}
		*/
		
		// Part Two
		
		Stack<String> temp = new Stack<String>();

		while(!scanned.equals("end")) {
			int amount = scan.nextInt();
			scan.next();
			int fromCrate = scan.nextInt();
			scan.next();
			int toCrate = scan.nextInt();
			scanned = scan.next();
			
			for(int i = 0; i < amount; i++) {
				temp.push(stacks[fromCrate].pop());
			}
			for(int i = 0; i < amount; i++) {
				stacks[toCrate].push(temp.pop());
			}
		}
		
		// Answer
		
		for(int i = 1; i < 10; i++) {
			System.out.print(stacks[i].pop());
		}

	}
	
	private static Stack<String>[] stacksInit(Stack<String>[] stacks) {
		String initValues = "RPWNMPRQLNNRBZRTTMFDCSWMNHHVZD0PWGFZLFG0C0LNNJJ00B0SBFSW00F0WV0MH00N0000";
		
		int si = 0;
		for(int i = 0; i < initValues.length(); i++) {
			si++;
			if(si == 10)	si = 1;
			String crate = Character.toString(initValues.charAt(i));
			
			if(crate.equals("0")) continue;
			stacks[si].push(crate);
		}
		
		return stacks;

	}

}
