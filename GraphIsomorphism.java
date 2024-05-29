import java.util.*;

public class GraphIsomorphism {
    private static String canonicalForm(List<List<Integer>> adjList) {
        List<String> adjacencyStrings = new ArrayList<>();
        for (List<Integer> neighbors : adjList) {
            Collections.sort(neighbors);
            adjacencyStrings.add(neighbors.toString());
        }
        Collections.sort(adjacencyStrings);
        return adjacencyStrings.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices for graph 1:");
        int numVertices1 = scanner.nextInt();

        System.out.println("Enter the number of edges for graph 1:");
        int numEdges1 = scanner.nextInt();

        List<List<Integer>> adjList1 = new ArrayList<>();
        for (int i = 0; i < numVertices1; i++) {
            adjList1.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v) for graph 1:");
        for (int i = 0; i < numEdges1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList1.get(u).add(v);
            adjList1.get(v).add(u);
        }

        System.out.println("Enter the number of vertices for graph 2:");
        int numVertices2 = scanner.nextInt();

        System.out.println("Enter the number of edges for graph 2:");
        int numEdges2 = scanner.nextInt();

        List<List<Integer>> adjList2 = new ArrayList<>();
        for (int i = 0; i < numVertices2; i++) {
            adjList2.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v) for graph 2:");
        for (int i = 0; i < numEdges2; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList2.get(u).add(v);
            adjList2.get(v).add(u);
        }

        String graph1CanonicalForm = canonicalForm(adjList1);
        String graph2CanonicalForm = canonicalForm(adjList2);

        if (graph1CanonicalForm.equals(graph2CanonicalForm)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }
}
