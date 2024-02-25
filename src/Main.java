import graph.UnDirectedAdjacencyGraph;
import number.theory.NumberTheory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        graphDriverCode();

        System.out.println(NumberTheory.isPrimeNumber(3));
        System.out.println(NumberTheory.isPrimeNumber(6));
        System.out.println(NumberTheory.isPrimeNumber(9));
        System.out.println(NumberTheory.isPrimeNumber(17));
        System.out.println(NumberTheory.gcd(25,25));
        System.out.println(NumberTheory.lcm(17,19));
        System.out.println(NumberTheory.binaryExponentiation(2,20));
        NumberTheory.PrimeFactorization(17);
        NumberTheory.buildSieveOfPrimeNumbers(51, false);


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