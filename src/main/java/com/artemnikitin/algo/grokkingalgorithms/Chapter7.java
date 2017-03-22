package com.artemnikitin.algo.grokkingalgorithms;

import com.artemnikitin.algo.grokkingalgorithms.common.WeightedGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chapter7 {

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(4);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 2);
        graph.addEdge(2, 1, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);

        djikstra(graph, 0, 3);
        djikstra(graph, 0, 1);
    }

    public static void djikstra(WeightedGraph graph, int startVertice, int endVertice) {
        int[] markParent = new int[graph.size()];
        int[] markDist = new int[graph.size()];
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        for (int i = 1; i < graph.size(); i++) {
            map.put(i, Integer.MAX_VALUE);
        }

        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> min = null;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (min == null || min.getValue() > entry.getValue()) min = entry;
            }

            int src = min.getKey();
            int dest = min.getValue();
            markDist[src] = dest;
            List<WeightedGraph.Node> neighbours = graph.findNeighbours(src);

            for (WeightedGraph.Node node : neighbours) {
                int temp = src == node.src ? node.dest : node.src;
                if (map.containsKey(temp) && map.get(temp) > node.weight + markDist[src]) {
                    map.put(temp, node.weight + markDist[src]);
                    markParent[temp] = src;
                }
            }
            map.remove(src);
        }

        System.out.println(markDist[endVertice]);
    }


}
