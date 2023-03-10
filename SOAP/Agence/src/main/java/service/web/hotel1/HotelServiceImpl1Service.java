
package service.web.hotel1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HotelServiceImpl1Service", targetNamespace = "http://serviceWeb1/", wsdlLocation = "http://localhost:8080/hotelService1?wsdl")
public class HotelServiceImpl1Service
    extends Service
{

    private final static URL HOTELSERVICEIMPL1SERVICE_WSDL_LOCATION;
    private final static WebServiceException HOTELSERVICEIMPL1SERVICE_EXCEPTION;
    private final static QName HOTELSERVICEIMPL1SERVICE_QNAME = new QName("http://serviceWeb1/", "HotelServiceImpl1Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/hotelService1?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOTELSERVICEIMPL1SERVICE_WSDL_LOCATION = url;
        HOTELSERVICEIMPL1SERVICE_EXCEPTION = e;
    }

    public HotelServiceImpl1Service() {
        super(__getWsdlLocation(), HOTELSERVICEIMPL1SERVICE_QNAME);
    }

    public HotelServiceImpl1Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOTELSERVICEIMPL1SERVICE_QNAME, features);
    }

    public HotelServiceImpl1Service(URL wsdlLocation) {
        super(wsdlLocation, HOTELSERVICEIMPL1SERVICE_QNAME);
    }

    public HotelServiceImpl1Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOTELSERVICEIMPL1SERVICE_QNAME, features);
    }

    public HotelServiceImpl1Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HotelServiceImpl1Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IHotelService1
     */
    @WebEndpoint(name = "HotelServiceImpl1Port")
    public IHotelService1 getHotelServiceImpl1Port() {
        return super.getPort(new QName("http://serviceWeb1/", "HotelServiceImpl1Port"), IHotelService1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IHotelService1
     */
    @WebEndpoint(name = "HotelServiceImpl1Port")
    public IHotelService1 getHotelServiceImpl1Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://serviceWeb1/", "HotelServiceImpl1Port"), IHotelService1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOTELSERVICEIMPL1SERVICE_EXCEPTION!= null) {
            throw HOTELSERVICEIMPL1SERVICE_EXCEPTION;
        }
        return HOTELSERVICEIMPL1SERVICE_WSDL_LOCATION;
    }

}
