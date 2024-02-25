package graph;

import java.util.*;

/*
Graph representation can be as Matrix or Adjacency list
Graph can be directed or un-directed
# Align below topics with gfg
1. BFS
2. DFS
3. Connected Components
4. Tree or not?
5. Bipartite
6. Cycle Detection
7. Topological Sort
 */
public class UnDirectedAdjacencyGraph {
    private final Map<String, Set<String>> adjacenyGraphMap = new HashMap<>();

    public void addEdge(String v1, String v2){
        if (!adjacenyGraphMap.containsKey(v1)){
            adjacenyGraphMap.put(v1, new HashSet<>());
        }
        if (!adjacenyGraphMap.containsKey(v2)){
            adjacenyGraphMap.put(v2, new HashSet<>());
        }
        adjacenyGraphMap.get(v1).add(v2);
        adjacenyGraphMap.get(v2).add(v1);
    }
    public void addEdge(Long v1, Long v2){
       addEdge(v1.toString(), v2.toString());
    }

    public void addEdge(Integer v1, Integer v2){
        addEdge(v1.toString(), v2.toString());
    }

    public void printWholeGraph(){
        System.out.print("Printing whole graph...");
        for (String parent: adjacenyGraphMap.keySet()){
            for (String child: adjacenyGraphMap.get(parent)){
                System.out.println( parent + " <- " + child);
            }
        }
    }

    // Breadth First Search algorithm - [ queue, visited set to not visit same vertex again]

    public void bfs(String source) {
        System.out.println("Printing bfs... from source " + source);
        Set<String> visited = new HashSet<>();
        LinkedList<String> queueList = new LinkedList<>();
        visited.add(source); // marking source node as visited
        queueList.add(source);

        while (!queueList.isEmpty()) {
            String vertex = queueList.poll();
            System.out.print(vertex + " - ");

            if (adjacenyGraphMap.containsKey(vertex)) {
                for (String child : adjacenyGraphMap.get(vertex)) {
                    if (visited.contains(child)) continue; // don't revisit
                    visited.add(child); // mark child as visited
                    queueList.add(child); // add child to queue
                }
            }

        }
        System.out.println(" ");
    }

    // Depth First Search algorithm - [ recursion, visited set to not visit same vertex again]
    public void dfs(String vertex){
        System.out.println("Printing dfs... from vertex " + vertex);
        Set<String> visited = new HashSet<>();
        dfsHelper(vertex, visited);
        System.out.println(" ");
    }

    public void dfsHelper(String vertex, Set<String> visited){
        if (visited.contains(vertex)) return;

        System.out.print(vertex + " - ");
        visited.add(vertex);

        if(adjacenyGraphMap.get(vertex) == null ||  adjacenyGraphMap.get(vertex).isEmpty()) return;
        for (String child: adjacenyGraphMap.get(vertex)){
            dfsHelper(child, visited);
        }

    }


}
