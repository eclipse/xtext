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
import org.eclipse.emf.index.resource.impl.ResourceIndexerImpl;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class DefaultDeclarativeResourceIndexer extends ResourceIndexerImpl {

	private final PolymorphicDispatcher<Boolean> isIndex = new PolymorphicDispatcher<Boolean>("isIndex", 1, 1, Collections
			.singletonList(this));

	private final PolymorphicDispatcher<String> getDisplayName = new PolymorphicDispatcher<String>("getDisplayName", 1, 1, Collections
			.singletonList(this), new PolymorphicDispatcher.ErrorHandler<String>() {

		public String handle(Object[] params, Throwable throwable) {
			return getEObjectName((EObject) params[0]);
		}
	});
	
	protected boolean isIndexElement(EObject element) {
		return isIndex.invoke(element);
	};
	
	protected boolean isIndex(EObject element) {
		return getEObjectDisplayName(element) != null;
	};

	@Override
	protected String getEObjectName(EObject eObject) {
		return nameProvider.getQualifiedName(eObject);
	}

	@Override
	protected String getEObjectDisplayName(EObject eObject) {
		return getDisplayName.invoke(eObject);
	}
	
	@Inject
	private IQualifiedNameProvider nameProvider = new DefaultDeclarativeQualifiedNameProvider();
	
	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

}
