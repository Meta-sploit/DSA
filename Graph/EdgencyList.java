import java.util.ArrayList;
import java.util.Scanner;

public class EdgencyList {
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
        // graph.get(3).add(new Edge(3, 4, 2));

        // graph.get(4).add(new Edge(4, 3, 2));
        graph.get(4).add(new Edge(4, 5, 3));
        graph.get(4).add(new Edge(4, 6, 8));

        graph.get(5).add(new Edge(5, 4, 3));
        graph.get(5).add(new Edge(5, 6, 3));

        graph.get(6).add(new Edge(6, 5, 3));
        graph.get(6).add(new Edge(6, 4, 8));

        // System.out.println(graph.get(3).get(0).src);

        Scanner scn = new Scanner(System.in);
        int src = scn.nextInt();
        int dest = scn.nextInt();
        System.out.println(HashPath(vertex, graph, src, dest));

    }

    public static boolean HashPath(int vertex, ArrayList<ArrayList<Edge>> graph, int src, int dest) {
        boolean[] visited = new boolean[vertex];
        return isThereAnyPath(visited, vertex, graph, src, dest);
    }

    public static boolean isThereAnyPath(boolean[] visited, int vertex, ArrayList<ArrayList<Edge>> graph, int src,
            int dest) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;
        for (Edge edges : graph.get(src)) {
            System.out.println("checking path from " + src + " " + edges.dest);
            if (visited[edges.dest] == false) {
                boolean hashNbrPath = isThereAnyPath(visited, vertex, graph, edges.dest, dest);
                if (hashNbrPath) {
                    return true;
                }
            }

        }
        return false;
    }
}