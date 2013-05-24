package common.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Técnicas de Desarrollo de Software
 * Universitat Oberta de Catalunya (UOC)
 * @
 * @author Joan Esteve Riasol
 * @version 1.0
 *
 */
public class TDSLanguageUtils  {
	private static ResourceBundle resourceBundle;
	private static String currentBaseName;
	private static Locale currentLocale;

	/**
	 * Configura el idioma por defecto en el gestor de idiomas TDSLanguageUtils.*
	 * De esta manera, siempre se sacar�n los mensajes en el idioma por defecto del sistema operativo.
	 * Este viene referenciado por Locale.getDefault()
	 *
	 * @param  baseName  direcci�n donde se encuentra el fichero de idiomas
	 * @throws NullPointerException si baseName es nulo
	 * @return un booleano indicando si la operaci�n ha ido bien
	 */

	public static synchronized boolean setDefaultLanguage(String baseName) {
		try {
			currentBaseName=baseName;
			resourceBundle = ResourceBundle.getBundle(baseName,Locale.getDefault());
			return true;
		}catch(MissingResourceException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Configura el idioma indicado por el usuario en el gestor de idiomas TDSLanguageUtils
	 *
	 * @param baseName direcci�n donde se encuentra el fichero de idiomas
	 * @param locale idioma que se quiere indicar
	 * @throws NullPointerException si baseName o locale son nulos
	 * @return un booleano indicando si la operaci�n ha ido bien
	 */

	public static synchronized boolean setLanguage(String baseName, Locale locale) {
		try {
			currentBaseName=baseName;
			currentLocale=locale;
			resourceBundle = ResourceBundle.getBundle(baseName,locale);
			return true;
		}catch(MissingResourceException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Obtiene el texto del fichero de idiomas segun la etiqueta solicitada
	 *
	 * @param key etiqueta del fichero de idiomas
	 * @param locale idioma que se quiere indicar
	 * @throws NullPointerException si el gestor de idiomas no ha sido a�n configurado
	 * @return un String con la traducci�n solicitada
	 */

	public static String getMessage(String key)  {
		try {
			return resourceBundle.getString(key);
		}catch(MissingResourceException e) {
			return new String();
		}
	}

	/**
	 * Informa cual es actualmente el fichero de idiomas configurado
	 *
	 * @return un String con el nombre del fichero del gestor de idiomas
	 */

	public static String getCurrentBaseName() {
		return currentBaseName;
	}

	/**
	 * Informa cual es actualmente el idioma configurado
	 *
	 * @return un Locale con el idioma del gestor de idiomas
	 */
	public static Locale getCurrentLocale() {
		return currentLocale;
	}

}
