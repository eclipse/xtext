/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.contentassist.AbstractLinkingCandidatesService;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultLinkingCandidatesService extends AbstractLinkingCandidatesService {

	@Inject
	private IScopeProvider scopeProvider;

	public Iterable<IScopedElement> getLinkingCandidates(EObject context, EReference reference) {
		final IScope candidates = scopeProvider.getScope(context, reference);
		return candidates.getAllContents();
	}
	
	/**
	 * @return the scopeService
	 */
	public IScopeProvider getScopeService() {
		return scopeProvider;
	}

	/**
	 * @param scopeService the scopeService to set
	 */
	public void setScopeService(IScopeProvider scopeService) {
		this.scopeProvider = scopeService;
	}

}
