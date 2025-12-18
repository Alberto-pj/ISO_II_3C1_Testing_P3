package testing_p3.src.main.java.com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorRecomendacionesTest {

    private MotorRecomendaciones motor;

    @BeforeEach
    void setUp() {
        motor = new MotorRecomendaciones();
    }

    private static Persona personaOk() {
        return new Persona(25, true, false);
    }

    private static Persona personaNoOk() {
        return new Persona(26, false, true);
    }

    private static Meteo meteo(double t, double h, boolean llueve, boolean nieva, boolean nublado) {
        Meteo m = new Meteo();
        m.temperatura = t;
        m.humedad = h;
        m.llueve = llueve;
        m.nieva = nieva;
        m.nublado = nublado;
        return m;
    }

    @Test
    void reglaSalud_siNoPuedeRealizarActividades_devuelveNinguna() {
        Recomendacion r = motor.recomendar(
                personaNoOk(),
                meteo(31, 40, false, false, false),
                true, true, true, true
        );

        assertEquals(Recomendacion.NINGUNA, r);
    }

    @Test
    void playaOPiscina_siMayor30_sinLluvia_yAforoPiscina_devuelvePlayaOPiscina() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(31, 40, false, false, false),
                false, false, false, true
        );

        assertEquals(Recomendacion.PLAYA_O_PISCINA, r);
    }

    @Test
    void solape_siMayor30_sinLluvia_peroSinAforoPiscina_puedeCaerEnCulturalSiAforoGeneral() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(31, 40, false, false, false),
                false, false, true, false
        );

        // Playa falla por aforoPiscina=false, pero 31 entra en 25-35 y !llueve con aforoGeneral=true
        assertEquals(Recomendacion.ACTIVIDADES_CULTURALES_GASTR, r);
    }

    @Test
    void quedarseEnCasa_siTempNegativa_humedadBaja_yHayPrecipitacion() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(-1, 10, true, false, false),
                true, true, true, true
        );

        assertEquals(Recomendacion.QUEDARSE_EN_CASA, r);
    }

    @Test
    void esqui_siTempNegativa_humedadBaja_sinPrecipitacion_yAforoEsqui() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(-1, 10, false, false, false),
                true, false, false, false
        );

        assertEquals(Recomendacion.ESQUI, r);
    }

    @Test
    void esqui_siNoAforoEsqui_yNoCumpleOtrasReglas_devuelveNinguna() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(-1, 10, false, false, false),
                false, false, false, false
        );

        assertEquals(Recomendacion.NINGUNA, r);
    }

    @Test
    void senderismoEscalada_siEntre0y15_sinPrecipitacion_yAforoMontana() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(10, 40, false, false, false),
                false, true, false, false
        );

        assertEquals(Recomendacion.SENDERISMO_ESCALADA, r);
    }

    @Test
    void catalogoPVO_siEntre15y25_sinLluvia_noNublado_humedadMenorIgual60_yAforoGeneral() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(20, 60, false, false, false),
                false, false, true, false
        );

        assertEquals(Recomendacion.CATALOGO_P_V_O, r);
    }

    @Test
    void catalogoPVO_falla_siHumedadMayor60_yNoHayOtraRegla_devuelveNinguna() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(20, 61, false, false, false),
                false, false, true, false
        );

        // No entra en catálogo por humedad, y no entra en cultural (t=20)
        assertEquals(Recomendacion.NINGUNA, r);
    }

    @Test
    void culturalGastronomica_enFronteraTemp30_noEsPlayaPorqueNoEsMayor30() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(30, 40, false, false, false),
                false, false, true, true
        );

        // Playa pide temperatura > 30, con 30 exactos cae en 25-35 cultural si aforoGeneral=true
        assertEquals(Recomendacion.ACTIVIDADES_CULTURALES_GASTR, r);
    }

    @Test
    void default_siNoCumpleNingunaRegla_devuelveNinguna() {
        Recomendacion r = motor.recomendar(
                personaOk(),
                meteo(20, 40, false, false, true), // nublado=true rompe catálogo
                false, false, true, false
        );

        assertEquals(Recomendacion.NINGUNA, r);
    }
}