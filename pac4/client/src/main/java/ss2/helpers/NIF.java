package ss2.helpers;

import ss2.helpers.Identificador;
import java.text.DecimalFormat;

/**
 * <b>Descripci� :</b><br>
 * Classe NIF. Gestiona documents d'identificaci�o fiscal. <br>
 * Amb utilitats per el pas de DNIs a NIFs.<br>
 * <br>
 * Adaptada de Jose Luis Monte Galiano v2004 - 1.1
 * per a heretar d'Identificador i pasar a ella part dels
 * seus m�todes.<br>
 * Millores: L'anterior falla amb cif's com "S33LLL23A" i
 * d�na per v�lids dni's amb longitud > 9.
 * @author Javier S�nchez Portero <jsanchezpor@uoc.edu>
 * @version 8/4/2008 - 0.1
 */
public class NIF extends Identificador {

    /**
     *
     */
    private static final long serialVersionUID = -3088555014204127712L;


    /**
     * Constructor amb DNI.
     * @param nombre : DNI a partir del cual es forma el NIF.
     */
    public NIF(int nombre) {
        super( ((DecimalFormat)(new DecimalFormat("00000000"))).format(nombre)
                + NIF.trobarLletra(nombre));
    }

    /**
     * Constructor amb NIF.
     * @param id : NIF.
     */
    public NIF(String id) {
        super(id);
    }

    /**
     * Funci� que determina si un NIF de la inst�ncia actual es o no v�lid.
     * @return Boole� amb VERTADER si el NIF es correcte, i FALS si no ho es.
     */
    @Override
    public boolean validar() {
        return validar(this.getId());
    }

    /**
     * Funci� est�tica que determina si un NIF donat es o no v�lid
     * Millores: un NIF de m�s de 9 car�cters no �s v�lid,
     * immune a excepcions llan�ades per parseInt o charAt
     * @param id : String que emmagatzema el NIF a validar.
     * @return Boole� amb VERTADER si el NIF es correcte, i FALS si no ho es.
     */
    public static boolean validar(String id) {
        boolean validar = false;
        try {
            if (id.length() < 10) {
                char control = id.charAt(id.length() - 1);
                int nombre = Integer.parseInt(id.substring(0, id.length() - 1));
                validar = ( control == trobarLletra(nombre));
            }
        }
        catch(Exception e) {
            validar = false;
        }
        return validar;
    }

    /**
     * Funci� est�tica que retorna la lletra de NIF corresponent a un DNI donat.
     * @param nombre : DNI del que es vol trobar la lletra del NIF.
     * @return String amb la lletra corresponent.
    */
    public static char trobarLletra(int nombre) {
        return "TRWAGMYFPDXBNJZSQVHLCKET".charAt(nombre % 23);
    }


    /**
     * proves
     */
    public static void main(String[] args) {
        Identificador x = new NIF(12345);
        Identificador y = new NIF("12345V");
        Identificador z = new NIF("123456V");
        System.out.println(x);
        System.out.println(y.validar());
        System.out.println(z.validar());
        System.out.println(x.equals(y));
        System.out.println(y.compareTo(z));
    }

}
