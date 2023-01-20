
package service.web.hotel2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour chambre complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="chambre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateReserve" type="{http://serviceWeb2/}localDate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numeroChambre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://serviceWeb2/}typeChambre" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chambre", propOrder = {
    "dateReserve",
    "numeroChambre",
    "prix",
    "type"
})
public class Chambre {

    @XmlElement(nillable = true)
    protected List<LocalDate> dateReserve;
    protected int numeroChambre;
    protected int prix;
    @XmlSchemaType(name = "string")
    protected TypeChambre type;

    /**
     * Gets the value of the dateReserve property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dateReserve property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDateReserve().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalDate }
     * 
     * 
     */
    public List<LocalDate> getDateReserve() {
        if (dateReserve == null) {
            dateReserve = new ArrayList<LocalDate>();
        }
        return this.dateReserve;
    }

    /**
     * Obtient la valeur de la propriété numeroChambre.
     * 
     */
    public int getNumeroChambre() {
        return numeroChambre;
    }

    /**
     * Définit la valeur de la propriété numeroChambre.
     * 
     */
    public void setNumeroChambre(int value) {
        this.numeroChambre = value;
    }

    /**
     * Obtient la valeur de la propriété prix.
     * 
     */
    public int getPrix() {
        return prix;
    }

    /**
     * Définit la valeur de la propriété prix.
     * 
     */
    public void setPrix(int value) {
        this.prix = value;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link TypeChambre }
     *     
     */
    public TypeChambre getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeChambre }
     *     
     */
    public void setType(TypeChambre value) {
        this.type = value;
    }

}
