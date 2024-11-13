package loc;

import java.util.Locale;
import java.util.ResourceBundle;

public class B07_ResourceBundle_API {

	public static void main(String[] args) {
	
		
		
		String baseName = "loc.res.app";
		
		

		/*
		 * static final ResourceBundle getBundle(String baseName)
		 * 
		 * Sammelt die Resourcen fürs default-Locale
		 */
		ResourceBundle bundle1 = ResourceBundle.getBundle(baseName);

		/*
		 * 
		 * static final ResourceBundle getBundle(String baseName,
         *                                       Locale locale)
         *
         * Sammelt die Resourcen fürs das spezielle Locale.
         * 
         * Exam: wenn diese Methode verwendet wird, 
         *       kann man default-Locale ignorieren 
         *       (in der Praxis ist es komplizierter)
		 */
		Locale loc = Locale.ITALY;
		ResourceBundle bundle2 = ResourceBundle.getBundle(baseName, loc);
		
		/*
		 * 
		 * String getString(String key)
		 * 
		 */
		String s1 = bundle1.getString("greeting");
		String s2 = bundle2.getString("greeting");
		
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		
		/*
		 * Object getObject(String key)
		 */
		Object s10 = bundle1.getObject("greeting");
		Object s20 = bundle2.getObject("greeting");
		
		System.out.println("s10: " + s10);
		System.out.println("s20: " + s20);
		
		/*
		 * Exam:
		 */
//		String s33 = bundle1.getObject("greeting"); // cf: String <- IST-KEIN <- Object  
//		Object s44 = bundle1.getObject(22); // cf: braucht String als Argument
	}

}