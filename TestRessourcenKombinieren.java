package loc;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestRessourcenKombinieren {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	/*
	 * verwendetes Locale = spezielles Locale = de_DE
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res. und Suffix .properties):
	 * 
	 * 		days_de_DE    - Datei existiert nicht
	 * 		days_de  	  - Datei existiert nicht
	 * 		days
	 */
	static void test4() {
		System.out.println("\n*** Test 4");
		Locale.setDefault(Locale.ITALY); // it_IT
		
		String baseName = "loc.res.days";
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.GERMANY);
		
		String first = bundle.getString("first"); // aus days.properties
		System.out.println("first: " + first);
	}
	
	/*
	 * verwendetes Locale = default-Locale = fr
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res. und Suffix .properties):
	 * 
	 * 		days_fr    
	 * 		days
	 */
	static void test3() {
		System.out.println("\n*** Test 3");
		Locale.setDefault(Locale.FRENCH); // fr
		
		String baseName = "loc.res.days";
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		String first = bundle.getString("first"); // aus days_fr.properties
		System.out.println("first: " + first);
	}
	
	/*
	 * verwendetes Locale = default-Locale = fr_FR
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res. und Suffix .properties):
	 * 
	 * 		days_fr_FR 
	 * 		days_fr    
	 * 		days
	 */
	static void test2() {
		System.out.println("\n*** Test 2");
		Locale.setDefault(Locale.FRANCE); // fr_FR
		
		String baseName = "loc.res.days";
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		String first = bundle.getString("first"); // aus days_fr_FR.properties
		System.out.println("first: " + first);
		
		String second = bundle.getString("second"); // aus days_fr.properties
		System.out.println("second: " + second);
	}
	
	/*
	 * verwendetes Locale = default-Locale = de_DE
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res. und Suffix .properties):
	 * 
	 * 		days_de_DE - existiert nicht
	 * 		days_de    - existiert nicht
	 * 		days
	 */
	static void test1() {
		System.out.println("*** Test 1");
		Locale.setDefault(Locale.GERMANY);
		
		String baseName = "loc.res.days";

		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		String first = bundle.getString("first"); // aus days.properties
		System.out.println("first: " + first);
	}

}
