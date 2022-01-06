package ctci.chapter4.questions;

import ctci.chapter4.AdjacencyGraph;
import ctci.chapter4.Node;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RouteBetweenNodesTest {

    @Test
    void routeBetween_true() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        AdjacencyGraph testGraph = new AdjacencyGraph();

        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();

        testGraph.add(a, b, true);
        testGraph.add(a, c, true);
        testGraph.add(c, d, true);

        assertTrue(routeBetweenNodes.routeBetween(testGraph, a, d));
    }

    @Test
    void routeBetween_false_disconnectedGraph() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        AdjacencyGraph testGraph = new AdjacencyGraph();

        Node a = new Node();
        Node b = new Node();
        Node c_1 = new Node();
        Node c_2 = new Node();
        Node d = new Node();

        testGraph.add(a, b, true);
        testGraph.add(a, c_1, true);
        testGraph.add(c_2, d, true);

        assertFalse(routeBetweenNodes.routeBetween(testGraph, a, d));
    }

    @Test
    void routeBetween_false_missingFirstNode() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        AdjacencyGraph testGraph = new AdjacencyGraph();

        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();

        testGraph.add(b, c, true);
        testGraph.add(c, d, true);

        assertFalse(routeBetweenNodes.routeBetween(testGraph, a, d));
    }

    @Test
    void routeBetween_false_missingSecondNode() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        AdjacencyGraph testGraph = new AdjacencyGraph();

        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();

        testGraph.add(a, b, true);
        testGraph.add(a, c, true);

        assertFalse(routeBetweenNodes.routeBetween(testGraph, a, d));
    }
}