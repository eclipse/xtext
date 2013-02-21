/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.copyqualifiedname;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
public abstract class AbstractCopyQualifiedNameHandler extends AbstractHandler {

	@Inject
	private IResourceServiceProvider.Registry registry;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		String qualifiedName = getQualifiedName(event);
		return ClipboardUtil.copy(qualifiedName);
	}

	protected abstract String getQualifiedName(ExecutionEvent event);

	protected String getQualifiedName(EObject selectedElement) {
		if (selectedElement.eIsProxy()) {
			return null;
		}
		QualifiedName fullyQualifiedName = getFullyQualifiedName(selectedElement);
		return toString(selectedElement, fullyQualifiedName);
	}

	private QualifiedName getFullyQualifiedName(EObject selectedElement) {
		if (selectedElement == null) {
			return null;
		}
		return getQualifiedNameProvider(selectedElement).getFullyQualifiedName(selectedElement);
	}

	private String toString(EObject selectedElement, QualifiedName fullyQualifiedName) {
		if (fullyQualifiedName == null) {
			return null;
		}
		return getQualifiedNameConverter(selectedElement).toString(fullyQualifiedName);
	}

	private IQualifiedNameProvider getQualifiedNameProvider(EObject selectedElement) {
		return getService(selectedElement, IQualifiedNameProvider.class);
	}

	private IQualifiedNameConverter getQualifiedNameConverter(EObject selectedElement) {
		return getService(selectedElement, IQualifiedNameConverter.class);
	}

	private <T> T getService(EObject selectedElement, Class<T> serviceClass) {
		URI uri = selectedElement.eResource().getURI();
		return registry.getResourceServiceProvider(uri).get(serviceClass);
	}

}
