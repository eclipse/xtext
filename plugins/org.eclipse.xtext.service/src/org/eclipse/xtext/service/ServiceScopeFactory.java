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

import org.eclipse.xtext.service.internal.ServiceScope;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ServiceScopeFactory {

	private static Map<String, IServiceScope> id2descriptorMap = new HashMap<String, IServiceScope>();

	public static IServiceScope get(String languageId) {
		IServiceScope languageDescriptor = id2descriptorMap.get(languageId);
		return languageDescriptor;
	}

	public static IServiceScope createScope(String scopeId, IServiceScope parentScope) {
		synchronized (id2descriptorMap) {
			IServiceScope existingScope = id2descriptorMap.get(scopeId);
			if (existingScope != null) {
				throw new IllegalArgumentException("Service scope " + scopeId + " already registered.");
			}
			ServiceScope scope = new ServiceScope(scopeId, parentScope);
			id2descriptorMap.put(scopeId, scope);
			return scope;
		}
	}

	/** 
	 * For test purposes only.
	 */
	public static void resetInternal() {
		synchronized (id2descriptorMap) {
			id2descriptorMap.clear();
		}
	}
}
