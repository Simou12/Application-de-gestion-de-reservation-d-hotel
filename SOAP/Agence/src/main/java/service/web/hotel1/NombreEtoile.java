
package service.web.hotel1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour nombreEtoile.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="nombreEtoile">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ZeroEtoile"/>
 *     &lt;enumeration value="uneEtoile"/>
 *     &lt;enumeration value="deuxEtoiles"/>
 *     &lt;enumeration value="troisEtoile"/>
 *     &lt;enumeration value="quatreEtoile"/>
 *     &lt;enumeration value="cinqEtoile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "nombreEtoile")
@XmlEnum
public enum NombreEtoile {

    @XmlEnumValue("ZeroEtoile")
    ZERO_ETOILE("ZeroEtoile"),
    @XmlEnumValue("uneEtoile")
    UNE_ETOILE("uneEtoile"),
    @XmlEnumValue("deuxEtoiles")
    DEUX_ETOILES("deuxEtoiles"),
    @XmlEnumValue("troisEtoile")
    TROIS_ETOILE("troisEtoile"),
    @XmlEnumValue("quatreEtoile")
    QUATRE_ETOILE("quatreEtoile"),
    @XmlEnumValue("cinqEtoile")
    CINQ_ETOILE("cinqEtoile");
    private final String value;

    NombreEtoile(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NombreEtoile fromValue(String v) {
        for (NombreEtoile c: NombreEtoile.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
