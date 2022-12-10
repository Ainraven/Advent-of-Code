package advent2022;

import java.util.*;

public class Task10 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int cycle = 0;
		int xValue = 2;
		
		String op = scan.next();
		int add = 0;
		int test = 20;
		int sum = 0;
		int addC = 1;
		char[][] render = new char[10][41]; 
		int i = 0; int j = 1;
		
		while(!op.equals("end")) {
			
			// Cycle begins
			cycle++;
			
			// During the cycle
			
			if(xValue - j == 1 || j - xValue == 1 || j == xValue) {
				render[i][j++] = '#';
			}
			else {
				render[i][j++] = '.';
			}
			
			if(j % 40 == 1) {
				j = 1;
				i++;
			}
			if(cycle == test) {
				sum += cycle * xValue;
				test += 40;
			}
			
			if(op.equals("noop")) add = 0;
			
			if(op.equals("addx")) {				
				addC = (addC + 1) % 2;
				if(addC == 0) {
					add = scan.nextInt();
					continue;
				}				
			}
			
			// Cycle ends
			xValue += add;
			
			op = scan.next();
		}
		
		System.out.println("Done ---------------------------");
		System.out.println("Sum: " + sum);
		for(int x = 0; x < 6; x++) {
			for(int y = 1; y < 41; y++) {
				System.out.print(render[x][y]);
			}
			System.out.print("\n");
		}
	}

}
