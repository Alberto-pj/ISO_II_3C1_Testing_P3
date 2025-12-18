package testing_p3.src.main.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
class AppTest {

    @Test
    void main_noLanzaExcepcion() {
        assertDoesNotThrow(() -> App.main(new String[0]));
    }
}