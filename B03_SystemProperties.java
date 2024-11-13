package loc;

import java.util.Properties;

public class B03_SystemProperties {

	public static void main(String[] args) {

		/*
		 * Alle System-Properties erhalten:
		 */
		Properties props = System.getProperties();
		printProps(props);

		/*
		 * Eine spezielle Property lesen:
		 */
		String key = "java.io.tmpdir";
		String value = System.getProperty(key);
		
		System.out.println(key + " = " + value);
		
		/*
		 * Eigene Property speichern:
		 */
		key = "my.prop";
		value = "my.value";
		System.setProperty(key, value);
		
		/*
		 * Eine Property lesen, falls es sie nicht gibt wird defaultValue
		 * zurück geliefert
		 */
		
		String myDay = System.getProperty("my.day", "Freitag");
		
		/*
		 * Der User kann beim Start der Anwendung zusätzliche
		 * Einträge für die System-Properties erstellen:
		 *
		 *   	java -Dkey=value MyApp
		 *
		 *  z.B.
		 *
		 *   	java -Dserver-ip=192.168.1.12 MyApp
		 *
		 *  Zum Testen unter Eclipse kann die Option -Dserver-ip=192.168.1.12
		 *  im Menu Run->Run Configurations im Tab 'Arguments' unter 'VM arguments'
		 *  festgelegt werden.
		 */
		
		String serverIP = System.getProperty("server-ip", "192.168.0.1");
		System.out.println("server ip: " + serverIP);
	}
	
	static void printProps(Properties props) {
		
		for (Object key : props.keySet()) {
			Object value = props.get(key);
			System.out.printf("%30s = %s %n", key, value);
		}
	}

}