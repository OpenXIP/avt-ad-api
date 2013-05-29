package com.siemens.scr.avt.ad.api;

public class FacadeManager {
	private static ADFacade facade;
	
	public static ADFacade getFacade(){
		if (facade == null){
			try {
				Class.forName("com.siemens.scr.avt.ad.api.impl.DefaultADFacadeImpl");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return facade;
	}
	
	public static void register(ADFacade injected){
		facade = injected;
	}
}
