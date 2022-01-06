package ctci.chapter4.questions;

import ctci.chapter4.AdjacencyGraph;
import ctci.chapter4.AdjacencyGraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 4.1 Route Between Nodes: Given a directed graph and two nodes, design an algorithm to find out whether there is a
 * route from one to the other.
 */
public class RouteBetweenNodes {

    /**
     * Determines whether there is a route between nodes through simply BFS.
     *
     * @param s
     * @param e
     * @return true if there is a route, false otherwise. Does NOT return the route.
     */
    public boolean routeBetween(AdjacencyGraph graph, AdjacencyGraphNode s, AdjacencyGraphNode e) {
        // Keep track of the nodes we have seen before in order to avoid endless cycles.
        HashSet<AdjacencyGraphNode> visited = new HashSet<>();
        // Keep the children to visit in a queue for BFS implementation.
        Queue<AdjacencyGraphNode> childrenToVisit = new LinkedList<>();

        // Check to make sure the first node is actually in the graph, otherwise we will get a null pointer later.
        if (graph.getChildren(s) == null) {
            return false;
        }

        childrenToVisit.add(s);
        while (!childrenToVisit.isEmpty()) {
            AdjacencyGraphNode curr = childrenToVisit.poll();

            // We've found the magical path.
            if (curr.equals(e)) {
                return true;
            }

            // Add the children to be visited, ensuring not to add already visited children.
            visited.add(curr);
            for (AdjacencyGraphNode child: graph.getChildren(curr)) {
                if (!visited.contains(child)) {
                    childrenToVisit.add(child);
                }
            }
        }

        return false;
    }
}
