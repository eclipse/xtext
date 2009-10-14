/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.xtext.scoping.IQualifiedNameProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EObjectDescriptorIndexer {

	@Inject
	private IQualifiedNameProvider nameProvider;

	public void update(Resource resource, IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			URI uri = resource.getURI();
			String fragment = resource.getURIFragment(eObject);
			String name = nameProvider.getQualifiedName(eObject);
			indexUpdater.createOrUpdateEObject(uri, fragment, name, eObject.eClass(), getUserData(eObject));
		}
	}

	protected Map<String, String> getUserData(EObject eObject) {
		return null;
	}
}
