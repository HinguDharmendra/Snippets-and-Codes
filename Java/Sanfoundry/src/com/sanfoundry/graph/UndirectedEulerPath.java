package com.sanfoundry.graph;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UndirectedEulerPath
{
    private int[][] adjacencyMatrix;
    private int     numberOfNodes;

    public UndirectedEulerPath(int numberOfNodes, int[][] adjacencyMatrix)
    {
        this.numberOfNodes = numberOfNodes;
        this.adjacencyMatrix = new int[numberOfNodes + 1][numberOfNodes + 1];
        for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++)
        {
            for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++)
            {
                this.adjacencyMatrix[sourceVertex][destinationVertex] = adjacencyMatrix[sourceVertex][destinationVertex];
            }
        }
    }

    public int degree(int vertex)
    {
        int degree = 0;
        for (int destinationvertex = 1; destinationvertex <= numberOfNodes; destinationvertex++)
        {
            if (adjacencyMatrix[vertex][destinationvertex] == 1
                    || adjacencyMatrix[destinationvertex][vertex] == 1)
            {
                degree++;
            }
        }
        return degree;
    }

    public int countOddDegreeVertex()
    {
        int count = 0;
        for (int node = 1; node <= numberOfNodes; node++)
        {
            if ((degree(node) % 2) != 0)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String... arg)
    {
        int number_of_nodes;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_of_nodes; i++)
            {
                for (int j = 1; j <= number_of_nodes; j++)
                {
                    adjacency_matrix[i][j] = scanner.nextInt();
                }
            }
            // make the graph undirected
            for (int i = 1; i <= number_of_nodes; i++)
            {
                for (int j = 1; j <= number_of_nodes; j++)
                {
                    if (adjacency_matrix[i][j] == 1
                            && adjacency_matrix[j][i] == 0)
                    {
                        adjacency_matrix[j][i] = 1;
                    }
                }
            }
            DirectedEulerianCircuit path = new DirectedEulerianCircuit(number_of_nodes,
                    adjacency_matrix);
            int count = path.countOddDegreeVertex();
            if (count == 0)
            {
                System.out
                        .println("As the graph has no odd degree vertex, there is at least one Eulerian Circuit.");
            }
            else if (count == 2)
            {
                System.out
                        .println("As the graph as two vertices with odd degree, there is no Eulerian Circuit but at least one Eulerian Path.");
            }
            else
            {
                System.out
                        .println("As the graph has more than two vertices with odd degree, there is no Eulerian Circuit or Eulerian Path.");
            }
        }
        catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }
}
