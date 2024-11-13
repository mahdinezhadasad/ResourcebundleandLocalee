package loc;

import java.util.Locale;

public class B04_Locale {

	/*
	 * Locale-Objekt speichert Sprach- und Land-Einstellung
	 * 
	 *  https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html
	 */
	public static void main(String[] args) {

		/*
		 * Locale-Objekte
		 * 
		 */

		/*
		 * Mit Konstruktoren.
		 * 
		 * In Java 8 waren die Konstruktoren nicht deprecated
		 */
		Locale loc1 = new Locale("de");
		Locale loc2 = new Locale("de", "DE");
		System.out.println("loc2: " + loc2);

		/*
		 * Mit dem Locale.Builder
		 */
		Locale loc3 = new Locale.Builder()
			.setLanguage("de")
			.setRegion("DE")
			.build();
		System.out.println("loc3: " + loc3);
		
		/*
		 * Ab Java 19
		 * 
		 * Locale loc1 = Locale.of("de");
		 * Locale loc2 = Locale.of("de", "DE");
		 */
		
		/*
		 * Mit Konstanten
		 */
		Locale loc4 = Locale.GERMAN; // de 
		Locale loc5 = Locale.GERMANY; // de_DE
		System.out.println("loc5: " + loc5);
		
		/*
		 * ausgewählte Instanzmethoden
		 */
		System.out.println("loc5.getLanguage(): " + loc5.getLanguage()); // de
		System.out.println("loc5.getCountry(): " + loc5.getCountry()); // DE
		
		System.out.println("loc5.getDisplayLanguage(): " + 
				loc5.getDisplayLanguage()); // Deutsch (oder übersetzt) 
		System.out.println("loc5.getDisplayCountry(): " + 
				loc5.getDisplayCountry()); // Deutschland (oder übersetzt)
		
		/*
		 * ausgewählte statische Methoden
		 */
		System.out.println("*** getDefault()");
		Locale defLocale = Locale.getDefault();
		System.out.println("default-Locale: " + defLocale); // de_DE (auf dem Dozenten-PC)
		
		System.out.println("*** setDefault(Locale.ITALY)");
		defLocale = Locale.ITALY;
		Locale.setDefault(defLocale);
		
		System.out.println("Test: " + loc5.getDisplayLanguage()); // tedesco
		
		System.out.println("*** getAvailableLocales()");
		Locale[] allLocales = Locale.getAvailableLocales();
		System.out.println("available locales: " + allLocales.length);
	}
}
