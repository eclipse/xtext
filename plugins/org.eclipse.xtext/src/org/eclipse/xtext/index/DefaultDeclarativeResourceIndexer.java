/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfindex.store.ResourceIndexerImpl;
import org.eclipse.xtext.scoping.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.impl.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class DefaultDeclarativeResourceIndexer extends ResourceIndexerImpl {

	@Override
	protected boolean isIndexElement(EObject eObject, Resource resource) {
		return isIndex.invoke(eObject);
	}
	
	@Override
	protected String getEObjectName(EObject eObject) {
		return nameProvider.getQualifiedName(eObject);
	}

	@Inject
	private IQualifiedNameProvider nameProvider = new DefaultDeclarativeQualifiedNameProvider();
	
	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}
	
	private final PolymorphicDispatcher<Boolean> isIndex = new PolymorphicDispatcher<Boolean>("isIndex", 1, 1, Collections
			.singletonList(this));

	protected boolean isIndex(EObject obj) {
		return getEObjectName(obj)!=null;
	}

}
