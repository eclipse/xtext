/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.crossref.ILinkingScopeService;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.Inject;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Michael Clay
 * @author Sebastian Zarnekow
 */
public class XtextBuiltinLinkingService implements ILinkingService {

	@Inject
	private ILinkingScopeService linkingScopeService;

	private SimpleAttributeResolver<String> nameResolver;

	public XtextBuiltinLinkingService() {
		this.nameResolver = SimpleAttributeResolver.newResolver(String.class, "name");
	}

	private Iterable<EObject> getObjectsInScope(EObject context, EReference reference) {
		if (linkingScopeService == null)
			throw new IllegalStateException("LinkingScopeService must not be null.");
		return linkingScopeService.getObjectsInScope(context, reference);
	}

	public List<EObject> getLinkedObjects(EObject context, EReference ref, LeafNode text) {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final Iterable<EObject> scope = getObjectsInScope(context, ref);
		final Iterator<EObject> iter = nameResolver.getMatches(scope, text.getText()).iterator();
		final List<EObject> result = new ArrayList<EObject>();
		while (iter.hasNext()) {
			final EObject candidate = iter.next();
			if (EcoreUtil2.isAssignableFrom(requiredType, candidate))
				result.add(candidate);
		}
		return result;
	}

	public String getLinkText(EObject object, EReference reference, EObject context) {
		return this.nameResolver.getValue(object);
	}

	public ILinkingScopeService getLinkingScopeService() {
		return linkingScopeService;
	}

	public void setLinkingScopeService(ILinkingScopeService linkingScopeService) {
		this.linkingScopeService = linkingScopeService;
	}

}
