import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que contiene la lógica de negocio para generar las recomendaciones 
 * de actividades basadas en las entradas de salud, clima y aforo.
 */
public class RecomendadorAventuras {

    /**
     * Genera la lista de recomendaciones aplicando todas las reglas del problema.
     * El uso de objetos (EstadoSalud, CondicionesClimaticas, Espacio) facilita el testing.
     * @param salud Objeto con el estado de salud del cliente.
     * @param clima Objeto con las condiciones meteorológicas actuales.
     * @param espacio Objeto con la información de aforo.
     * @return List<String> Lista de actividades recomendadas.
     */
    public List<String> recomendarActividades(EstadoSalud salud, CondicionesClimaticas clima, Espacio espacio) {
        
        List<String> recomendaciones = new ArrayList<>();

        // ------------------------------
        // REGLA 1: Salud (Condición de bloqueo)
        // Si el cliente no es apto por salud, se termina el proceso.
        if (!salud.esAptoParaActividad()) {
            recomendaciones.add("Ninguna actividad permitida por salud");
            return recomendaciones; 
        }

        // --- Variables Locales para Legibilidad ---
        double T = clima.getTemperatura();
        int H = clima.getHumedadRelativa();
        int P = clima.getTipoPrecipitacion();
        boolean hayAforo = espacio.hayAforoDisponible();
        
        boolean esLluviaONieve = P != ConstantesClima.PRECIPITACION_NINGUNA; // Nieve o Agua
        boolean esLluvia = P == ConstantesClima.PRECIPITACION_AGUA;

        // ------------------------------
        // REGLA 2: Invierno Extremo (Quedarse en casa)
        // Condiciones: T < 0 Y H < 15% Y con CUALQUIER tipo de precipitación.
        if (T < 0 && H < 15 && esLluviaONieve) {
            recomendaciones.add("Quedarse en casa");
            return recomendaciones; 
        }

        // ------------------------------
        // REGLA 3: Esquí
        // Condiciones: T < 0 Y H < 15% Y SIN precipitación (y con aforo).
        if (T < 0 && H < 15 && !esLluviaONieve) {
            if (hayAforo) {
                recomendaciones.add("Esquí");
            }
        }

        // ------------------------------
        // REGLA 4: Senderismo / Escalada
        // Condiciones: T en [0, 15] Y sin lluvia (solo lluvia, nieve sí permitiría) Y con aforo.
        if (T >= 0 && T <= 15 && !esLluvia) {
            if (hayAforo) {
                recomendaciones.add("Senderismo o Escalada");
            }
        }

        // ------------------------------
        // REGLA 5: Catálogo Primavera/Verano
        // Condiciones: T en [15, 25] Y NO llueve Y NO nublado Y H <= 60%.
        if (T >= 15 && T <= 25 && !esLluvia && !clima.isNublado() && H <= 60) {
            recomendaciones.add("Actividades catálogo primavera/verano/otoño");
        }

        // ------------------------------
        // REGLA 6: Cultural / Gastronómico
        // Condiciones: T en [25, 35] Y NO llueve Y con aforo.
        if (T >= 25 && T <= 35 && !esLluvia) {
             if (hayAforo) {
                recomendaciones.add("Actividades culturales o gastronómicas");
             }
        }

        // ------------------------------
        // REGLA 7: Playa / Piscina
        // Condiciones: T > 30 Y NO llueve Y con aforo (la piscina lo requiere).
        // NOTA: Esta regla se solapa con la R6 en el rango [30, 35]. Ambas se recomiendan.
        if (T > 30 && !esLluvia) {
            if (hayAforo) {
                recomendaciones.add("Playa o Piscina");
            }
        }

        // Si la lista está vacía, se devuelve un mensaje por defecto.
        if (recomendaciones.isEmpty()) {
            recomendaciones.add("Sin recomendaciones específicas para estas condiciones");
        }

        return recomendaciones;
    }
}