package loc;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TestStringsSuchen {
	private static final String baseName = "loc.res.labels";

	public static void main(String[] args) {
		suche("nichtda");
		suche("cancel");
		suche("help");
		suche("greeting");
		suche("edit");
	}

	/*
	 * Locale: de_DE
	 * 
	 * Kandidaten:
	 * 
	 * 		loc.res.labels_de_DE       .class oder .properties
	 * 				
	 * 				loc.res.labels_de_DE.class gibt es nicht, aber  
	 * 				loc.res.labels_de_DE.properties gibt es (gehört zum Bundle)
	 * 
	 * 		loc.res.labels_de          .class oder .properties
	 * 				loc.res.labels_de.class gibt es (gehört zum Bundle)
	 * 				und
	 * 				loc.res.labels_de.properties gibt es auch, 
	 *              aber sie wird NICHT zu dem Bundle gehören
	 * 
	 * 		loc.res.labels             .class oder .properties
	 * 				loc.res.labels.class gibt es (gehört zum Bundle)
	 * 				loc.res.labels.properties gibt es nicht
	 */
	static void suche(String property) {
		System.out.println("\n***");
		
		Locale.setDefault(Locale.GERMANY); // damit auf einem anderen Rechenr die Ergebnisse gleich sind
		Locale locale = Locale.getDefault();
		System.out.println("Locale: " + locale);
		
		System.out.println("Name: " + property);
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
		
		try {
			String result = bundle.getString(property);
			System.out.println("Value: " + result);
		} catch (MissingResourceException e) {
			System.out.println("ERROR! " + e.getMessage());
		}
	}
	
}
