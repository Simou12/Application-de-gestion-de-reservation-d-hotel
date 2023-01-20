package com.client.rest.cli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMain {
	public List<String> listUriAgences = new ArrayList<String>();
	public Map<String, String> listAgence= new HashMap<String, String>();

	public static final String QUIT ="0";
	
	protected abstract void menu();
	
}
