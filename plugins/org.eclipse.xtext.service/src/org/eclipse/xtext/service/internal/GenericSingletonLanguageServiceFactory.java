/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/package org.eclipse.xtext.service.internal;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;

/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class GenericSingletonLanguageServiceFactory implements ILanguageServiceFactory{
	
	private ILanguageService service;
	private Class<? extends ILanguageService> serviceInterface;
	
	public GenericSingletonLanguageServiceFactory(ILanguageService service, Class<? extends ILanguageService> serviceInterface) {
		super();
		this.service = service;
		this.serviceInterface = serviceInterface;
	}

	public ILanguageService createLanguageService() {
		return service;
	}

    public Class<? extends ILanguageService> getServiceInterface() {
        return serviceInterface;
    }
    
}
