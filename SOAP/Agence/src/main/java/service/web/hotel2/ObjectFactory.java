
package service.web.hotel2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.web.hotel2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetHotelList2_QNAME = new QName("http://serviceWeb2/", "getHotelList2");
    private final static QName _CancelReservationChambreResponse_QNAME = new QName("http://serviceWeb2/", "cancelReservationChambreResponse");
    private final static QName _ReservChambreResponse_QNAME = new QName("http://serviceWeb2/", "ReservChambreResponse");
    private final static QName _CancelReservationChambre_QNAME = new QName("http://serviceWeb2/", "cancelReservationChambre");
    private final static QName _ReservChambre_QNAME = new QName("http://serviceWeb2/", "ReservChambre");
    private final static QName _GetHotelList2Response_QNAME = new QName("http://serviceWeb2/", "getHotelList2Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.web.hotel2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link Hotel.ListAgencePartenaire }
     * 
     */
    public Hotel.ListAgencePartenaire createHotelListAgencePartenaire() {
        return new Hotel.ListAgencePartenaire();
    }

    /**
     * Create an instance of {@link ReservChambre }
     * 
     */
    public ReservChambre createReservChambre() {
        return new ReservChambre();
    }

    /**
     * Create an instance of {@link GetHotelList2Response }
     * 
     */
    public GetHotelList2Response createGetHotelList2Response() {
        return new GetHotelList2Response();
    }

    /**
     * Create an instance of {@link GetHotelList2 }
     * 
     */
    public GetHotelList2 createGetHotelList2() {
        return new GetHotelList2();
    }

    /**
     * Create an instance of {@link CancelReservationChambreResponse }
     * 
     */
    public CancelReservationChambreResponse createCancelReservationChambreResponse() {
        return new CancelReservationChambreResponse();
    }

    /**
     * Create an instance of {@link ReservChambreResponse }
     * 
     */
    public ReservChambreResponse createReservChambreResponse() {
        return new ReservChambreResponse();
    }

    /**
     * Create an instance of {@link CancelReservationChambre }
     * 
     */
    public CancelReservationChambre createCancelReservationChambre() {
        return new CancelReservationChambre();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link Chambre }
     * 
     */
    public Chambre createChambre() {
        return new Chambre();
    }

    /**
     * Create an instance of {@link Hotel.ListAgencePartenaire.Entry }
     * 
     */
    public Hotel.ListAgencePartenaire.Entry createHotelListAgencePartenaireEntry() {
        return new Hotel.ListAgencePartenaire.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelList2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb2/", name = "getHotelList2")
    public JAXBElement<GetHotelList2> createGetHotelList2(GetHotelList2 value) {
        return new JAXBElement<GetHotelList2>(_GetHotelList2_QNAME, GetHotelList2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelReservationChambreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb2/", name = "cancelReservationChambreResponse")
    public JAXBElement<CancelReservationChambreResponse> createCancelReservationChambreResponse(CancelReservationChambreResponse value) {
        return new JAXBElement<CancelReservationChambreResponse>(_CancelReservationChambreResponse_QNAME, CancelReservationChambreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservChambreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb2/", name = "ReservChambreResponse")
    public JAXBElement<ReservChambreResponse> createReservChambreResponse(ReservChambreResponse value) {
        return new JAXBElement<ReservChambreResponse>(_ReservChambreResponse_QNAME, ReservChambreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelReservationChambre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb2/", name = "cancelReservationChambre")
    public JAXBElement<CancelReservationChambre> createCancelReservationChambre(CancelReservationChambre value) {
        return new JAXBElement<CancelReservationChambre>(_CancelReservationChambre_QNAME, CancelReservationChambre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservChambre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb2/", name = "ReservChambre")
    public JAXBElement<ReservChambre> createReservChambre(ReservChambre value) {
        return new JAXBElement<ReservChambre>(_ReservChambre_QNAME, ReservChambre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelList2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb2/", name = "getHotelList2Response")
    public JAXBElement<GetHotelList2Response> createGetHotelList2Response(GetHotelList2Response value) {
        return new JAXBElement<GetHotelList2Response>(_GetHotelList2Response_QNAME, GetHotelList2Response.class, null, value);
    }

}
