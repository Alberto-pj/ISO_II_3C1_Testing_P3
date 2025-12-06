/**
 * Clase que modela las características de un lugar o actividad, 
 * enfocándose principalmente en la gestión de aforo (capacidad).
 */
public class Espacio {
    
    // Número actual de personas o reservas en el espacio.
    private int aforoActual; 
    // Capacidad máxima permitida por normativa o diseño.
    private int aforoMaximo; 

    /**
     * Constructor para inicializar las condiciones de aforo.
     * @param aforoActual El número de personas que ya están en el espacio.
     * @param aforoMaximo La capacidad total permitida.
     */
    public Espacio(int aforoActual, int aforoMaximo) {
        this.aforoActual = aforoActual;
        this.aforoMaximo = aforoMaximo;
    }

    /**
     * Comprueba si aún queda espacio para una persona o grupo,
     * determinando si se puede realizar una actividad que requiera aforo limitado 
     * (ej: esquí, piscina, actividades culturales).
     * * @return boolean True si el aforo actual NO ha superado el máximo.
     */
    public boolean hayAforoDisponible() {
        // Lógica: El aforo actual debe ser estrictamente menor que el máximo.
        return aforoActual < aforoMaximo;
    }

    /**
     * Getter para conocer el valor del aforo actual.
     */
    public int getAforoActual() {
        return aforoActual;
    }

    /**
     * Getter para conocer el valor del aforo máximo.
     */
    public int getAforoMaximo() {
        return aforoMaximo;
    }

    /**
     * Setter para actualizar el aforo actual, si fuese necesario.
     * @param aforoActual El nuevo valor del aforo actual.
     */
    public void setAforoActual(int aforoActual) {
        this.aforoActual = aforoActual;
    }

    /**
     * Setter para actualizar el aforo máximo, si fuese necesario.
     * @param aforoMaximo El nuevo valor del aforo máximo.
     */
    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }
}