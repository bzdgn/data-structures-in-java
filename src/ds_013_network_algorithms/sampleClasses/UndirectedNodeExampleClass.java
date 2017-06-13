package ds_013_network_algorithms.sampleClasses;

import java.util.LinkedList;
import java.util.List;

public class UndirectedNodeExampleClass {
	
	private final String label;
	private List<UndirectedLinkExampleClass> links;
	
	public UndirectedNodeExampleClass(String label) {
		this.label = label;
		this.links = new LinkedList<>();
	}

}
