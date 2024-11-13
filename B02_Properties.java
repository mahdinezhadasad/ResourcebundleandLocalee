package loc;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Properties;

public class B02_Properties {

	/*
	 * - Properties sind Konfigurationen für ein Programm.
	 * 
	 * z.B. wenn ein Programm übers Netzwerk von einem Server Daten 
	 * holen soll, kann die Server-IP-Adresse eine Property sein.
	 * 
	 * - Klasse java.util.Properties: Klasse zum Speichern/Laden der 
	 *   Konfigurationen
	 *   
	 * - Datei 'name.properties': Datei mit Properties
	 * 
	 */
	public static void main(String[] args) {
		
		Properties props = new Properties();
		
		/*
		 *  Properties aus der Datei in das Properties-Objekt laden
		 */
		try (Reader in = new FileReader("Projekte/Localization/myapp.properties")) {
			props.load(in);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
		/*
		 * Statt die Server-IP hartkodiert zu haben, wird sie
		 * als Property 'server-ip' geladen
		 */
//		String serverIP = "192.168.1.1";
		String serverIP = props.getProperty("server-ip");
		System.out.println("server-ip: " + serverIP);
		
		System.out.println("my.path: " + props.getProperty("my.path"));
		System.out.println("my.multiline.prop: " + props.getProperty("my.multiline.prop"));
		System.out.println("x1: " + props.getProperty("x1"));
		System.out.println("x2: " + props.getProperty("x2"));
		System.out.println("x3: " + props.getProperty("x3"));
		

		/*
		 * Speichern geht auch 
		 */
		try(Writer out = new FileWriter("myapp-test.properties", Charset.forName("UTF-8"))) {
			props.setProperty("my.key", "my value");
			props.setProperty("my.path", "C:\\Dir\\File"); // es wird speziell gespeichert (s. die Datei)
			
			props.store(out, "my comment");
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

}