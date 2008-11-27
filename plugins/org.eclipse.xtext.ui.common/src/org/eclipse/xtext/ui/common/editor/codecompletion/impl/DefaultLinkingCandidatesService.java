/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.crossref.ILinkingScopeService;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.codecompletion.AbstractLinkingCandidatesService;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultLinkingCandidatesService extends AbstractLinkingCandidatesService {

	@Inject
	private ILinkingScopeService scopeService;

	public List<EObject> getLinkingCandidates(EObject context, EReference reference) {
		final List<EObject> candidates = scopeService.getObjectsInScope(context, reference);
		final List<EObject> result = new ArrayList<EObject>();
		final Iterator<EObject> iter = candidates.iterator();
		final EClass requiredType = reference.getEReferenceType();
		while (iter.hasNext()) {
			final EObject candidate = iter.next();
			if (EcoreUtil2.isAssignableFrom(requiredType, candidate))
				result.add(candidate);
		}
		return result;
	}
	
	/**
	 * @return the scopeService
	 */
	public ILinkingScopeService getScopeService() {
		return scopeService;
	}

	/**
	 * @param scopeService the scopeService to set
	 */
	public void setScopeService(ILinkingScopeService scopeService) {
		this.scopeService = scopeService;
	}

}
