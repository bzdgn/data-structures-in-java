package ds_013_network_algorithms.sampleClasses;

import java.util.LinkedList;
import java.util.List;

public class EnhancedDirectedNodeExampleClass {
	
	private final String label;
	private List<EnhancedDirectedLinkExampleClass> inLinks;
	private List<EnhancedDirectedLinkExampleClass> outLinks;
	
	public EnhancedDirectedNodeExampleClass(String label) {
		this.label = label;
		this.inLinks = new LinkedList<>();
		this.outLinks = new LinkedList<>();
	}

}
