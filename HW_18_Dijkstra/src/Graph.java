import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges;
    private int nodesNumber;
    private int edgesNumber;
    private int visitedNodesNumber = 0;

    public Graph(ArrayList<Edge> edges) {
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
        nodes.get(0).setDistanceFromSource(0); // distance to itself
        int nextNodeIndex = 0;
        // for (Node node : nodes) {
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
            // TODO add path as well
            nodes.get(nextNodeIndex).setVisited(true);
            visitedNodesNumber++;
            nextNodeIndex = getClosestAvailableNodeIndex();
            System.out.println("------------------");
        }
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

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Edge> getEdges() {
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
