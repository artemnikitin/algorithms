package com.artemnikitin.algo.grokkingalgorithms.common;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {

    private final int size;
    private final List<Node>[] adjacencyList;

    public WeightedGraph(int numOfVertices) {
        size = numOfVertices;
        adjacencyList = (LinkedList<Node>[]) new LinkedList[numOfVertices];
        for (int i = 0; i < numOfVertices; ++i)
            adjacencyList[i] = new LinkedList<>();
    }

    public int size() {
        return size;
    }

    public void addEdge(int v, int vertice, int weight) {
        adjacencyList[v].add(new Node(v, vertice, weight));
    }

    public List<Node> findNeighbours(int src) {
        return adjacencyList[src];
    }

    public List<Node>[] getAdjacencyList() {
        return adjacencyList;
    }

    public class Node {
        public final int src;
        public final int dest;
        public final int weight;

        public Node(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

}
