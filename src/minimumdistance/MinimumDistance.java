/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumdistance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Amon.Sabul
 */
public class MinimumDistance {

    private static List<Vertex> nodes;
    private static List<Edge> edges;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 6; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        MinimumDistance d = new MinimumDistance();
        d.addLane("Edge_0", 1, 4, 85);
        d.addLane("Edge_1", 4, 5, 217);
        d.addLane("Edge_2", 2, 3, 173);
        d.addLane("Edge_3", 6, 6, 186);
//        d.addLane("Edge_4", 2, 7, 103);
//        d.addLane("Edge_5", 3, 7, 183);
//        d.addLane("Edge_6", 5, 8, 250);
//        d.addLane("Edge_7", 8, 9, 84);
//        d.addLane("Edge_8", 7, 9, 167);
//        d.addLane("Edge_9", 4, 9, 502);
//        d.addLane("Edge_10", 9, 10, 40);
//        d.addLane("Edge_11", 1, 10, 600);
        System.out.println("Starting on edges");

        Graph graph = new Graph(nodes, edges);
        Algorithm dijkstra = new Algorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(5));
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
            int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }

}
