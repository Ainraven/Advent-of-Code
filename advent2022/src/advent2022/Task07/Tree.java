package advent2022.Task07;

import java.util.*;

public class Tree {
	
	private class Node {
		
		char type;
		long size;
		String name;
		
		ArrayList<Node> children;
		int amountOfChildren;
		Node parent;
		
		private Node(char type, long size, String name, Node parent) {
			this.type = type;
			this.size = size;
			this.name = name;
			this.parent = parent;
			children = new ArrayList<Node>();
			amountOfChildren = 0;
		}
		
	}
	
	Node root;
	Node current;
	
	public Tree() {
		root = new Node('d', 0, "/", null);
		current = root;
	}
	
	public void cd(String name) {
		if(name.equals("/")) 	{ current = root; 			return; }
		if(name.equals(".."))	{ current = current.parent; return; }
		
		for(int i = 0; i < current.amountOfChildren; i++) {
			if(current.children.get(i).name.equals(name)) {
				current = current.children.get(i);
				return;
			}
		}
		System.out.println(name + " directory doesn't exist");
	}
	
	public void add(char type, long size, String name) {
		current.children.add(new Node(type, size, name, current));
		current.amountOfChildren++;
	}
	
	public void setSize(long size) {
		current.size = size;
	}
	
	// Part one
	//final int limit = 100000;
	
	// Part two
	final int limit = Integer.MAX_VALUE;
	
	ArrayList<Long> candidates = new ArrayList<Long>();
	
	public void sum(Node here) {
		
		if(here == null) return;
		
		for(int i = 0; i < here.amountOfChildren; i++) {
			sum(here.children.get(i));
		}
		
		if(here.type == 'd') {
			for(int i = 0; i < here.amountOfChildren; i++) {
				here.size += here.children.get(i).size;
			}
			if(here.size <= limit) {
				candidates.add(here.size);
			}
		}	
	}
	
	public long canSum() {
		long sum = 0;
		for(long can : candidates) {
			sum += can;
		}
		return sum;
	}
	
	public long needSpace() {
		return 30000000 - (70000000 - root.size);
	}
	
	public long delete(long space) {
		long min = Long.MAX_VALUE;
		for(long can : candidates) {
			if(can >= space && can < min) {
				min = can;
			}
		}
		return min;
	}
	
}
