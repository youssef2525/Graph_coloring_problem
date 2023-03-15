package com.mycompany.grap_coloring_problem;
import java.util.HashMap;
import java.util.HashSet;

public class GraphColoringPy {

    private final HashMap<Integer, Integer> nodeColors = new HashMap<>();
    private final HashSet<Integer> visitedNodes = new HashSet<>();
    private final int[][] graph;
    private final int[] colors;
    
    public GraphColoringPy(int[][] graph, int[] colors) {
        this.graph = graph;
        this.colors = colors;
    }
    
    public HashMap<Integer, Integer> colorNodes() {
        int startNode = findStartNode();
        assignColor(startNode);
        return nodeColors;
    }
    
    private boolean assignColor(int node) {
        // Check if all nodes have been assigned a color
        if (visitedNodes.size() == graph.length) {
            return true;
        }
        
        // Check if the current node has already been assigned a color
        if (nodeColors.containsKey(node)) {
            return assignColor(findNextNode(node));
        }
        
        // Try to assign a color to the current node
        for (int color : colors) {
            boolean valid = true;
            for (int neighbor : graph[node]) {
                if (nodeColors.containsKey(neighbor) && nodeColors.get(neighbor) == color) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                nodeColors.put(node, color);
                visitedNodes.add(node);
                if (assignColor(findNextNode(node))) {
                    return true;
                }
                nodeColors.remove(node);
                visitedNodes.remove(node);
            }
        }
        
        return false;
    }
    
    private int findNextNode(int node) {
        for (int n : graph[node]) {
            if (!nodeColors.containsKey(n) && !visitedNodes.contains(n)) {
                return n;
            }
        }
        for (int n : graph[node]) {
            if (!nodeColors.containsKey(n)) {
                return n;
            }
        }
        return -1;
    }
    
    private int findStartNode() {
        int startNode = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length > 0 && i < startNode) {
                startNode = i;
            }
        }
        return startNode;
    }
}

