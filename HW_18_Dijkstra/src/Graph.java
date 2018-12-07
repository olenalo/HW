import java.util.ArrayList;
import java.util.List;

import static Configs.Configs.SOURCE_NODE_INDEX;

public class Graph {
    private List<Node> nodes = new ArrayList<>();
    private List<Edge> edges;
    private int nodesNumber;
    private int edgesNumber;
    private int visitedNodesNumber = 0;

    public Graph(List<Edge> edges) {
        this.edges = edges;
        this.edgesNumber = edges.size();
        this.nodesNumber = this.getNodesNumber();
        for (int i = 0; i < this.nodesNumber; i++) {
            this.nodes.add(new Node());
        }
        for (int i = 0; i < this.edgesNumber; i++) {
            this.nodes.get(this.edges.get(i).getFromNodeIndex()).addEdge(this.edges.get(i));
            this.nodes.get(this.edges.get(i).getToNodeIndex()).addEdge(this.edges.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();
        System.out.println("Number of nodes: " + nodesNumber);
        for (Edge edge : edges) {
            repr.append("It takes ")
                    .append(edge.getLength())
                    .append(" units from the node #")
                    .append(edge.getFromNodeIndex())
                    .append(" to the node #")
                    .append(edge.getToNodeIndex())
                    .append("\n");
        }
        return repr.toString();
    }

    private int getNodesNumber() {
        int nodesNumber = 0;
        for (Edge edge : edges) {
            if (edge.getFromNodeIndex() > nodesNumber) {
                nodesNumber = edge.getFromNodeIndex();
            }
            if (edge.getToNodeIndex() > nodesNumber) {
                nodesNumber = edge.getToNodeIndex();
            }
        }
        nodesNumber++;
        return nodesNumber;
    }

    public void calculateShortestPathsFromSourceByDijkstraAlgo() {
        // Ref.: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
        int nextNodeIndex = SOURCE_NODE_INDEX;
        nodes.get(nextNodeIndex).setDistanceFromSource(0); // distance to itself
        // for (Node node : nodes) { // TODO consider bringing back (no need for `visitedNodesNumber` field)
        while (this.hasUnvisitedNodes()) {
            Node nextNode = nodes.get(nextNodeIndex);
            System.out.println("Current node:: " + nextNode);
            ArrayList<Edge> edges = nextNode.getEdges();
            for (Edge edge : edges) {
                int neighborNodeIndex = edge.getNeighborNodeIndex(nextNodeIndex);
                Node neighborNode = nodes.get(neighborNodeIndex);
                if (!neighborNode.isVisited()) {
                    int cost = nextNode.getDistanceFromSource() + edge.getLength();
                    if (cost < neighborNode.getDistanceFromSource()) {
                        neighborNode.setDistanceFromSource(cost);
                        System.out.println("Updated neighbor node: " + neighborNode);
                    }
                }
            }
            nodes.get(nextNodeIndex).setVisited(true);
            visitedNodesNumber++;
            nextNodeIndex = getClosestAvailableNodeIndex();
            System.out.println("------------------");
        }
        // TODO
        /*
        for (int i = 1; i < nodes.size(); i++) {
            defineItinerary(i);
        }
        */
    }

    /**
     * Get an unvisited node closest to the source.
     *
     * @return index of the node.
     */
    private int getClosestAvailableNodeIndex() {
        int nodeIndex = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < nodesNumber; i++) {
            int currentDistance = nodes.get(i).getDistanceFromSource();
            if (!nodes.get(i).isVisited() && currentDistance < distance) {
                distance = currentDistance;
                nodeIndex = i;
            }
        }
        return nodeIndex;
    }

    private void populateItinerary(int nodeIndex, List<Integer> itinerary) {
        // FIXME
        while (nodeIndex != SOURCE_NODE_INDEX) {
            Node node = nodes.get(nodeIndex);
            int minDistance = Integer.MAX_VALUE;
            for (Edge edge : node.getEdges()) {
                int neighborNodeIndex = edge.getNeighborNodeIndex(nodeIndex);
                int distance = nodes.get(neighborNodeIndex).getDistanceFromSource();
                if (distance < minDistance) {
                    minDistance = distance;
                    nodeIndex = neighborNodeIndex;
                }
            }
            if (nodeIndex != SOURCE_NODE_INDEX) {
                itinerary.add(nodeIndex);
            }
        }
    }

    private void defineItinerary(int nodeIndex) {
        if (this.hasUnvisitedNodes()) {
            throw new IllegalStateException("A graph should first have weights.");
        }
        List<Integer> itinerary = new ArrayList<>();
        populateItinerary(nodeIndex, itinerary);
        Node currentNode = nodes.get(nodeIndex);
        for (int i : itinerary) {
            currentNode.addToPathFromSource(i);
        }
    }

    public StringBuilder getShortestPathFromSourceDescription() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < nodesNumber; i++) {
            output.append("\nThe shortest distance from the source node #0 to the node #")
                    .append(i)
                    .append(" is ")
                    .append(nodes.get(i).getDistanceFromSource())
                    .append(". The itinerary is: ")
                    .append(nodes.get(i).getPathFromSource()); // FIXME get the itinerary as well
        }
        return output;
    }

    public boolean hasUnvisitedNodes() {
        return visitedNodesNumber != nodesNumber;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public void setNodesNumber(int nodesNumber) {
        this.nodesNumber = nodesNumber;
    }

    public int getEdgesNumber() {
        return edgesNumber;
    }

    public void setEdgesNumber(int edgesNumber) {
        this.edgesNumber = edgesNumber;
    }
}
