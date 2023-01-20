
package service.web.hotel1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour typeChambre.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="typeChambre">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="simple"/>
 *     &lt;enumeration value="DoubleConfort"/>
 *     &lt;enumeration value="TripleFamiliale"/>
 *     &lt;enumeration value="QuadrupleFamiliale"/>
 *     &lt;enumeration value="quintuple"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "typeChambre")
@XmlEnum
public enum TypeChambre {

    @XmlEnumValue("simple")
    SIMPLE("simple"),
    @XmlEnumValue("DoubleConfort")
    DOUBLE_CONFORT("DoubleConfort"),
    @XmlEnumValue("TripleFamiliale")
    TRIPLE_FAMILIALE("TripleFamiliale"),
    @XmlEnumValue("QuadrupleFamiliale")
    QUADRUPLE_FAMILIALE("QuadrupleFamiliale"),
    @XmlEnumValue("quintuple")
    QUINTUPLE("quintuple");
    private final String value;

    TypeChambre(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeChambre fromValue(String v) {
        for (TypeChambre c: TypeChambre.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
