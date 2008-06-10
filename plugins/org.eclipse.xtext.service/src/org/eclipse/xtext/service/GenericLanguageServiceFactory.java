/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/package org.eclipse.xtext.service;


/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class GenericLanguageServiceFactory implements ILanguageServiceFactory{
	
	private Class<? extends ILanguageService> serviceInterface;
    private Class<? extends ILanguageService> serviceClass;
	
	public GenericLanguageServiceFactory(Class<? extends ILanguageService> serviceInterface, Class<? extends ILanguageService> serviceClass) {
		super();
		this.serviceInterface = serviceInterface;
		this.serviceClass = serviceClass;
		if(!serviceInterface.isAssignableFrom(serviceClass)) {
		    throw new IllegalArgumentException("Service class must implement service interface.");
		}
	}

	public ILanguageService createLanguageService() {
	    try {
	        return serviceClass.newInstance();
	    } catch(Exception exc) {
	        throw new RuntimeException(exc);
	    }
	}

    public Class<? extends ILanguageService> getServiceInterface() {
        return serviceInterface;
    }
    
}
