/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.findReferences;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The language that defines a given object can decide to add other objects
 * to the set of of target URIs if they have been derived from the given object.
 * 
 * The implementation of {@link #add(EObject, TargetURIs)} will dispatch to the
 * language implementation that defines the object.
 * 
 * Clients should override {@link #doAdd(EObject, TargetURIs)} to enhance the set of
 * targets.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class TargetURICollector {

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	public void add(EObject object, TargetURIs targetURIs) {
		IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(EcoreUtil.getURI(object));
		if (serviceProvider != null) {
			TargetURICollector languageSpecific = serviceProvider.get(TargetURICollector.class);
			if (languageSpecific != null) {
				languageSpecific.doAdd(object, targetURIs);
				return;
			}
		}
		doAdd(object, targetURIs);
	}
	
	protected void doAdd(EObject object, TargetURIs targetURIs) {
		URI uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(object);
		targetURIs.addURI(uri);
	}
	
}
