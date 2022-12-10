package advent2022;

import java.util.*;

public class Task09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		
		char direction = scan.next().charAt(0);
		int length = scan.nextInt();
		int[] x = new int[10];
		int[] y = new int[10];
		int hx, hy, tx, ty;
		
		while(direction != 'e') {
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < 9; j++) {
					
					hx = x[j]; hy = y[j];
					tx = x[j+1]; ty = y[j+1];
					// Head moves
					if(j == 0) {
						switch(direction) {
						case 'U':
							hy++;
							break;
						case 'D':
							hy--;
							break;
						case 'R':
							hx++;
							break;
						case 'L':
							hx--;
							break;
						default:
							break;
						}
					}
					if(hy - ty > 1) {
						if(hx == tx)
							ty++;
						else if(hx > tx) {
							ty++; tx++; }
						else if(hx < tx) {
							ty++; tx--; }
					}
					if(ty - hy > 1) {
						if(hx == tx)
							ty--;
						else if(hx > tx) {
							ty--; tx++; }
						else if(hx < tx) {
							ty--; tx--; }
					}
					if(hx - tx > 1) {
						if(hy == ty)
							tx++;
						else if(hy > ty) {
							tx++; ty++; }
						else if(hy < ty) {
							tx++; ty--; }
					}
					if(tx - hx > 1) {
						if(hy == ty)
							tx--;
						else if(hy > ty) {
							tx--; ty++; }
						else if(hy < ty) {
							tx--; ty--; }
					}
					
					
					
					
					x[j] = hx; y[j] = hy;
					x[j+1] = tx; y[j+1] = ty;
					
					if(j == 8) {
						String coords = x[9] + ":" + y[9];
						visited.put(coords, true);
					}
				}
			}
			direction = scan.next().charAt(0);
			length = scan.nextInt();
		}
		int count = 0;
		for(boolean was : visited.values()) {
			if(was)
				count++;
		}
		
		System.out.println(count);
		
		//System.out.println(visited.keySet());
	}
}
