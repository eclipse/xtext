/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/package org.eclipse.xtext.service.impl;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;

/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class SingletonLanguageServiceFactory implements ILanguageServiceFactory{
	
	private ILanguageService service;
	private Class<? extends ILanguageService> clazz;
	
	public SingletonLanguageServiceFactory(ILanguageService service, Class<? extends ILanguageService> clazz) {
		super();
		this.service = service;
		this.clazz= clazz;
	}

	public ILanguageService createLanguageService() {
		return service;
	}

    public Class<? extends ILanguageService> getServiceClass() {
        return clazz;
    }

}
