package loc;

import java.util.Locale;
import java.util.ResourceBundle;

public class B06_ResourceBundle {

	/*
	 * Mit ResourceBundle wird eine Anwendung so programmiert,
	 * dass man die Anwendung einfacher lokalisieren kann.
	 */
	public static void main(String[] args) {
		
		/*
		 * Ohne ResourceBundle:
		 * 
		 *	String greeting = "Guten Tag!";
		 *  System.out.println(greeting); 
		 */

		/*
		 * Mit ResourceBundle:
		 * Vorteil: Lokalisieren ist einfach.
		 * 
		 * Die Datei 'app.properties' im Package 'loc.res' wurde erzeugt.
		 * Dort gibt es den String 'greeting'.
		 * Das ist die Lokalisierung für den Fall, dass keine speziellere
		 * Loaklisierung gefunden werden konnte.
		 * 
		 * Deutsche Lokalisierung:
		 * Die Datei 'app_de.properties' im Package 'loc.res' erzeugen
		 * Dort gibt es den String 'greeting' mit der deutschen Übersetzung.
		 * 
		 * Wenn die System-Sprache 'de' ist, passt sich die Anwendung automatisch
		 * an und zeigt den Text in Deutsch.
		 */
		String baseName = "loc.res.app";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		String greeting = bundle.getString("greeting");
		System.out.println(greeting);
	}

}
