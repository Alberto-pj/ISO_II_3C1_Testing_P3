package testing_p3.src.main.java.com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void puedeRealizarActividades_true_siPlenasFacultades_ySinSintomas() {
        Persona p = new Persona(1, true, false);
        assertTrue(p.puedeRealizarActividades());
    }

    @Test
    void puedeRealizarActividades_false_siNoTienePlenasFacultades() {
        Persona p = new Persona(2, false, false);
        assertFalse(p.puedeRealizarActividades());
    }

    @Test
    void puedeRealizarActividades_false_siTuvoSintomas() {
        Persona p = new Persona(3, true, true);
        assertFalse(p.puedeRealizarActividades());
    }
}