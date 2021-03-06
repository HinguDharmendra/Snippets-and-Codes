import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.Scanner;

public class Represent_Graph_Incidence_List 
{
    private Map<Integer, List<Integer>> incidenceList;
    private int v;

    public Represent_Graph_Incidence_List(int vertices) 
    {
        v = vertices;
        incidenceList = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= v; i++)
            incidenceList.put(i, new LinkedList<Integer>());
    }

    public void setEdge(int to, int from, int edge_number) 
    {
        List<Integer> slist = incidenceList.get(to);
        slist.add(edge_number);
        List<Integer> dlist = incidenceList.get(from);
        dlist.add(edge_number);

    }

    public List<Integer> getEdge(int vertex) 
    {
        return incidenceList.get(vertex);
    }

    public static void main(String args[]) 
    {
        int v, e, count = 1, to, from, edgeNumber;
        Scanner sc = new Scanner(System.in);
        Represent_Graph_Incidence_List glist;
        try 
        {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();

            glist = new Represent_Graph_Incidence_List(v);

            System.out
                    .println("Enter the edges in the graph : <edgenumber> <to> <from>");
            while (count <= e) 
            {
                edgeNumber = sc.nextInt();
                to = sc.nextInt();
                from = sc.nextInt();

                glist.setEdge(to, from, edgeNumber);
                count++;
            }

            System.out
                    .println("THe Incidence List Representation of the graph is: ");

            System.out.println("Vertex   EdgeNumber");
            for (int vertex = 1; vertex <= v; vertex++) 
            {
                System.out.print(vertex + "\t:");
                List<Integer> edgeList = glist.getEdge(vertex);
                for (int j = 1;; j++) 
                {
                    if (j != edgeList.size())
                        System.out.print(edgeList.get(j - 1) + "\t");
                    else 
                    {
                        System.out.print(edgeList.get(j - 1));
                        break;
                    }
                }
                System.out.println();
            }
        } 
        catch (Exception E) 
        {
            System.out.println("Something went wrong");
        }
        sc.close();
    }
}
