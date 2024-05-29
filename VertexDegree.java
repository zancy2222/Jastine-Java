import java.util.*;

public class VertexDegree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        int[] degree = new int[numVertices];

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            degree[u]++;
            degree[v]++;
        }

        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + " has degree " + degree[i]);
        }
    }
}
