package ctci.chapter4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AdjacencyGraphTest {

    @Test
    void add_noSubgraph() {
        AdjacencyGraph testGraph = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        // Setup the expected graph using adjacency map directly.
        Map<AdjacencyGraphNode, HashSet<AdjacencyGraphNode>> expectedMap = new HashMap<>();
        expectedMap.put(a, Stream.of(b, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(b, Stream.of(a, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(c, Stream.of(b, a, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(d, Stream.of(b, c, a).collect(Collectors.toCollection(HashSet::new)));

        // Setup the test graph using method under test.
        testGraph.add(a, b, true);
        testGraph.add(a, c, true);
        testGraph.add(a, d, true);

        testGraph.add(b, c, true);
        testGraph.add(b, d, true);

        testGraph.add(c, d, true);

        // Assert equals directly on the adjacency maps.
        assertEquals(expectedMap, testGraph.getAdjacencyMap());
    }

    @Test
    void add_withSubgraphs() {
        AdjacencyGraph testGraph = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        // Setup the expected graph using adjacency map directly.
        Map<AdjacencyGraphNode, HashSet<AdjacencyGraphNode>> expectedMap = new HashMap<>();
        expectedMap.put(a, Stream.of(b).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(b, Stream.of(a).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(c, Stream.of(d).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(d, Stream.of(c).collect(Collectors.toCollection(HashSet::new)));

        // Setup the test graph using method under test.
        testGraph.add(a, b, true);
        testGraph.add(c, d, true);

        // Assert equals directly on the adjacency maps.
        assertEquals(expectedMap, testGraph.getAdjacencyMap());
    }

    @Test
    void add_duplicateAdds() {
        AdjacencyGraph testGraph = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();

        // Setup the expected graph using adjacency map directly.
        Map<AdjacencyGraphNode, HashSet<AdjacencyGraphNode>> expectedMap = new HashMap<>();
        expectedMap.put(a, Stream.of(b).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(b, Stream.of(a).collect(Collectors.toCollection(HashSet::new)));

        // Setup the test graph using method under test.
        testGraph.add(a, b, true);
        testGraph.add(a, b, true);
        testGraph.add(a, b, true);
        testGraph.add(a, b, true);

        // Assert equals directly on the adjacency maps.
        assertEquals(expectedMap, testGraph.getAdjacencyMap());
    }

    @Test
    void getChildren() {
        AdjacencyGraph graph = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        // Setup the expected graph using adjacency map directly.
        Map<AdjacencyGraphNode, HashSet<AdjacencyGraphNode>> expectedMap = graph.getAdjacencyMap();
        expectedMap.put(a, Stream.of(b, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(b, Stream.of(a, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(c, Stream.of(b, a, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMap.put(d, Stream.of(b, c, a).collect(Collectors.toCollection(HashSet::new)));

        // Assert equals directly on the adjacency maps.
        assertEquals(expectedMap.get(a), graph.getChildren(a));
        assertEquals(expectedMap.get(b), graph.getChildren(b));
        assertEquals(expectedMap.get(c), graph.getChildren(c));
        assertEquals(expectedMap.get(d), graph.getChildren(d));
    }

    @Test
    void testEquals() {
        AdjacencyGraph graphOne = new AdjacencyGraph();
        AdjacencyGraph graphTwo = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        // Setup the test graph one.
        Map<AdjacencyGraphNode, HashSet<AdjacencyGraphNode>> expectedMapOne = graphOne.getAdjacencyMap();
        expectedMapOne.put(a, Stream.of(b, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapOne.put(b, Stream.of(a, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapOne.put(c, Stream.of(b, a, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapOne.put(d, Stream.of(b, c, a).collect(Collectors.toCollection(HashSet::new)));

        // Setup the test graph two.
        Map<AdjacencyGraphNode, HashSet<AdjacencyGraphNode>> expectedMapTwo = graphTwo.getAdjacencyMap();
        expectedMapTwo.put(a, Stream.of(b, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapTwo.put(b, Stream.of(a, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapTwo.put(c, Stream.of(b, a, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapTwo.put(d, Stream.of(b, c, a).collect(Collectors.toCollection(HashSet::new)));

        assertEquals(graphOne, graphTwo);
    }

    @Test
    void testEquals_false() {
        AdjacencyGraph graphOne = new AdjacencyGraph();
        AdjacencyGraph graphTwo = new AdjacencyGraph();

        AdjacencyGraphNode a = new AdjacencyGraphNode();
        AdjacencyGraphNode b = new AdjacencyGraphNode();
        AdjacencyGraphNode c = new AdjacencyGraphNode();
        AdjacencyGraphNode d = new AdjacencyGraphNode();

        // Setup the test graph one.
        Map<AdjacencyGraphNode, HashSet<AdjacencyGraphNode>> expectedMapOne = graphOne.getAdjacencyMap();
        expectedMapOne.put(a, Stream.of(b, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapOne.put(b, Stream.of(a, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapOne.put(c, Stream.of(b, a, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapOne.put(d, Stream.of(b, c, a).collect(Collectors.toCollection(HashSet::new)));

        // Setup the test graph two.
        Map<AdjacencyGraphNode, HashSet<AdjacencyGraphNode>> expectedMapTwo = graphTwo.getAdjacencyMap();
        expectedMapTwo.put(a, Stream.of(b, c, d).collect(Collectors.toCollection(HashSet::new)));
        expectedMapTwo.put(b, Stream.of(a, c, d).collect(Collectors.toCollection(HashSet::new)));

        assertNotEquals(graphOne, graphTwo);
    }
}