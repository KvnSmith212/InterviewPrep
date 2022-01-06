package ctci.chapter4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Quick and dirty graph implementation using an adjacency list, for use within questions presented by the book.
 */
public class AdjacencyGraph {

    /**
     * Hashmap allows constant lookup between of nodes in the graph.
     * Hashset allows constant lookup between a node and its children.
     */
    private Map<Node, HashSet<Node>> adjacencyMap;

    public AdjacencyGraph() {
        adjacencyMap = new HashMap<>();
    }

    /**
     * Add an edge between nodes into the graph. If the node is not already in the graph, adds the node as well.
     * Equality, and as such existence within the graph, relies on the standard java equals implementation.
     * @param a
     * @param b
     * @param biDirectional indicates whether the edge is one way, or bidirectional.
     */
    public void add(Node a, Node b, boolean biDirectional) {
        addDirectionalEdge(a, b);

        if (biDirectional) {
            addDirectionalEdge(b, a);
        }
    }

    // Add a single direction edge between two nodes.
    private void addDirectionalEdge(Node a, Node b) {
        HashSet<Node> children = adjacencyMap.get(a) == null ? new HashSet<>() : adjacencyMap.get(a);
        children.add(b);
        adjacencyMap.put(a, children);
    }

    /**
     * Returns the hashset of children accompanied by a node, or null if the node is not within the graph.
     * @param node
     * @return
     */
    public HashSet<Node> getChildren(Node node) {
        return adjacencyMap.get(node);
    }

    /**
     * Wouldn't normally expose this but doing so here for the sake of testing and equals method.
     * @return
     */
    public Map<Node, HashSet<Node>> getAdjacencyMap() {
        return adjacencyMap;
    }

    /**
     * Quick and dirty equals solution so that I can unit test, absolutely not optimal here.
     * @param o
     * @return true if equals, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof AdjacencyGraph)) {
            return false;
        }

        AdjacencyGraph other = (AdjacencyGraph) o;

        // Node currently isn't set to house any data, so equality be reference is good enough for now.
        return adjacencyMap.equals(other.getAdjacencyMap());
    }
}
