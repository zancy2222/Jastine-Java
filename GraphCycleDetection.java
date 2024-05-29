import java.util.*;

public class GraphCycleDetection {
    private static boolean dfs(int node, int parent, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adjList, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(List<List<Integer>> adjList, int numVertices) {
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adjList, visited)) {
                    return true;
                }
            }
        }
        return false;
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

        if (hasCycle(adjList, numVertices)) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }
    }
}
