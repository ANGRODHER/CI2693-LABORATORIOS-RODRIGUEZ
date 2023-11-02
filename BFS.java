import java.util.*;

public class BFS {
    public static int getGradoSeparacion(Map<String, List<String>> grafo, String personaOrigen, String personaDestino) {
        Queue<String> cola = new LinkedList<>();
        Map<String, Integer> gradosSeparacion = new HashMap<>();

        cola.offer(personaOrigen);
        gradosSeparacion.put(personaOrigen, 0);

        while (!cola.isEmpty()) {
            String personaActual = cola.poll();

            if (personaActual.equals(personaDestino)) {
                return gradosSeparacion.get(personaActual);
            }

            List<String> personasRelacionadas = grafo.get(personaActual);
            if (personasRelacionadas != null) {
                for (String personaRelacionada : personasRelacionadas) {
                    if (!gradosSeparacion.containsKey(personaRelacionada)) {
                        cola.offer(personaRelacionada);
                        gradosSeparacion.put(personaRelacionada, gradosSeparacion.get(personaActual) + 1);
                    }
                }
            }
        }

        return -1; // Si no se encuentra una conexión entre las dos personas
    }

}