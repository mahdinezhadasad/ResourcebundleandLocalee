package loc;

import java.util.Locale;
import java.util.ResourceBundle;

public class B09_ResourceBundle_Quellen {

	/*
	 * Die Methode getBundle kann aus zwei Quellen die Ressourcen bekommen:
	 * 
	 * 		- Java-Klassen
	 * 		- .properties-Dateien
	 * 
	 * Exam: als Quelle werden in der Prüfung .java-Dateien 
	 *       und .properties-Datein als richtige Quellen gesehen.
	 *       In Wirklichkeit wird natürlich die .java-Datei 
	 *       kompiliert (die echte Quelle wird .class-Datei sein)
	 *       
	 *  Exam:
	 *       wenn eine Java-Klasse die Ressource für ResourceBundle sein soll,
	 *       muss die Klasse von ListResourceBundle erben
	 *       
	 *       wenn die Klasse von ListResourceBundle erbt, muss sie die Methode
	 *       		Object[][] getContents()
	 *       überschreiben
	 *  
	 */
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.GERMANY); // de_DE
		
		String baseName = "loc.res.MyStrings";
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);

		String topic = bundle.getString("topic"); // aus MyStrings_de_DE.java
		
		System.out.println("topic: " + topic);
		
	}

}
