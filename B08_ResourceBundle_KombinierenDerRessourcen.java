package loc;

import java.util.Locale;
import java.util.ResourceBundle;

public class B08_ResourceBundle_KombinierenDerRessourcen {

	public static void main(String[] args) {
		/*
		 * Hier wird die getBundle vereinfacht dargestellt.
		 * 
		 * ResourceBundle erhält den Basisnamen und generiert Kandidaten-Namen.
		 * 
		 * Finden Sie, für welches Locale die getBundle die Ressourcen sammelt:
		 *   
		 *   getBundle(String baseName) 
		 *   	- Sammelt die Resourcen fürs default-Locale
		 *   
		 *   getBundle(String baseName, Locale locale) 
		 *      - Sammelt die Resourcen fürs das spezielle Locale. 
		 *
		 * 
		 * Z.B. 
		 * 		baseName = "loc.res.app"
		 *      getBundle sammelt für default-Locale (de_DE)
		 *       
		 * Kandidatennamen generiert:
		 * 
		 * 		loc.res.app_de_DE.properties          <- Datei gibt es nicht in unserem Package
		 * 		loc.res.app_de.properties			  <- Datei gibt es
		 * 		loc.res.app.properties				  <- Datei gibt es
		 *
		 * Dateien (Ressourcen) im Bundle: 
		 *      loc.res.app_de.properties
		 *      loc.res.app.properties
		 *  
		 */
		Locale.setDefault(Locale.GERMANY); // de_DE
		
		String baseName = "loc.res.app";
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		/*
		 * getString sucht nur in den Ressourcen aus dem Bundle
		 * 
		 * getString sucht zuerst in den präziseren Ressourcen,
		 * dann (wenn nicht gefunden) in allgemeineren.
		 */
		String greeting = bundle.getString("greeting");
		System.out.println("greeting: " + greeting); // aus app_de.properties

		String day = bundle.getString("day");
		System.out.println("day: " + day); // aus app.properties
		
		try {
			bundle.getString("month");
		} catch (Exception e) {
			System.out.println("Fehler! Kein String month gefunden!");
		}
	}

}
