package loc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Praktik {
    
    public static void main(String[] args) {
        Praktik printLocales = new Praktik();
        
        // Get all available locales
        Locale[] locales = Locale.getAvailableLocales();
        
        // Sort locales by display country, and by display language if countries are the same, in descending order
        Arrays.sort(locales, Comparator.comparing((Locale locale) -> locale.getDisplayCountry())
                .thenComparing(locale -> locale.getDisplayLanguage())
                .reversed());
        
        // Test the printTable method with the sorted locales
        printLocales.printTable(locales);
    }
    
    public void printTable(Locale[] locales) {
        // Determine the maximum width for each column dynamically
        int nrWidth = String.valueOf(locales.length).length();
        int countryWidth = Arrays.stream(locales).mapToInt(locale -> locale.getDisplayCountry().length()).max().orElse(10);
        int languageWidth = Arrays.stream(locales).mapToInt(locale -> locale.getDisplayLanguage().length()).max().orElse(10);
        int countryCodeWidth = 10;
        int languageCodeWidth = 10;
        int variantWidth = Arrays.stream(locales).mapToInt(locale -> locale.getDisplayVariant().length()).max().orElse(10);
        int isoCountryCodeWidth = Arrays.stream(locales).mapToInt(locale -> safeGetISO3Country(locale).length()).max().orElse(10);
        int isoLanguageCodeWidth = Arrays.stream(locales).mapToInt(locale -> safeGetISO3Language(locale).length()).max().orElse(10);
        int scriptWidth = Arrays.stream(locales).mapToInt(locale -> locale.getScript().length()).max().orElse(10);
        int displayNameWidth = Arrays.stream(locales).mapToInt(locale -> locale.getDisplayName().length()).max().orElse(15);
        
        // Format string with dynamically calculated widths
        String fmt = "| %" + nrWidth + "s | %-" + countryWidth + "s | %-" + languageWidth + "s | %-" + countryCodeWidth + "s | %-" + languageCodeWidth + "s | %-" + variantWidth + "s | %-" + isoCountryCodeWidth + "s | %-" + isoLanguageCodeWidth + "s | %-" + scriptWidth + "s | %-" + displayNameWidth + "s |%n";
        
        // Print the table header
        System.out.printf(fmt, "Nr.", "Land", "Sprache", "Ländercode", "Sprachcode", "Variante", "ISO3-Land", "ISO3-Sprache", "Script", "Display Name");
        System.out.println("-".repeat(nrWidth + countryWidth + languageWidth + countryCodeWidth + languageCodeWidth + variantWidth + isoCountryCodeWidth + isoLanguageCodeWidth + scriptWidth + displayNameWidth + 24));
        
        // Print each locale in the formatted table
        for (int i = 0; i < locales.length; i++) {
            String country = locales[i].getDisplayCountry();
            String language = locales[i].getDisplayLanguage();
            String countryCode = locales[i].getCountry();
            String languageCode = locales[i].getLanguage();
            String variant = locales[i].getDisplayVariant();
            String isoCountryCode = safeGetISO3Country(locales[i]);
            String isoLanguageCode = safeGetISO3Language(locales[i]);
            String script = locales[i].getScript();
            String displayName = locales[i].getDisplayName();
            
            System.out.printf(fmt, i + 1, country, language, countryCode, languageCode, variant, isoCountryCode, isoLanguageCode, script, displayName);
        }
    }
    
    // Helper method to safely get ISO3 country code, defaulting to an empty string if missing
    private String safeGetISO3Country(Locale locale) {
        try {
            return locale.getISO3Country();
        } catch (MissingResourceException e) {
            return "";
        }
    }
    
    // Helper method to safely get ISO3 language code, defaulting to an empty string if missing
    private String safeGetISO3Language(Locale locale) {
        try {
            return locale.getISO3Language();
        } catch (MissingResourceException e) {
            return "";
        }
    }
    
}