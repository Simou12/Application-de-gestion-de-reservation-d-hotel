package agence.main;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractMain {
	public static String SERVICE_WSDL_URL;
	public static final String QUIT ="0";
	
	protected void setTestServiceWSDLUrl(BufferedReader inputReader) throws IOException{
		System.out.println("Veuillez entrer une URL");
		while(!valideServiceWSDL()) {
			System.err.println("ERROR: "+SERVICE_WSDL_URL+" n'est pas une URL valide");
			SERVICE_WSDL_URL = inputReader.readLine();
		}
	}
	
	protected void setTestServiceWSDLUrl2(BufferedReader inputReader) throws IOException{
		System.out.println("Veuillez entrer une URL");
		while(!valideServiceWSDL2()) {
			System.err.println("ERROR: "+SERVICE_WSDL_URL+" n'est pas une URL valide");
			SERVICE_WSDL_URL = inputReader.readLine();
		}
	}

	protected abstract boolean valideServiceWSDL();
	protected abstract boolean valideServiceWSDL2();
	protected abstract void menu();

}
