package ds_013_network_algorithms.sampleClasses;

import java.util.LinkedList;
import java.util.List;

public class DirectedNodeExampleClass {
	
	private final String label;
	private List<DirectedLinkExampleClass> links;
	
	public DirectedNodeExampleClass(String label) {
		this.label = label;
		this.links = new LinkedList<>();
	}

}
