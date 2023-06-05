import java.util.*;

public class PrintAllPaths {
    // created a class for edges
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        int vertex = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<Edge>());
        }

        graph.get(0).add(new Edge(0, 1, 10));
        graph.get(0).add(new Edge(0, 2, 40));

        graph.get(1).add(new Edge(1, 0, 10));
        graph.get(1).add(new Edge(1, 2, 10));

        graph.get(2).add(new Edge(2, 1, 10));
        graph.get(2).add(new Edge(2, 3, 10));

        graph.get(3).add(new Edge(3, 0, 40));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(3).add(new Edge(3, 4, 2));

        graph.get(4).add(new Edge(4, 3, 2));
        graph.get(4).add(new Edge(4, 5, 3));
        graph.get(4).add(new Edge(4, 6, 8));

        graph.get(5).add(new Edge(5, 4, 3));
        graph.get(5).add(new Edge(5, 6, 3));

        graph.get(6).add(new Edge(6, 5, 3));
        graph.get(6).add(new Edge(6, 4, 8));

        Scanner scn = new Scanner(System.in);
        int src = scn.nextInt();
        int dest = scn.nextInt();
        printPaths(graph, vertex, src, dest);
    }

    public static void printPaths(ArrayList<ArrayList<Edge>> graph, int vertex, int src, int dest) {
        boolean[] visited = new boolean[vertex];
        printpossiblepaths(graph, visited, src, dest, src + "");
    }

    private static void printpossiblepaths(ArrayList<ArrayList<PrintAllPaths.Edge>> graph,
            boolean[] visited, int src, int dest, String psf) {
        // check if we are at dest
        if (src == dest) {
            System.out.println(psf);
            return;
        }

        // mark the node we visited
        visited[src] = true;
        for (Edge edge : graph.get(src)) {
            // for the src node visit all the unvisited node
            if (visited[edge.dest] == false) {

                printpossiblepaths(graph, visited, edge.dest, dest, psf + edge.dest);
            }
        }
        // once all the node for one node is visited mark the node unvisited
        visited[src] = false;
    }
}