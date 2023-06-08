import java.util.*;

public class BFS {
    // created a class for edges
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
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
        int n = scn.nextInt();
        boolean[] visited = new boolean[vertex];
        printBFS(graph, n, visited);
    }

    static class Pair {
        int start;
        String psf;

        public Pair(int start, String psf) {
            this.start = start;
            this.psf = psf;
        }
    }

    public static void printBFS(ArrayList<ArrayList<Edge>> graph, int start, boolean[] visited) {
        Deque<Pair> q = new LinkedList();
        Pair pair = new Pair(start, start + "");
        q.add(pair);

        while (q.size() != 0) {
            Pair p1 = q.poll();

            if (visited[p1.start] == true) {
                continue;
            }
            visited[p1.start] = true;

            System.out.println(p1.start + " " + p1.psf);
            for (Edge edge : graph.get(p1.start)) {
                if (visited[edge.nbr] == false) {
                    q.add(new Pair(edge.nbr, p1.psf + edge.nbr));
                }

            }

        }

    }
}
