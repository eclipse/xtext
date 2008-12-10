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
import org.eclipse.xtext.service.Inject;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Michael Clay
 * @author Sebastian Zarnekow
 */
public class XtextBuiltinLinkingService implements ILinkingService {

	@Inject
	private IScopeProvider scopeProvider;

	private SimpleAttributeResolver<String> nameResolver;

	public XtextBuiltinLinkingService() {
		this.nameResolver = SimpleAttributeResolver.newResolver(String.class, "name");
	}

	protected IScope getObjectsInScope(EObject context, EReference reference) {
		if (scopeProvider == null)
			throw new IllegalStateException("scopeProvider must not be null.");
		return scopeProvider.getScope(context, reference);
	}

	public List<EObject> getLinkedObjects(EObject context, EReference ref, LeafNode text) {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final IScope scope = getObjectsInScope(context, ref);
		final Iterator<IScopedElement> iterator = scope.getAllContents().iterator();
		final String s = text.getText();
		while (iterator.hasNext()) {
			final IScopedElement element = iterator.next();
			if (s.equals(element.name()))
				return Collections.singletonList(element.element());
		}
		return Collections.emptyList();
	}

	public String getLinkText(EObject object, EReference reference, EObject context) {
		return this.nameResolver.getValue(object);
	}

	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

}
