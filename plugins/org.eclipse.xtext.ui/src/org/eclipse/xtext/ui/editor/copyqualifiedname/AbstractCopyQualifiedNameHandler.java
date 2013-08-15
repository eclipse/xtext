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
import org.eclipse.emf.ecore.EObject;
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
		CopyQualifiedNameService copyQualifiedNameService = getCopyQualifiedNameService(selectedElement);
		if (copyQualifiedNameService == null) {
			return null;
		}
		return copyQualifiedNameService.getQualifiedName(selectedElement, null);
	}

	protected String getQualifiedName(EObject selectedElement, EObject context) {
		CopyQualifiedNameService copyQualifiedNameService = getCopyQualifiedNameService(selectedElement);
		if (copyQualifiedNameService == null) {
			return null;
		}
		return copyQualifiedNameService.getQualifiedName(selectedElement, context);
	}

	protected CopyQualifiedNameService getCopyQualifiedNameService(EObject selectedElement) {
		if (selectedElement == null) {
			return null;
		}
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(selectedElement.eResource().getURI());
		if (resourceServiceProvider == null) {
			return null;
		}
		return resourceServiceProvider.get(CopyQualifiedNameService.class);
	}

}