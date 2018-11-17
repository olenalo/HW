import java.util.ArrayList;

public class Node {

    private boolean visited;
    private int distanceToSource;
    private ArrayList<Integer> pathToSource;
    private ArrayList<Edge> edges;

    public Node() {
        this.visited = false;
        this.distanceToSource = Integer.MAX_VALUE;
        this.edges = new ArrayList<>();
        this.pathToSource = new ArrayList<>();
        pathToSource.add(0);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistanceToSource() {
        return distanceToSource;
    }

    public void setDistanceToSource(int distanceToSource) {
        this.distanceToSource = distanceToSource;
    }

    public ArrayList<Integer> getPathToSource() {
        return pathToSource;
    }

    public void setPathToSource(ArrayList<Integer> pathToSource) {
        this.pathToSource = pathToSource;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
}
