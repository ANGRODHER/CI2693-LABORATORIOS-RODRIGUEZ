import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;

public class DegreesOfSeparation {
    public static void main(String[] args) {

        // Crear un objeto de la clase AdjacencyListGraph
        AdjacencyListGraph graph = new AdjacencyListGraph();
        String name1, name2;
        name1 = args[0];
        name2 = args[1];
        String name3 = "input.txt";

        // Esta función cargará los datos de un .txt solicitados de babel.java
        try (BufferedReader lista = new BufferedReader(new FileReader(name3))) {
            System.out.println("entra en el try");
            // Se leer la primera linea verificamos que no esté vacía y que sea un entero
            // entre 1 y 2000
            String linea = lista.readLine();
            System.out.println("primera linea " + linea);
            while (linea != null && !linea.isEmpty()) {

                // linea = lista.readLine();
                if (linea.isEmpty()) {
                    // se lanza la excepción un mensaje a usuario
                    throw new IOException("No hay relación entre dos nombres ");
                } else {
                    // creamos el Array de String nombres para almacenar la siguiente linea que
                    // representan el vertice de orige y el de llegada
                    String[] names = linea.split(" ");
                    String start = names[0];
                    String end = names[1];
                    // agregamos a Vertice y a la hashTable
                    vertex A = new vertex(start);
                    vertex B = new vertex(end);
                    graph.add(A);
                    graph.add(B);
                    graph.connect(A, B);

                    // Llamamos al algoritmos de BFS para calcular el camino más corto entre 2
                    // idiomas
                    // BFS bfs = new BFS(name1, name2);

                }
                linea = lista.readLine();
                System.out.println(linea + " linea 2 ");

            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error en los datos de entrada: " + e.getMessage());
            System.out.println("imposible");

        }
        vertex t = new vertex(name1);
        System.out.println("T : " + t);

        // Obtener la lista de vértices conectados a un vértice dado
        List<vertex> connectedVertices = graph.getVerticesConnectedTo(t);
        System.out.println("Vértices conectados: " + connectedVertices);

        // Obtener la lista de vértices sucesores de un vértice dado
        List<vertex> outwardEdges = graph.getOutwardEdges(t);
        System.out.println("Vértices sucesores: " + outwardEdges);

        // Obtener la lista de vértices predecesores de un vértice dado
        List<vertex> inwardEdges = graph.getInwardEdges(t);
        System.out.println("Vértices predecesores: " + inwardEdges);

        // Obtener todos los vértices del grafo
        List<vertex> allVertices = graph.getAllVertices();
        System.out.println("Todos los vertices del grafo: " + allVertices);

        // Obtener el tamaño del grafo
        int size = graph.size();
        System.out.println("Tamaño del grafo: " + size);
        System.out.println(" ");

        // Verificar si un vértice existe en el grafo
        boolean contains = graph.contains(t);
        System.out.println("El grafo contiene el vértice : " + contains);

    }
}