package ch.bzz.fischeranmeldung.model;
import java.util.Collection;
import java.util.Date;

/**
 * Modelclass of angler with all the variables and the getters and setters
 *
 * M133: Fischeranmeldung
 *
 * @date 08.03.2021
 * @author Anid Memisi
 * @version 1.0
 */

public class Angler {
    private String fischerLizenz;
    private String angelrute;
    private Collection<Fische> gefangeneFische;
    private Date angelTag;

    /**
     * returns the id of the fisher
     *
     * @return fischerLizenz
     */
    public String getLizenz() {
        return fischerLizenz;
    }


    /**
     * sets the id of the fisher
     *
     * @param fischerLizenz
     */
    public void setLizenz(String fischerLizenz) {
        this.fischerLizenz = fischerLizenz;
    }

    /**
     * returns what angelrute the fisher had
     *
     * @return angelrute
     */
    public String getAngelrute() {
        return angelrute;
    }


    /**
     * sets what angelrute the fisher had
     *
     * @param angelrute
     */
    public void setAngelrute(String angelrute) {
        this.angelrute = angelrute;
    }

    /**
     * returns the caught fish
     *
     * @return gefangeneFische
     */
    public Collection<Fische> getGefangeneFische() {
        return gefangeneFische;
    }


    /**
     * sets the caught fish
     *
     * @param gefangeneFische
     */
    public void setGefangeneFische(Collection<Fische> gefangeneFische) {
        this.gefangeneFische = gefangeneFische;
    }

    /**
     * returns the date of the fishing day
     *
     * @return angelTag
     */
    public Date getAngelTag() { return angelTag; }


    /**
     * sets the date of the fishing day
     *
     * @param angelTag
     */
    public void setAngelTag(Date angelTag) {
        this.angelTag = angelTag;
    }
}
