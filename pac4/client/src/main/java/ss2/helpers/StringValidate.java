/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.helpers;

import java.util.regex.*;

/**
 *
 * @author josi
 */
public class StringValidate {
    private String emailString  = ".+@.+\\.[a-z]+";
    private String nifString    = "^[0-9]+";
    private String phoneString  = "^[0-9]+";
    public enum ValidateKinds { NIF, EMAIL, CP };
	public enum DocIdType { NIF, NIE, CIF, UNKNOWN };

    public Boolean isValid(ValidateKinds kind, String theString) {
        Pattern pattern = null;
        switch (kind) {
            case EMAIL:
                pattern = Pattern.compile(emailString);
                break;
            case NIF:
                pattern = Pattern.compile(nifString);
                break;
            case CP:
                pattern = Pattern.compile(phoneString);
                break;
        }
        Matcher matcher = pattern.matcher(theString);
        boolean matchFound = matcher.matches();

        return matchFound;
    }

	public Boolean isValid_CIF_NIE_NIF(String theID) {
		if ( new NIE(theID).validar() ||
			 new NIF(theID).validar() ||
			 new CIF(theID).validar()) {
			return true;
		}
		return false;

	}

	public Boolean isValidCP(String CP) {
	  Boolean returnValue = false;
	  Integer theCP;
	  try {
	     theCP = Integer.parseInt(CP);
	     returnValue=true;
	  } catch (NumberFormatException ex) {}

	  return returnValue;

	}

	public Boolean isValidCPStrict(String CP) {
	  Boolean returnValue = false;
	  Integer theCP;
	  try {
	     theCP = Integer.parseInt(CP);
	     if ((theCP <= 999) || (theCP >= 53000)) {
	     } else {
			  returnValue=true;
		  }
	  } catch (NumberFormatException ex) {}

	  return returnValue;

	}

	public DocIdType getDocIdType(String theID) {
		DocIdType result;

		if (new NIE(theID).validar()) {
			result = DocIdType.NIE;
		} else if (new NIF(theID).validar()) {
			result = DocIdType.NIF;
		} else if (new CIF(theID).validar()) {
			result = DocIdType.CIF;
		} else {
			result = DocIdType.UNKNOWN;
		}
		return result;
	}



}
