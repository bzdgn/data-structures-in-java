package ds_013_network_algorithms.sampleClasses;

public class UndirectedLinkExampleClass {
	
	private Integer cost;
	private DirectedNodeExampleClass[] nodes;
	
	public UndirectedLinkExampleClass(Integer cost) {
		this.cost = cost;
		this.nodes = new DirectedNodeExampleClass[2];
	}
	
}
