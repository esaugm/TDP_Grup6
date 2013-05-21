package common.entity;

import java.io.Serializable;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 15:59
 */
public enum PerfilUsuari implements Serializable {
    ADMINISTRADOR, ADMINISTRATIU, CAPTALLER, MECANIC, UNKNOWN;

    public static PerfilUsuari getPerfilUsuari(String pPerfilUsuari){
        String tipus= pPerfilUsuari.toUpperCase();
        if (tipus.equals("ADMINISTRADOR")) return ADMINISTRADOR;
        if (tipus.equals("ADMINISTRATIU")) return ADMINISTRATIU;
        if (tipus.equals("CAPTALLER")) return CAPTALLER;
        if (tipus.equals("MECANIC")) return MECANIC;
        else return UNKNOWN;
    }
}
