/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import com.google.inject.Injector;

/**
 * 
 * @author Jan Köhnlein
 * @author Dennis Hübner
 * 
 */
public class ServiceRegistry {

	private static final Logger logger = Logger.getLogger(ServiceRegistry.class);

	private static Map<IServiceScope, Injector> injectors = new HashMap<IServiceScope, Injector>();

	public static Injector getInjector(IServiceScope serviceScope) {
		Injector result = injectors.get(serviceScope);
		if(result==null)
			throw new NoSuchElementException("No injector for scope " + serviceScope);
		
		return result;
	}
	
	public static void registerInjector(IServiceScope serviceScope, Injector injector) {
		if (injectors.containsKey(serviceScope))
			logger.warn("replacing already registered injector for service scope "+serviceScope);
		injectors.put(serviceScope, injector);
	}
	
}
