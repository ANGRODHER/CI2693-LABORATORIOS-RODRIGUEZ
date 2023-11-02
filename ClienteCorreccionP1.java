import java.util.ArrayList;
import java.util.List;

public class ClienteCorreccionP1 {
    public static void main(String[] args) {
        // Crear un objeto de la clase AdjacencyListGraph
        AdjacencyListGraph graph = new AdjacencyListGraph();

        vertex A = new vertex("A");
        vertex B = new vertex("B");
        vertex C = new vertex("C");
        vertex D = new vertex("D");

        graph.add(A);
        graph.add(B);
        graph.add(C);
        graph.add(D);

        // Conectar vértices en el grafo
        graph.connect(A, B);
        graph.connect(B, C);
        graph.connect(C, D);
        graph.connect(D, A);
        // graph.connect(A, C);

        // Obtener la lista de vértices conectados a un vértice dado
        List<vertex> connectedVertices = graph.getVerticesConnectedTo(A);
        System.out.println("Vértices conectados a A: " + connectedVertices);

        // Obtener la lista de vértices sucesores de un vértice dado
        List<vertex> outwardEdges = graph.getOutwardEdges(A);
        System.out.println("Vértices sucesores de B: " + outwardEdges);

        // Obtener la lista de vértices predecesores de un vértice dado
        List<vertex> inwardEdges = graph.getInwardEdges(A);
        System.out.println("Vértices predecesores de C: " + inwardEdges);

        // Obtener todos los vértices del grafo
        List<vertex> allVertices = graph.getAllVertices();
        System.out.println("Todos los vértices del grafo: " + allVertices);

        // Obtener el tamaño del grafo
        int size = graph.size();
        System.out.println("Tamaño del grafo: " + size);

        // Crear un subgrafo a partir de un conjunto de vértices
        List<vertex> subgraphVertices = new ArrayList<>();
        subgraphVertices.add(A);
        subgraphVertices.add(B);
        subgraphVertices.add(C);
        Graph<vertex> subgraph = graph.subgraph(subgraphVertices);
        subgraph.connect(A, B);
        subgraph.connect(B, C);
        System.out.println("Subgrafo: " + subgraph.getAllVertices());
        // Obtener la lista de vértices conectados a un vértice da
        List<vertex> connectedVerticesSubgraph = subgraph.getVerticesConnectedTo(A);
        System.out.println("Subgrafo conexion: " + connectedVerticesSubgraph);
        // Obtener la lista de vértices sucesores de un vértice dado
        List<vertex> outwardEdgesSubgraph = subgraph.getOutwardEdges(A);
        System.out.println("Vértices sucesores de sub (A): " + outwardEdgesSubgraph);

        // Eliminar un vértice del grafo
        boolean removed = graph.remove(C);
        System.out.println("Vértice C eliminado: " + removed);

        // Verificar si un vértice existe en el grafo
        boolean contains = graph.contains(C);
        System.out.println("El grafo contiene el vértice D: " + contains);

    }
}