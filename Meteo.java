public class Meteo {
	double temperatura;     // ºC
    double humedad;         // %
    boolean llueve;
    boolean nieva;
    boolean nublado;

    public boolean hayPrecipitacion() {
        return llueve || nieva;
    }

}