package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	private final Map<N, Set<N>> map;
	
	//Needed to find a path between two nodes
	private final List<N> path;
	private final List<N> previousSourcesList;
	
	public GraphImpl() {
		this.map = new HashMap<>();
		this.path = new LinkedList<>();
		this.previousSourcesList = new LinkedList<>();
		
	}
	
	/**
     * @return all the graph
     */
	private Map<N, Set<N>> getMap() {
		return this.map;
	}
	
	/**
     * @return the list of connected nodes (path)
     */
	private List<N> getPath() {
		return this.path;
	}
	
	/**
     * @return the list of the previous source nodes
     */
	private List<N> getPreviousSourcesList() {
		return this.previousSourcesList;
	}

	/**
     * {@inheritDoc}
     */
	public void addNode(N node) {
		if(node != null && !this.map.containsKey(node)) {
			this.map.put(node, new HashSet<>());
		}
	}
	
	/**
     * {@inheritDoc}
     */
	public void addEdge(N source, N target) {
		if (source != null && target != null && 
				this.getMap().containsKey(source) && this.getMap().containsKey(target)) {
			
			this.getMap().get(source).add(target);
		}
	}
	
	/**
     * {@inheritDoc}
     */
	public Set<N> nodeSet() {
		return new HashSet<>(this.getMap().keySet());
	}
	
	/**
     * {@inheritDoc}
     */
	public Set<N> linkedNodes(N node) {
		return (this.getMap().containsKey(node) && node != null) ? new HashSet<>(this.getMap().get(node)) : null;
	}
	
	/**
     * {@inheritDoc}
     */
	public List<N> getPath(N source, N target) {
		//If this function is called again, it has to clear the previous path and the list of previous sources
		this.getPath().clear();
		this.getPreviousSourcesList().clear();
		
		return this.ricorsivePathFinder(source, target);
	}
	
	private List<N> ricorsivePathFinder(N source, N target) {
		
		if (source == target) {		
			this.getPath().add(source);
			return this.getPath();
		}
		
		for (N i : this.linkedNodes(source)) {
			if (!this.getPreviousSourcesList().contains(i)) {
				//If it visits a node, it won't be visited anymore
				this.getPreviousSourcesList().add(source);
				
				if (ricorsivePathFinder(i, target) != null) {
					if (!this.getPath().contains(source)) {
						//Add the source at the first position if it is not in the path
						this.getPath().add(0, source); 
					}
					return this.getPath();
				}
				
			}
		}
		
		//Path didn't find
		return null;
	}

}
