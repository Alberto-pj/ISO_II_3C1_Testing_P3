package testing_p3.src.main.java.com.example;

/* Al ser programa de testeo todo se instancia en el main y se llama al metodo recomendacion que es la funcionalidad principal del
 programa */

public class App {
	    public static void main(String[] args) {

	        // Crear persona
	        Persona persona = new Persona(000025, true, false);

	        // Crear datos meteorológicos
	        Meteo meteo = new Meteo();
	        meteo.temperatura = 12;
	        meteo.humedad = 40;
	        meteo.llueve = false;
	        meteo.nieva = false;
	        meteo.nublado = false;

	        // Restricciones de aforo (ejemplo)
	        boolean aforoEsquiPermitido = true;
	        boolean aforoMontañaPermitido = true;
	        boolean aforoGeneralPermitido = true;
	        boolean aforoPiscinaPermitido = true;

	        // Motor de reglas
	        MotorRecomendaciones motor = new MotorRecomendaciones();

	        // Obtener recomendación
	        Recomendacion r = motor.recomendar(
	                persona,
	                meteo,
	                aforoEsquiPermitido,
	                aforoMontañaPermitido,
	                aforoGeneralPermitido,
	                aforoPiscinaPermitido
	        );

	        // Prueba de toString de persona (opciones de depuracion)
	        System.out.println(persona.toString());
	        // Mostrar resultado
	        System.out.println("La recomendación es: " + r);
	        
	    }
	}
