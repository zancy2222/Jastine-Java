import java.util.*;

public class AdjacencyMatrixToEdges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        int[][] adjMatrix = new int[numVertices][numVertices];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        Map<String, Integer> edgeCount = new HashMap<>();

        System.out.println("The edges of the graph are:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (adjMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCount.put(edge, adjMatrix[i][j]);
                    System.out.println(edge + " appears " + adjMatrix[i][j] + " times.");
                }
            }
        }
    }
}
