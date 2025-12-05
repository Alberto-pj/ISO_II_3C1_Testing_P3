/**
 * Clase que representa el estado de salud de un cliente potencial
 * de actividades, encapsulando las dos condiciones relevantes del problema.
 */

public class EstadoSalud {
    
    // Indica si el cliente está en plenas facultades físicas.
    private boolean facultadesFisicas; 
    // Indica si el cliente ha tenido síntomas de enfermedades infecciosas en las dos últimas semanas.
    private boolean sintomasInfeccionRecientes; 
    
    /**
     * Constructor para inicializar el estado de salud del cliente.
     * @param facultadesFisicas True si está en plenas facultades.
     * @param sintomasInfeccionRecientes True si ha tenido síntomas.
     */
    public EstadoSalud(boolean facultadesFisicas, boolean sintomasInfeccionRecientes) {
        this.facultadesFisicas = facultadesFisicas;
        this.sintomasInfeccionRecientes = sintomasInfeccionRecientes;
    }

    /**
     * Valida la primera y más crítica regla del enunciado: 
     * El cliente es apto solo si tiene facultades físicas Y NO ha tenido síntomas.
     * * @return boolean True si el cliente es apto para cualquier actividad.
     */
    public boolean esAptoParaActividad() {
        // Lógica: facultadesFisicas debe ser True, y sintomasInfeccionRecientes debe ser False.
        return facultadesFisicas && !sintomasInfeccionRecientes;
    }

    /**
     * Getter para obtener el estado de las facultades físicas. 
     */
    public boolean tieneFacultadesFisicas() {
        return facultadesFisicas;
    }

    /**
     * Getter para obtener si hay síntomas recientes.
     */
    public boolean tieneSintomas() {
        return sintomasInfeccionRecientes;
    }
}