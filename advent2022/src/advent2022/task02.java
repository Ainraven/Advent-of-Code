package advent2022;

import java.util.*;

public class task02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int total = 0;
		char op = 's';
		char me = 's';
		
		System.out.println("input: ");
		
		while(op != 'q') {
			total += winCountSec(op, me);
			
			op = scan.next().charAt(0);
			me = scan.next().charAt(0);
		}
		
		System.out.println("total: " + total);
		
	}
	
	public static int winCount(char op, char me) {

		final int win = 6;
		final int draw = 3;
		final int stone = 1;
		final int paper = 2;
		final int scissors = 3;
		
		if(op == 'A') {
			switch(me) {
			case 'X':
				return draw + stone;
			case 'Y':
				return win + paper;
			default:
				return 0 + scissors;
			}
		}
		
		if(op == 'B') {
			switch(me) {
			case 'Y':
				return draw + paper;
			case 'Z':
				return win + scissors;
			default:
				return 0 + stone;
			}
		}
		
		if(op == 'C') {
			switch(me) {
			case 'X':
				return win + stone;
			case 'Z':
				return draw + scissors;
			default:
				return 0 + paper;
			}
		}
		
		return 0;
	}
	
	public static int winCountSec(char op, char me) {

		final int win = 6;
		final int draw = 3;
		final int lose = 0;
		final int stone = 1;
		final int paper = 2;
		final int scissors = 3;
		
		if(op == 'A') {
			switch(me) {
			case 'X':
				return lose + scissors;
			case 'Y':
				return draw + stone;
			case 'Z':
				return win + paper;
			default:
				break;
			}
		}
		
		if(op == 'B') {
			switch(me) {
			case 'X':
				return lose + stone;
			case 'Y':
				return draw + paper;
			case 'Z':
				return win + scissors;
			default:
				break;
			}
		}
		
		if(op == 'C') {
			switch(me) {
			case 'X':
				return lose + paper;
			case 'Y':
				return draw + scissors;
			case 'Z':
				return win + stone;
			default:
				break;
			}
		}
		
		return 0;
	}

}
