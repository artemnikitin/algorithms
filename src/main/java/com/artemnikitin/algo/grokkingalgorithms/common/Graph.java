package com.artemnikitin.algo.grokkingalgorithms.common;

import java.util.LinkedList;

public class Graph {

    private final int size;
    private final LinkedList<Integer>[] adjacencyList;

    public Graph(int numOfVertices) {
        size = numOfVertices;
        adjacencyList = (LinkedList<Integer>[]) new LinkedList[numOfVertices];
        for (int i = 0; i < numOfVertices; ++i)
            adjacencyList[i] = new LinkedList<>();
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    public int size() {
        return size;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

}
