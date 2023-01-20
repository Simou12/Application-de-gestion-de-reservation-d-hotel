package agence.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;

public abstract class ComplexUserInputProcessor<T> {
	
	protected String message;
	protected BufferedReader inputReader;
	protected Method parser;
	protected Predicate<String> isValid;
	protected T parameter;
	
	public ComplexUserInputProcessor(BufferedReader inputReader) {
		this.inputReader = inputReader;
		setMessage();
		setParser();
		setValidityCritersion();
	}
	
	protected abstract void setMessage();
	protected abstract void setParser();
	protected abstract void setValidityCritersion();
	
	public T process() throws IOException{
		String userInput = inputReader.readLine();
		
		while(!isValid.test(userInput)) {
			System.err.println("La valeur saisie n'est pas valide, veuillez réessayer");
			userInput = inputReader.readLine();
		}
		try {
			parameter = (T) parser.invoke(null, userInput);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
			e.printStackTrace();
		}
		return parameter;
	}

}
