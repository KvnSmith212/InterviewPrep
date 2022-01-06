package ctci.chapter4.questions;

import ctci.chapter4.AdjacencyGraph;
import ctci.chapter4.AdjacencyGraphNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteBetweenNodesTest {

    @Test
    void routeBetween_true() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        AdjacencyGraph testGraph = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        testGraph.add(a, b, true);
        testGraph.add(a, c, true);
        testGraph.add(c, d, true);

        assertTrue(routeBetweenNodes.routeBetween(testGraph, a, d));
    }

    @Test
    void routeBetween_false_disconnectedGraph() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        AdjacencyGraph testGraph = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c_1 = new AdjacencyGraphNode();
        AdjacencyGraphNode c_2 = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        testGraph.add(a, b, true);
        testGraph.add(a, c_1, true);
        testGraph.add(c_2, d, true);

        assertFalse(routeBetweenNodes.routeBetween(testGraph, a, d));
    }

    @Test
    void routeBetween_false_missingFirstNode() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        AdjacencyGraph testGraph = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        testGraph.add(b, c, true);
        testGraph.add(c, d, true);

        assertFalse(routeBetweenNodes.routeBetween(testGraph, a, d));
    }

    @Test
    void routeBetween_false_missingSecondNode() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        AdjacencyGraph testGraph = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        testGraph.add(a, b, true);
        testGraph.add(a, c, true);

        assertFalse(routeBetweenNodes.routeBetween(testGraph, a, d));
    }
}