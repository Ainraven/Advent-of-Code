package advent2022;

import java.util.*;

public class Task08 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> scanGrid = new ArrayList<String>();
		
		String scanned = scan.nextLine();
		
		while(!scanned.equals("end")) {
			scanGrid.add(scanned);
			scanned = scan.nextLine();
		}
		
		int[][] grid = new int[scanGrid.size()][scanGrid.get(0).length()];
		int[][] testGrid = new int[grid.length][grid[0].length];
		
		//System.out.println(grid.length + " +++ " + grid[0].length);
		
		for(int i = 0; i < scanGrid.size(); i++) {
			for(int j = 0; j < scanGrid.get(i).length(); j++) {
				grid[i][j] = Integer.valueOf(scanGrid.get(i).charAt(j));
				testGrid[i][j] = 0;
			}
		}
		
		//print(grid);
		//print(testGrid);
		
		int visible = 0;
		int max = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				// Part One
				/*
				if(i == 0 || i == grid.length - 1 || j == 0 || j == grid[i].length - 1) {
					visible++;
					testGrid[i][j] = 1;
					continue;
				}
				
				int invis = 0;
				
				for(int k = i-1; k > -1; k--) {
					if(grid[i][j] <= grid[k][j]) {
						invis++;
						break;
					}
				}
				for(int k = i+1; k < grid.length; k++) {
					if(grid[i][j] <=grid[k][j]) {
						invis++;
						break;
					}
				}
				for(int l = j-1; l > -1; l--) {
					if(grid[i][j] <= grid[i][l]) {
						invis++;
						break;
					}
				}
				for(int l = j+1; l < grid[i].length; l++) {
					if(grid[i][j] <= grid[i][l]) {
						invis++;
						break;
					}
				}
				
				if(invis < 4) {
					visible++;
					testGrid[i][j] = 1;
				}
				*/
				
				// Part Two
				
				int scenic;
				int[] visibility = new int[4];
				
				for(int k = i-1; k > -1; k--) {
					visibility[0]++;
					if(grid[i][j] <= grid[k][j]) {
						break;
					}
				}
				for(int k = i+1; k < grid.length; k++) {
					visibility[1]++;
					if(grid[i][j] <=grid[k][j]) {
						break;
					}
				}
				for(int l = j-1; l > -1; l--) {
					visibility[2]++;
					if(grid[i][j] <= grid[i][l]) {
						break;
					}
				}
				for(int l = j+1; l < grid[i].length; l++) {
					visibility[3]++;
					if(grid[i][j] <= grid[i][l]) {
						break;
					}
				}
				
				scenic = visibility[0] * visibility[1] * visibility[2] * visibility[3];
				if(scenic > max) max = scenic;
				
			}
		}
		
		//print(testGrid);
		System.out.println("Visible trees: " + visible);
		System.out.println("Max scenic value: " + max);
		
	}
	
	public static void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}
