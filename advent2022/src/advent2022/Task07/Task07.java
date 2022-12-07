package advent2022.Task07;

import java.util.*;

public class Task07 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Tree tree = new Tree();
		scan.nextLine();
		String command = scan.nextLine();
		while(!command.equals("end")) {
			
			String[] components = command.replace("$ ", "").split(" ");
			switch(components[0]) {
				case "cd":
					tree.cd(components[1]);
					break;
				case "ls":
					break;
				case "dir":
					tree.add('d', 0, components[1]);
					break;
				default:
					tree.add('f', Long.valueOf(components[0]), components[1]);
					break;
			}
			
			command = scan.nextLine();
		}
		
		// Part one
		//tree.sum(tree.root);
		System.out.println(tree.canSum());
		
		// Part two
		tree.sum(tree.root);
		System.out.println(tree.needSpace());
		System.out.println(tree.delete(tree.needSpace()));
		
		
	}
	
	private class Direction{
		
		long size;
		String name;
		
		private Direction(long size, String name) {
			this.size = size;
			this.name = name;
		}
	}

}
