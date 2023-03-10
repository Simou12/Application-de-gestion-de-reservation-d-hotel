
package service.web.hotel2;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IHotelService2", targetNamespace = "http://serviceWeb2/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IHotelService2 {


    /**
     * 
     * @return
     *     returns java.util.List<service.web.hotel2.Hotel>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHotelList2", targetNamespace = "http://serviceWeb2/", className = "service.web.hotel2.GetHotelList2")
    @ResponseWrapper(localName = "getHotelList2Response", targetNamespace = "http://serviceWeb2/", className = "service.web.hotel2.GetHotelList2Response")
    @Action(input = "http://serviceWeb2/IHotelService2/getHotelList2Request", output = "http://serviceWeb2/IHotelService2/getHotelList2Response")
    public List<Hotel> getHotelList2();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @param arg9
     * @param arg8
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "ReservChambre")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ReservChambre", targetNamespace = "http://serviceWeb2/", className = "service.web.hotel2.ReservChambre")
    @ResponseWrapper(localName = "ReservChambreResponse", targetNamespace = "http://serviceWeb2/", className = "service.web.hotel2.ReservChambreResponse")
    @Action(input = "http://serviceWeb2/IHotelService2/ReservChambreRequest", output = "http://serviceWeb2/IHotelService2/ReservChambreResponse")
    public boolean reservChambre(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        int arg5,
        @WebParam(name = "arg6", targetNamespace = "")
        int arg6,
        @WebParam(name = "arg7", targetNamespace = "")
        String arg7,
        @WebParam(name = "arg8", targetNamespace = "")
        String arg8,
        @WebParam(name = "arg9", targetNamespace = "")
        int arg9);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cancelReservationChambre", targetNamespace = "http://serviceWeb2/", className = "service.web.hotel2.CancelReservationChambre")
    @ResponseWrapper(localName = "cancelReservationChambreResponse", targetNamespace = "http://serviceWeb2/", className = "service.web.hotel2.CancelReservationChambreResponse")
    @Action(input = "http://serviceWeb2/IHotelService2/cancelReservationChambreRequest", output = "http://serviceWeb2/IHotelService2/cancelReservationChambreResponse")
    public boolean cancelReservationChambre(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5);

}
