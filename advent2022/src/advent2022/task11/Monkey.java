package advent2022.task11;

import java.util.*;

public class Monkey {
	ArrayList<Long> items = new ArrayList<Long>();
	char op;
	int opValue;
	int testValue;
	int trueMonkey;
	int falseMonkey;
	int itemsInspected;
	
	public Monkey(ArrayList<Long> items, char op, int opValue, int testValue, int trueMonkey, int falseMonkey) {
		this.items = items;
		this.op = op;
		this.opValue = opValue;
		this.testValue = testValue;
		this.trueMonkey = trueMonkey;
		this.falseMonkey = falseMonkey;
		this.itemsInspected = 0;
	}
	
	public long operation(long old) {
		long newLevel = 0;
		switch(op) {
		case '*':
			newLevel = old * opValue;
			break;
		case '+':
			newLevel = old + opValue;
			break;
		case 's':
			newLevel = old * old;
			break;
		default:
			break;
		}
		
		return newLevel;
	}
	
	public boolean test(long old) {
		if(old % testValue == 0) return true;
		else return false;
	}
	
	public long cut(long old, int div) {
		return old % div;
	}
	
	public int bored(long old) {
		double newValue = old / 3;
		return (int)Math.round(newValue);
	}
	
	public void print() {
		for(long item : items) {
			System.out.print(item + ", ");
		}
		System.out.println();
		
		/*
		System.out.print("Starting items: ");
		for(int item : items) {
			System.out.print(item + ", ");
		}
		System.out.println();
		
		System.out.println("Operation: new = old " + op + " " + opValue);
		System.out.println("Test: divisible by " + testValue);
		System.out.println("  If true: throw to monkey " + trueMonkey);
		System.out.println("  If false: throw to monkey " + falseMonkey);
		*/
	}
}
