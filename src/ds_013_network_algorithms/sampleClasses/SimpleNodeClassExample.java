package ds_013_network_algorithms.sampleClasses;

import java.util.LinkedList;
import java.util.List;

public class SimpleNodeClassExample {
	
	private final String label;
	private final List<SimpleNodeClassExample> neighbors;
	private final List<Integer> costs;
	private boolean visited;
	
	public SimpleNodeClassExample(String label) {
		this.label = label;
		this.neighbors = new LinkedList<>();
		this.costs = new LinkedList<>();
		this.visited = false;
	}
	
}
