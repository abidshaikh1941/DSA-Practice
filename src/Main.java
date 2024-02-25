import graph.DirectedAdjacencyGraph;
import graph.UnDirectedAdjacencyGraph;

public class Main {
    public static void main(String[] args) {
        graphDriverCode();
    }

    private static void graphDriverCode() {
        System.out.println("Hello world!");
        UnDirectedAdjacencyGraph directedAdjacentGraph = new UnDirectedAdjacencyGraph();
        directedAdjacentGraph.addEdge(0, 1);
        directedAdjacentGraph.addEdge(0, 2);
        directedAdjacentGraph.addEdge(1, 2);
        directedAdjacentGraph.addEdge(2, 0);
        directedAdjacentGraph.addEdge(2, 3);
        directedAdjacentGraph.addEdge(3, 3);

        directedAdjacentGraph.printWholeGraph();
        directedAdjacentGraph.dfs("0");
        directedAdjacentGraph.bfs("2");
    }
}