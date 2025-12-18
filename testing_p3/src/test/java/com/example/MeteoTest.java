package testing_p3.src.main.java.com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeteoTest {

    @Test
    void hayPrecipitacion_false_siNoLlueveNiNieva() {
        Meteo m = new Meteo();
        m.llueve = false;
        m.nieva = false;

        assertFalse(m.hayPrecipitacion());
    }

    @Test
    void hayPrecipitacion_true_siLlueve() {
        Meteo m = new Meteo();
        m.llueve = true;
        m.nieva = false;

        assertTrue(m.hayPrecipitacion());
    }

    @Test
    void hayPrecipitacion_true_siNieva() {
        Meteo m = new Meteo();
        m.llueve = false;
        m.nieva = true;

        assertTrue(m.hayPrecipitacion());
    }

    @Test
    void hayPrecipitacion_true_siLlueveYNieva() {
        Meteo m = new Meteo();
        m.llueve = true;
        m.nieva = true;

        assertTrue(m.hayPrecipitacion());
    }
}