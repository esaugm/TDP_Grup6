package ss2.helpers;

import ss2.helpers.Identificador;
import java.text.DecimalFormat;

/**
 * Classe NIE. Gestiona Nombre d'Identificaci� d'Estranger.
 * Els NIE es distingeixen per una lletra inicial que �s:<br>
 * X. expedit per la D.G. de Policia <br>
 * M. expedit per l'Ag�ncia Tribut�ria <br>
 * K. espanyols menors de 14 anys i estrangers menors de 18
 * (derogat 31/12/2007)<br>
 * L. espanyols majors de 14 anys residint en l'estranger i
 * que es traslladen per temps inferior a 6 mesos a Espanya. <br>
 * El car�cter de control final es calcula sobre els 7 nombres
 * restants de la mateixa forma que en la classe NIF<br>
 * Adaptada de Jose Luis Monte Galiano v2004 - 1.1
 * @author Javier S�nchez Portero <jsanchezpor@uoc.edu>
 * @version 8/4/2008 - 0.1
 */
public class NIE extends Identificador {

    private static final long serialVersionUID = -4284722992864002378L;


    /**
     * Constructor amb nombre. Letra inicial 'X' por defecto
     * @param nombre : nombre a partir del cual es forma el NIF.
     */
    public NIE(int nombre) {
        super("X" + ((DecimalFormat)(new DecimalFormat("0000000"))).format(nombre)
            + NIE.trobarLletra(nombre));
    }


    /**
     * Constructor amb NIE.
     * @param id : NIE.
     */
    public NIE(String id) {
        super(id);
    }

    /**
     * Funci� que determina si un NIE de la inst�ncia actual es o no v�lid.
     * @return Boole� amb VERTADER si el NIE es correcte, i FALS si no ho es.
     */
    @Override
    public boolean validar() {
        return validar(this.getId());
    }

    /**
     * Funci� est�tica que determina si un NIE donat es o no v�lid
     * @param id : String que emmagatzema el NIE a validar.
     * @return Booleà amb VERTADER si el NIE es correcte, i FALS si no ho es.
     */
    public static boolean validar(String id) {
        boolean validar = false;
        try {
            if (id.length() == 9) {
                if ("XMKL".indexOf(id.charAt(0)) >= 0) {
                    int nombre = Integer.parseInt(id.substring(1, id.length()-1));
                    validar = (id.charAt(8) == NIE.trobarLletra(nombre));
                }
            }
        }
        catch(Exception e) {
            validar = false;
        }
        return validar;
    }


    /**
     * Funci� est�tica que retorna la lletra de NIE corresponent a un nombre donat.
     * {pre: id debe tener m�s de 2 caracteres todos num�ricos}
     * @param nombre : nombre del que es vol trobar la lletra del NIE.
     * @return String amb la lletra corresponent.
    */
    public static char trobarLletra(int nombre) {
        return "TRWAGMYFPDXBNJZSQVHLCKET".charAt(nombre % 23);
    }


    /**
     *  proves
     */
    public static void main(String[] args) {
        Identificador x = new NIE(12345);
        Identificador y = new NIE("M0012345V");
        Identificador z = new NIE("A0012345V");
        System.out.println(x + "=" + x.validar());
        System.out.println(y + "=" + y.validar());
        System.out.println(z + "=" + z.validar());
        System.err.println(Character.getNumericValue('A'));
        System.err.println((byte)'A');
    }

}
