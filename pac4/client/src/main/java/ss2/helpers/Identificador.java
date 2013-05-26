package ss2.helpers;



/**
 * Superclase pensada per a ser l'arrel de la jerarquia
 * de documents d'identificaci�. Es pot emprar en
 * situacions en les quals calgui usar indistintament
 * NIF, CIF o altres.
 * Fa que l'aplicaci� sigui m�s resistent a possibles
 * canvis en la legislaci� sobre identificaci�.
 * @author Javier S�nchez Portero <jsanchezpor@uoc.edu>
 * @version 8/4/2008 - 0.1
 */
public abstract class Identificador
        implements Cloneable, Comparable<Identificador>,
                        java.io.Serializable {

    /** Identificador general */
    private String id;


    /* Constructor amb un par�metre
     * @param id : Identificador.
     */
    public Identificador(String id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obliga a implementar un m�tode de validaci�.
     */
    public abstract boolean validar();


    /**
     * @return the id
     */
    public String toString() {
        return id;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Identificador))
            return false;
        final Identificador other = (Identificador) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /**
     *  Implementa Comparable
     *  @param obj un Identificador no nulo
     *  @throws NullPointerException si obj es nulo
     */
    public int compareTo(Identificador obj) throws ClassCastException {
        return this.getId().compareTo(obj.getId());
    }

    /**
     *  proves
     */
    public static void main(String[] args) {
        NIF x = new NIF("12345678Z");
        NIE y = new NIE("X1234567L");
        Identificador z = new CIF("S3826006C");
        System.out.println(x + "=" + x.validar());
        System.out.println(y + "=" + y.validar());
        System.out.println(z + "=" + z.validar());
    }

}
