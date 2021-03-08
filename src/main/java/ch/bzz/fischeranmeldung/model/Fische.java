package ch.bzz.fischeranmeldung.model;

/**
 * Modelclass of fische with all the variables and the getters and setters
 *
 * M133: Fischeranmeldung
 *
 * @date 08.03.2021
 * @author Anid Memisi
 * @version 1.0
 */

public class Fische {
    private int wert;
    private String fischart;

    /**
     * sets the id/price of the fish
     *
     * @return wert
     */
    public int getWert() { return wert; }

    /**
     * sets the id/price of the fish
     *
     * @param wert
     */
    public void setWert(int wert) {
        this.wert = wert;
    }

    /**
     * returns the species of the fisch
     *
     * @return fischart
     */
    public String getFischart() {
        return fischart;
    }

    /**
     * sets the species of the fisch
     *
     * @param fischart
     */
    public void setFischart(String fischart) {
        this.fischart = fischart;
    }

}
