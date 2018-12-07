public class Edge {

    private int fromNodeIndex;
    private int toNodeIndex;
    private int length;

    public Edge(int fromNodeIndex, int toNodeIndex, int length) {
        this.fromNodeIndex = fromNodeIndex;
        this.toNodeIndex = toNodeIndex;
        this.length = length;
    }

    public int getNeighborNodeIndex(int nodeIndex) { // toggle
        if (this.fromNodeIndex == nodeIndex) {
            return this.toNodeIndex;
        } else {
            return this.fromNodeIndex;
        }
    }

    public int getFromNodeIndex() {
        return fromNodeIndex;
    }

    public void setFromNodeIndex(int fromNodeIndex) {
        this.fromNodeIndex = fromNodeIndex;
    }

    public int getToNodeIndex() {
        return toNodeIndex;
    }

    public void setToNodeIndex(int toNodeIndex) {
        this.toNodeIndex = toNodeIndex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "fromNodeIndex=" + fromNodeIndex +
                ", toNodeIndex=" + toNodeIndex +
                ", length=" + length +
                '}';
    }
}
