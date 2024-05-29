import java.util.*;

public class BipartiteGraph {
    private static boolean isBipartite(int src, List<List<Integer>> adjList, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        colors[src] = 1; // Color the source with 1

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.get(node)) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[node]; // Color with opposite color
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] colors = new int[numVertices];
        Arrays.fill(colors, -1); 

        boolean isBipartite = true;
        for (int i = 0; i < numVertices; i++) {
            if (colors[i] == -1) {
                if (!isBipartite(i, adjList, colors)) {
                    isBipartite = false;
                    break;
                }
            }
        }

        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
