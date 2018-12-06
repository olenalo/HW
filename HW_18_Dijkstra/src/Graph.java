import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges;
    private int nodesNumber;
    private int edgesNumber;

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
        for (Edge edge: this.edges) {
            repr
                .append("It takes ")
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
        for (Edge edge: this.edges) {
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

    public void calculateShortestPathsToSourceByDijkstraAlgo() {
        // Ref.: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
        this.nodes.get(0).setDistanceToSource(0); // distance to itself
        int nextNodeIndex = 0;
        for (int i = 0; i < this.nodesNumber; i++) {
            ArrayList<Edge> edges = this.nodes.get(nextNodeIndex).getEdges();
            for (Edge edge : edges) {
                int neighborNodeIndex = edge.getNeighborNodeIndex(nextNodeIndex);
                if (!this.nodes.get(neighborNodeIndex).isVisited()) {
                    int cost = this.nodes.get(nextNodeIndex).getDistanceToSource() + edge.getLength();
                    if (cost < nodes.get(neighborNodeIndex).getDistanceToSource()) {
                        this.nodes.get(neighborNodeIndex).setDistanceToSource(cost);
                    }
                }
            }
            // TODO add path as well
            this.nodes.get(nextNodeIndex).setVisited(true);
            nextNodeIndex = getClosestAvailableNodeIndex();
        }
    }

    /**
     * Get an unvisited node closest to the last visited node.
     *
     * @return index of the node.
     */
    private int getClosestAvailableNodeIndex() {
        int nodeIndex = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < this.nodesNumber; i++) {
            int currentDistance = this.nodes.get(i).getDistanceToSource();
            if (!this.nodes.get(i).isVisited() && currentDistance < distance) {
                distance = currentDistance;
                nodeIndex = i;
            }
        }
        return nodeIndex;
    }

    public StringBuilder getShortestPathsToSourceDescription() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.nodesNumber; i++) {
            output.append("\nThe shortest distance from the source node #0 to the node #")
                    .append(i)
                    .append(" is ")
                    .append(nodes.get(i).getDistanceToSource())
                    .append(". The itinerary is: ")
                    .append(nodes.get(i).getPathToSource()); // FIXME get the itinerary as well
        }
        return output;
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
