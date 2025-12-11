package testing_p3.src.main.java.com.example;
// Clase que realiza las recomendaciones finales de cara al cliente

public class MotorRecomendaciones {
	public Recomendacion recomendar(Persona persona, Meteo m,
            boolean aforoEsquiPermitido,
            boolean aforoMontañaPermitido,
            boolean aforoGeneralPermitido,
            boolean aforoPiscinaPermitido) {

		// 1. Regla de salud
		if (!persona.puedeRealizarActividades()) {
			return Recomendacion.NINGUNA;
		}

		// 2. Reglas meteorológicas
		// OJO con los solapes de rangos: decide la prioridad.
		// Ejemplo: si quieres que a partir de 30º se recomiende siempre
		// playa/piscina, comprueba eso antes que la regla 25–35.

		// Playa o piscina (> 30º, sin lluvia)
		if (m.temperatura > 30 && !m.llueve && aforoPiscinaPermitido) {
			return Recomendacion.PLAYA_O_PISCINA;
		}

		// Temperatura < 0, humedad < 15% y hay precipitación -> quedarse en casa
		if (m.temperatura < 0 && m.humedad < 15 && m.hayPrecipitacion()) {
			return Recomendacion.QUEDARSE_EN_CASA;
		}

		// Temperatura < 0, humedad < 15% y SIN precipitación -> esquí
		if (m.temperatura < 0 && m.humedad < 15 && !m.hayPrecipitacion() && aforoEsquiPermitido) {
			return Recomendacion.ESQUI;
		}

		// 0–15º, sin precipitaciones -> senderismo/escalada
		if (m.temperatura >= 0 && m.temperatura <= 15 && !m.hayPrecipitacion() && aforoMontañaPermitido) {
			return Recomendacion.SENDERISMO_ESCALADA;
		}

		// 15–25º, no llueve, no está nublado, humedad <= 60% -> cualquier actividad cat. P/V/O
		if (m.temperatura > 15 && m.temperatura <= 25 && !m.llueve && !m.nublado && m.humedad <= 60 &&
				aforoGeneralPermitido) {
			return Recomendacion.CATALOGO_P_V_O;
		}

		// 25–35º, no llueve -> actividades culturales o gastronómicas
		if (m.temperatura > 25 && m.temperatura <= 35 && !m.llueve && aforoGeneralPermitido) {
			return Recomendacion.ACTIVIDADES_CULTURALES_GASTR;
		}

		// Si no se cumple ninguna regla
		return Recomendacion.NINGUNA;
	}
	
}
