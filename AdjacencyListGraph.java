import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AdjacencyListGraph implements Graph<vertex> {
    // Declaramos las variables, arreglos y tablas que vayamos a utilizar
    private HashMap<String, vertex> vertices;
    private ArrayList<edges> connect;
    public static final int inf = Integer.MAX_VALUE;

    public AdjacencyListGraph() {
        // Constructor de la clase.
        vertices = new HashMap<>();
        connect = new ArrayList<>();
    }

    // Método para agregar un vértice al grafo
    public boolean add(vertex vertex) {
        if (!vertices.containsKey(vertex.getId())) {
            // Agregar el vértice al hashtable
            vertices.put(vertex.getId(), vertex);
            // Vértice agregado exitosamente
            return true;
        }
        // El vértice ya existe en el grafo
        return false;
    }

    // Método para verificar si un vértice existe en el grafo dado su identificador
    public boolean contains(vertex vertex) {
        if (vertices.containsKey(vertex.getId())) {
            // El vértice existe en el grafo
            return true;
        }
        // El vértice no existe en el grafo
        return false;
    }

    // Método para verificar si existe un lado entre dos vértices
    public boolean containsconnect(vertex from, vertex to) {
        // Iterar sobre todos los lados
        for (edges a : connect) {
            // Verificar si los vértices extremos coinciden en cualquier dirección
            if (a.getExtremoInicial().equals(from) && a.getExtremoFinal().equals(to)
                    || a.getExtremoInicial().equals(to) && a.getExtremoFinal().equals(from)) {
                // Existe un lado entre los vértices
                return true;
            }
        }
        // No existe un lado entre los vértices
        return false;
    }

    public boolean connect(vertex from, vertex to) {
        // Esta función establece la relación entre dos vértices si existe una conexión
        // entre ellos.

        if (contains(from) && contains(to) && !containsconnect(from, to)) {
            // creamos dos instancia para hace un arco
            edges arco1 = new edges("" + from.getId() + to.getId() + "", "0", from, to);
            connect.add(arco1);
            edges arco2 = new edges("" + to.getId() + from.getId() + "", "0", to, from);
            connect.add(arco2);
            return true;
        }
        return false;
    }

    public boolean disconnect(vertex from, vertex to) {
        // Esta función elimina la relación entre dos vértices si existe una conexión
        // entre ellos.
        if (contains(from) && contains(to) && containsconnect(from, to)) {
            for (edges a : connect) {
                if (a.getExtremoInicial().equals(from) && a.getExtremoFinal().equals(to)
                        || a.getExtremoInicial().equals(to) && a.getExtremoFinal().equals(from)) {
                    connect.remove(a);
                    return true;
                }
            }
        }
        return false;
    }

    public List<vertex> getInwardEdges(vertex to) {
        // Esta función devuelve una lista de vértices predecesores que tienen una
        // conexión con el vértice dado.
        List<vertex> inwardEdges = new ArrayList<>();
        for (edges a : connect) {
            if (a.getExtremoFinal().equals(to)) {
                inwardEdges.add(a.getExtremoInicial());
            }
        }
        return inwardEdges;
    }

    public List<vertex> getOutwardEdges(vertex from) {
        // Esta función devuelve una lista de vértices sucesores que tienen una conexión
        // con el vértice dado.
        List<vertex> outwardEdges = new ArrayList<>();
        for (edges a : connect) {
            if (a.getExtremoInicial().equals(from)) {
                outwardEdges.add(a.getExtremoFinal());
            }
        }
        return outwardEdges;
    }

    public List<vertex> getVerticesConnectedTo(vertex vertex) {
        // Esta función devuelve una lista de vértices que tienen una conexión con el
        // vértice dado.
        List<vertex> verticesConnectedTo = new ArrayList<>();
        for (edges a : connect) {
            if (a.getExtremoInicial().equals(vertex)) {
                verticesConnectedTo.add(a.getExtremoFinal());
            } else if (a.getExtremoFinal().equals(vertex)) {
                verticesConnectedTo.add(a.getExtremoInicial());
            }
        }
        return verticesConnectedTo;
    }

    public List<vertex> getAllVertices() {
        // Esta función devuelve una lista de todos los vértices del grafo.
        List<vertex> allVertices = new ArrayList<>();
        for (String key : vertices.keySet()) {
            allVertices.add(vertices.get(key));
        }
        return allVertices;
    }

    public boolean remove(vertex vertex) {
        // Esta función elimina un vértice del grafo.
        if (contains(vertex)) {
            vertices.remove(vertex.getId());
            return true;
        }
        return false;
    }

    public int size() {
        // Esta función devuelve el número de vértices en el grafo.
        return vertices.size();
    }

    public Graph<vertex> subgraph(Collection<vertex> vertices) {
        // Esta función devuelve un subgrafo del grafo dado un conjunto de vértices.
        Graph<vertex> subgraph = new AdjacencyListGraph();
        for (vertex v : vertices) {
            subgraph.add(v);
        }
        for (edges a : connect) {
            if (subgraph.contains(a.getExtremoInicial()) && subgraph.contains(a.getExtremoFinal())) {
                subgraph.connect(a.getExtremoInicial(), a.getExtremoFinal());
            }
        }
        return subgraph;
    }

}
