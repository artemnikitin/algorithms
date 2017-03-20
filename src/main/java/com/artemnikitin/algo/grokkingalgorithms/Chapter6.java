package com.artemnikitin.algo.grokkingalgorithms;

import com.artemnikitin.algo.grokkingalgorithms.common.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Chapter6 {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        breadthFirstSearch(g, 2);
        System.out.println();
        depthFirstSearch(g, 2);
    }

    public static void breadthFirstSearch(Graph graph, int startVertice) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertice);
        visited[startVertice] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            LinkedList<Integer> list = graph.getAdjacencyList()[node];
            for (int i : list) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void depthFirstSearch(Graph graph, int startVertice) {
        dfsRecursive(graph, startVertice, new boolean[graph.size()]);
    }

    private static void dfsRecursive(Graph graph, int vertice, boolean[] visited) {
        visited[vertice] = true;
        System.out.print(vertice + " ");

        LinkedList<Integer> list = graph.getAdjacencyList()[vertice];
        for (int i : list) {
            if (!visited[i]) dfsRecursive(graph, i, visited);
        }
    }

}
