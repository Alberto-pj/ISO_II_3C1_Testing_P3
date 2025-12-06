/**
 * Clase que almacena las condiciones meteorológicas necesarias para la toma 
 * de decisiones sobre las actividades (temperatura, humedad, precipitación y nubosidad).
 * Utilizamos las constantes enteras definidas en ConstantesClima.java para la precipitación.
 */
public class CondicionesClimaticas {
    
    private double temperatura;      // Temperatura ambiente en grados Celsius.
    private int humedadRelativa;     // Humedad relativa en porcentaje (0-100).
    private int tipoPrecipitacion;   // ID de la precipitación (0=NINGUNA, 1=AGUA, 2=NIEVE).
    private boolean nublado;         // True si el cielo está nublado.

    /**
     * Constructor para establecer todas las condiciones meteorológicas observadas.
     */
    public CondicionesClimaticas(double temperatura, int humedadRelativa, int tipoPrecipitacion, boolean nublado) {
        this.temperatura = temperatura;
        this.humedadRelativa = humedadRelativa;
        this.tipoPrecipitacion = tipoPrecipitacion;
        this.nublado = nublado;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getHumedadRelativa() {
        return humedadRelativa;
    }

    /**
     * Devuelve el tipo de precipitación usando el ID definido en ConstantesClima.
     */
    public int getTipoPrecipitacion() {
        return tipoPrecipitacion;
    }

    public boolean isNublado() {
        return nublado;
    }

    // NOTA: Se evita el uso de setters, ya que las condiciones climáticas son 
    // de un momento dado y no deben modificarse después de la creación 
    // para una recomendación específica.
}