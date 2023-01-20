
package service.web.hotel1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.web.hotel1 package. 
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

    private final static QName _GetHotelListResponse_QNAME = new QName("http://serviceWeb1/", "getHotelListResponse");
    private final static QName _UpdateCResponse_QNAME = new QName("http://serviceWeb1/", "updateCResponse");
    private final static QName _UpdateC_QNAME = new QName("http://serviceWeb1/", "updateC");
    private final static QName _GetHotelByName_QNAME = new QName("http://serviceWeb1/", "getHotelByName");
    private final static QName _VerifChambreTypeResponse_QNAME = new QName("http://serviceWeb1/", "verifChambreTypeResponse");
    private final static QName _CheckAgencePartenaire_QNAME = new QName("http://serviceWeb1/", "checkAgencePartenaire");
    private final static QName _ListChambreDispoServiceResponse_QNAME = new QName("http://serviceWeb1/", "listChambreDispoServiceResponse");
    private final static QName _PrintHotelResponse_QNAME = new QName("http://serviceWeb1/", "printHotelResponse");
    private final static QName _VerifChambreDispoResponse_QNAME = new QName("http://serviceWeb1/", "verifChambreDispoResponse");
    private final static QName _ListChambreDispoService_QNAME = new QName("http://serviceWeb1/", "listChambreDispoService");
    private final static QName _SetHotelListResponse_QNAME = new QName("http://serviceWeb1/", "setHotelListResponse");
    private final static QName _SetHotelList_QNAME = new QName("http://serviceWeb1/", "setHotelList");
    private final static QName _PrintChambreDispoResponse_QNAME = new QName("http://serviceWeb1/", "printChambreDispoResponse");
    private final static QName _PrintHotel_QNAME = new QName("http://serviceWeb1/", "printHotel");
    private final static QName _PrintChambreDispo_QNAME = new QName("http://serviceWeb1/", "printChambreDispo");
    private final static QName _GetHotelByNameResponse_QNAME = new QName("http://serviceWeb1/", "getHotelByNameResponse");
    private final static QName _VerifChambreDispo_QNAME = new QName("http://serviceWeb1/", "verifChambreDispo");
    private final static QName _HotelNotFound_QNAME = new QName("http://serviceWeb1/", "HotelNotFound");
    private final static QName _VerifChambreType_QNAME = new QName("http://serviceWeb1/", "verifChambreType");
    private final static QName _AjouteAgencePartenaireResponse_QNAME = new QName("http://serviceWeb1/", "ajouteAgencePartenaireResponse");
    private final static QName _UpdateR_QNAME = new QName("http://serviceWeb1/", "updateR");
    private final static QName _UpdateRResponse_QNAME = new QName("http://serviceWeb1/", "updateRResponse");
    private final static QName _AjouteAgencePartenaire_QNAME = new QName("http://serviceWeb1/", "ajouteAgencePartenaire");
    private final static QName _CheckAgencePartenaireResponse_QNAME = new QName("http://serviceWeb1/", "checkAgencePartenaireResponse");
    private final static QName _GetHotelList_QNAME = new QName("http://serviceWeb1/", "getHotelList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.web.hotel1
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
     * Create an instance of {@link SetHotelList }
     * 
     */
    public SetHotelList createSetHotelList() {
        return new SetHotelList();
    }

    /**
     * Create an instance of {@link PrintChambreDispo }
     * 
     */
    public PrintChambreDispo createPrintChambreDispo() {
        return new PrintChambreDispo();
    }

    /**
     * Create an instance of {@link PrintChambreDispoResponse }
     * 
     */
    public PrintChambreDispoResponse createPrintChambreDispoResponse() {
        return new PrintChambreDispoResponse();
    }

    /**
     * Create an instance of {@link PrintHotel }
     * 
     */
    public PrintHotel createPrintHotel() {
        return new PrintHotel();
    }

    /**
     * Create an instance of {@link VerifChambreDispoResponse }
     * 
     */
    public VerifChambreDispoResponse createVerifChambreDispoResponse() {
        return new VerifChambreDispoResponse();
    }

    /**
     * Create an instance of {@link ListChambreDispoService }
     * 
     */
    public ListChambreDispoService createListChambreDispoService() {
        return new ListChambreDispoService();
    }

    /**
     * Create an instance of {@link SetHotelListResponse }
     * 
     */
    public SetHotelListResponse createSetHotelListResponse() {
        return new SetHotelListResponse();
    }

    /**
     * Create an instance of {@link VerifChambreTypeResponse }
     * 
     */
    public VerifChambreTypeResponse createVerifChambreTypeResponse() {
        return new VerifChambreTypeResponse();
    }

    /**
     * Create an instance of {@link CheckAgencePartenaire }
     * 
     */
    public CheckAgencePartenaire createCheckAgencePartenaire() {
        return new CheckAgencePartenaire();
    }

    /**
     * Create an instance of {@link ListChambreDispoServiceResponse }
     * 
     */
    public ListChambreDispoServiceResponse createListChambreDispoServiceResponse() {
        return new ListChambreDispoServiceResponse();
    }

    /**
     * Create an instance of {@link PrintHotelResponse }
     * 
     */
    public PrintHotelResponse createPrintHotelResponse() {
        return new PrintHotelResponse();
    }

    /**
     * Create an instance of {@link GetHotelListResponse }
     * 
     */
    public GetHotelListResponse createGetHotelListResponse() {
        return new GetHotelListResponse();
    }

    /**
     * Create an instance of {@link UpdateCResponse }
     * 
     */
    public UpdateCResponse createUpdateCResponse() {
        return new UpdateCResponse();
    }

    /**
     * Create an instance of {@link UpdateC }
     * 
     */
    public UpdateC createUpdateC() {
        return new UpdateC();
    }

    /**
     * Create an instance of {@link GetHotelByName }
     * 
     */
    public GetHotelByName createGetHotelByName() {
        return new GetHotelByName();
    }

    /**
     * Create an instance of {@link CheckAgencePartenaireResponse }
     * 
     */
    public CheckAgencePartenaireResponse createCheckAgencePartenaireResponse() {
        return new CheckAgencePartenaireResponse();
    }

    /**
     * Create an instance of {@link GetHotelList }
     * 
     */
    public GetHotelList createGetHotelList() {
        return new GetHotelList();
    }

    /**
     * Create an instance of {@link AjouteAgencePartenaireResponse }
     * 
     */
    public AjouteAgencePartenaireResponse createAjouteAgencePartenaireResponse() {
        return new AjouteAgencePartenaireResponse();
    }

    /**
     * Create an instance of {@link HotelNotFound }
     * 
     */
    public HotelNotFound createHotelNotFound() {
        return new HotelNotFound();
    }

    /**
     * Create an instance of {@link VerifChambreType }
     * 
     */
    public VerifChambreType createVerifChambreType() {
        return new VerifChambreType();
    }

    /**
     * Create an instance of {@link AjouteAgencePartenaire }
     * 
     */
    public AjouteAgencePartenaire createAjouteAgencePartenaire() {
        return new AjouteAgencePartenaire();
    }

    /**
     * Create an instance of {@link UpdateR }
     * 
     */
    public UpdateR createUpdateR() {
        return new UpdateR();
    }

    /**
     * Create an instance of {@link UpdateRResponse }
     * 
     */
    public UpdateRResponse createUpdateRResponse() {
        return new UpdateRResponse();
    }

    /**
     * Create an instance of {@link VerifChambreDispo }
     * 
     */
    public VerifChambreDispo createVerifChambreDispo() {
        return new VerifChambreDispo();
    }

    /**
     * Create an instance of {@link GetHotelByNameResponse }
     * 
     */
    public GetHotelByNameResponse createGetHotelByNameResponse() {
        return new GetHotelByNameResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "getHotelListResponse")
    public JAXBElement<GetHotelListResponse> createGetHotelListResponse(GetHotelListResponse value) {
        return new JAXBElement<GetHotelListResponse>(_GetHotelListResponse_QNAME, GetHotelListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "updateCResponse")
    public JAXBElement<UpdateCResponse> createUpdateCResponse(UpdateCResponse value) {
        return new JAXBElement<UpdateCResponse>(_UpdateCResponse_QNAME, UpdateCResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "updateC")
    public JAXBElement<UpdateC> createUpdateC(UpdateC value) {
        return new JAXBElement<UpdateC>(_UpdateC_QNAME, UpdateC.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "getHotelByName")
    public JAXBElement<GetHotelByName> createGetHotelByName(GetHotelByName value) {
        return new JAXBElement<GetHotelByName>(_GetHotelByName_QNAME, GetHotelByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifChambreTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "verifChambreTypeResponse")
    public JAXBElement<VerifChambreTypeResponse> createVerifChambreTypeResponse(VerifChambreTypeResponse value) {
        return new JAXBElement<VerifChambreTypeResponse>(_VerifChambreTypeResponse_QNAME, VerifChambreTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAgencePartenaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "checkAgencePartenaire")
    public JAXBElement<CheckAgencePartenaire> createCheckAgencePartenaire(CheckAgencePartenaire value) {
        return new JAXBElement<CheckAgencePartenaire>(_CheckAgencePartenaire_QNAME, CheckAgencePartenaire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListChambreDispoServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "listChambreDispoServiceResponse")
    public JAXBElement<ListChambreDispoServiceResponse> createListChambreDispoServiceResponse(ListChambreDispoServiceResponse value) {
        return new JAXBElement<ListChambreDispoServiceResponse>(_ListChambreDispoServiceResponse_QNAME, ListChambreDispoServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintHotelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "printHotelResponse")
    public JAXBElement<PrintHotelResponse> createPrintHotelResponse(PrintHotelResponse value) {
        return new JAXBElement<PrintHotelResponse>(_PrintHotelResponse_QNAME, PrintHotelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifChambreDispoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "verifChambreDispoResponse")
    public JAXBElement<VerifChambreDispoResponse> createVerifChambreDispoResponse(VerifChambreDispoResponse value) {
        return new JAXBElement<VerifChambreDispoResponse>(_VerifChambreDispoResponse_QNAME, VerifChambreDispoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListChambreDispoService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "listChambreDispoService")
    public JAXBElement<ListChambreDispoService> createListChambreDispoService(ListChambreDispoService value) {
        return new JAXBElement<ListChambreDispoService>(_ListChambreDispoService_QNAME, ListChambreDispoService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetHotelListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "setHotelListResponse")
    public JAXBElement<SetHotelListResponse> createSetHotelListResponse(SetHotelListResponse value) {
        return new JAXBElement<SetHotelListResponse>(_SetHotelListResponse_QNAME, SetHotelListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetHotelList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "setHotelList")
    public JAXBElement<SetHotelList> createSetHotelList(SetHotelList value) {
        return new JAXBElement<SetHotelList>(_SetHotelList_QNAME, SetHotelList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintChambreDispoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "printChambreDispoResponse")
    public JAXBElement<PrintChambreDispoResponse> createPrintChambreDispoResponse(PrintChambreDispoResponse value) {
        return new JAXBElement<PrintChambreDispoResponse>(_PrintChambreDispoResponse_QNAME, PrintChambreDispoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintHotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "printHotel")
    public JAXBElement<PrintHotel> createPrintHotel(PrintHotel value) {
        return new JAXBElement<PrintHotel>(_PrintHotel_QNAME, PrintHotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintChambreDispo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "printChambreDispo")
    public JAXBElement<PrintChambreDispo> createPrintChambreDispo(PrintChambreDispo value) {
        return new JAXBElement<PrintChambreDispo>(_PrintChambreDispo_QNAME, PrintChambreDispo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "getHotelByNameResponse")
    public JAXBElement<GetHotelByNameResponse> createGetHotelByNameResponse(GetHotelByNameResponse value) {
        return new JAXBElement<GetHotelByNameResponse>(_GetHotelByNameResponse_QNAME, GetHotelByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifChambreDispo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "verifChambreDispo")
    public JAXBElement<VerifChambreDispo> createVerifChambreDispo(VerifChambreDispo value) {
        return new JAXBElement<VerifChambreDispo>(_VerifChambreDispo_QNAME, VerifChambreDispo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelNotFound }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "HotelNotFound")
    public JAXBElement<HotelNotFound> createHotelNotFound(HotelNotFound value) {
        return new JAXBElement<HotelNotFound>(_HotelNotFound_QNAME, HotelNotFound.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifChambreType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "verifChambreType")
    public JAXBElement<VerifChambreType> createVerifChambreType(VerifChambreType value) {
        return new JAXBElement<VerifChambreType>(_VerifChambreType_QNAME, VerifChambreType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouteAgencePartenaireResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "ajouteAgencePartenaireResponse")
    public JAXBElement<AjouteAgencePartenaireResponse> createAjouteAgencePartenaireResponse(AjouteAgencePartenaireResponse value) {
        return new JAXBElement<AjouteAgencePartenaireResponse>(_AjouteAgencePartenaireResponse_QNAME, AjouteAgencePartenaireResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateR }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "updateR")
    public JAXBElement<UpdateR> createUpdateR(UpdateR value) {
        return new JAXBElement<UpdateR>(_UpdateR_QNAME, UpdateR.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "updateRResponse")
    public JAXBElement<UpdateRResponse> createUpdateRResponse(UpdateRResponse value) {
        return new JAXBElement<UpdateRResponse>(_UpdateRResponse_QNAME, UpdateRResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouteAgencePartenaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "ajouteAgencePartenaire")
    public JAXBElement<AjouteAgencePartenaire> createAjouteAgencePartenaire(AjouteAgencePartenaire value) {
        return new JAXBElement<AjouteAgencePartenaire>(_AjouteAgencePartenaire_QNAME, AjouteAgencePartenaire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAgencePartenaireResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "checkAgencePartenaireResponse")
    public JAXBElement<CheckAgencePartenaireResponse> createCheckAgencePartenaireResponse(CheckAgencePartenaireResponse value) {
        return new JAXBElement<CheckAgencePartenaireResponse>(_CheckAgencePartenaireResponse_QNAME, CheckAgencePartenaireResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceWeb1/", name = "getHotelList")
    public JAXBElement<GetHotelList> createGetHotelList(GetHotelList value) {
        return new JAXBElement<GetHotelList>(_GetHotelList_QNAME, GetHotelList.class, null, value);
    }

}
