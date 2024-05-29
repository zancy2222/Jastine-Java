import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        int[][] adjMatrix = new int[numVertices][numVertices];

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjMatrix[u][v]++;
        }

        System.out.println("The adjacency matrix is:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
