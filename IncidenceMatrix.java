import java.util.*;

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        int[][] incidenceMatrix = new int[numVertices][numEdges];

        System.out.println("Enter the edges (u v) and the number of times each edge appears:");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            incidenceMatrix[u][i]++;
            incidenceMatrix[v][i]++;
        }

        System.out.println("The incidence matrix is:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
