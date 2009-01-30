/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Michael Clay
 * @author Sebastian Zarnekow
 * 
 */
public class DefaultLinkingService implements ILinkingService {

	@com.google.inject.Inject
	private IScopeProvider scopeProvider;

	protected IScope getScope(EObject context, EReference reference) {
		if (scopeProvider == null)
			throw new IllegalStateException("scopeProvider must not be null.");
		return scopeProvider.getScope(context, reference);
	}

	/**
	 * @return the first element returned from the injected {@link IScopeProvider} which matches the text of the passed {@link LeafNode}
	 */
	public List<EObject> getLinkedObjects(EObject context, EReference ref, LeafNode text) {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final IScope scope = getScope(context, ref);
		final Iterator<IScopedElement> iterator = scope.getAllContents().iterator();
		final String s = text.getText();
		while (iterator.hasNext()) {
			final IScopedElement element = iterator.next();
			if (s.equals(element.name()))
				return Collections.singletonList(element.element());
		}
		return Collections.emptyList();
	}

	/**
	 * @return the name of the first {@link IScopedElement} returned from the injected {@link IScopeProvider} for the passed object {@link EObject}
	 */
	public String getLinkText(EObject object, EReference reference, EObject context) {
		IScope scope = scopeProvider.getScope(context, reference);
		if (scope == null)
			return null;
		IScopedElement scopedElement = scope.getScopedElement(object);
		if (scopedElement == null)
			return null;
		return scopedElement.name();
	}

	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

}
