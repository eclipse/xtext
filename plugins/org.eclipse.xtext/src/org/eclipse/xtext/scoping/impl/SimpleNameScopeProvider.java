/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IExportedEObjectsProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleNameScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(SimpleNameScopeProvider.class);

	@Inject
	private IExportedEObjectsProvider.Registry exportedEObjectsProviderRegistry;

	public IScope getScope(EObject context, EReference reference) {
		IExportedEObjectsProvider provider = exportedEObjectsProviderRegistry.getExportedEObjectsProvider(context.eResource());
		Iterable<IEObjectDescription> exportedObjects = provider.getExportedObjects(context.eResource());
		Iterable<IEObjectDescription> filtered = Scopes.selectCompatible(exportedObjects, reference.getEReferenceType());
		return new SimpleScope(getGlobalScope(context, reference), filtered);
	}
	
}
