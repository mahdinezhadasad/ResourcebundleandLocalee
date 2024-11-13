package loc;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class B05_Formatieren {

	/*
	 * Formatieren: ein Objekt in ein String verwandeln
	 * Parsen:      ein String in ein Objekt (vom anderen Typ) verwandeln 
	 */
	public static void main(String[] args) throws Exception {
		bspMitNumberFormat();
		bspMitDateTimeFormatter();
	}
	
	static void bspMitNumberFormat() throws Exception {
		System.out.println("*** NumberFormat");
		
		double value = 33.967;
		
		/*
		 * Formatierer mit dem default-Locale
		 */
		NumberFormat nf1 = NumberFormat.getCurrencyInstance();
		String s1 = nf1.format(value); // formatieren
		System.out.println("s1: " + s1); // 33,97 €
		
		Number n1 = nf1.parse(s1); // parsen
		System.out.println("n1: " + n1);
		
		/*
		 * Formatierer mit dem speziellen Locale
		 */
		NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.CANADA);
		String s2 = nf2.format(value);
		System.out.println("s2: " + s2); // $33.97

		Number n2 = nf2.parse(s2);
		System.out.println("n2: " + n2);
	}
	
	static void bspMitDateTimeFormatter() throws Exception {
		System.out.println("\n*** DateTimeFormatter");
		
		LocalDate date = LocalDate.now();
		System.out.println("date: " + date);
		
		
		String fmt = "|%20s|%20s|%20s|%9s| %n";
		System.out.printf(fmt, "sprache", "E", "EEEE", "EEEEE");
		

		Consumer<Locale> consumer = loc -> {
			DateTimeFormatter f1 = DateTimeFormatter.ofPattern("E", loc);
			DateTimeFormatter f2 = DateTimeFormatter.ofPattern("EEEE", loc);
			DateTimeFormatter f3 = DateTimeFormatter.ofPattern("EEEEE", loc);
			
			System.out.printf(fmt, loc.getDisplayLanguage(), 
					f1.format(date), f2.format(date), f3.format(date));
		};
		
		Locale[] allLocales = Locale.getAvailableLocales();
		
		Stream.of(allLocales)
			.map(Locale::getLanguage)
			.distinct()
			.sorted()
			.map(Locale::new)
			.forEach(consumer);
		
	}
	

}
