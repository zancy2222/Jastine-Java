import java.util.*;

public class GraphConnectivity {
    private static void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    private static int countConnectedComponents(List<List<Integer>> adjList, int numVertices) {
        boolean[] visited = new boolean[numVertices];
        int components = 0;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adjList, visited);
            }
        }
        return components;
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

        int components = countConnectedComponents(adjList, numVertices);
        if (components == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected. It has " + components + " connected components.");
        }
    }
}
