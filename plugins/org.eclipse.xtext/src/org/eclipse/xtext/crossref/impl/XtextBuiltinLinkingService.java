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
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.crossref.ILinkingNameService;
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
	
	/**
	 * For testing purpose only
	 */
	public ILinkingScopeService getLinkingScopeService() {
		return linkingScopeService;
	}

	/**
	 * For testing purpose only
	 */
	public void setLinkingScopeService(ILinkingScopeService linkingScopeService) {
		this.linkingScopeService = linkingScopeService;
	}

	@Inject
	private ILinkingNameService linkingNameService;

	private List<EObject> getObjectsInScope(EObject context, CrossReference reference) {
		if (linkingScopeService == null)
			throw new IllegalStateException("LinkingScopeService must not be null.");
		return linkingScopeService.getObjectsInScope(context, reference);
	}

	public List<EObject> getLinkedObjects(EObject context, CrossReference ref, LeafNode text) {
		return doGetLinkedObjects(context, ref, text.getText(), true);
	}

	public List<EObject> doGetLinkedObjects(EObject context, CrossReference ref, String text, boolean exactMatch) {
		final Iterator<EObject> iter = linkingNameService.getMatches(getObjectsInScope(context, ref), ref, text, exactMatch);
		final EClass requiredType = GrammarUtil.getReferencedEClass(context.eResource(), ref);
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final List<EObject> result = new ArrayList<EObject>();
		while (iter.hasNext()) {
			final EObject candidate = iter.next();
			if (EcoreUtil2.isAssignableFrom(requiredType, candidate))
				result.add(candidate);
		}

		return result;
	}

	public List<EObject> getLinkCandidates(EObject context, CrossReference ref, String textFragment) {
		return doGetLinkedObjects(context, ref, textFragment.trim(), false);
	}

}
