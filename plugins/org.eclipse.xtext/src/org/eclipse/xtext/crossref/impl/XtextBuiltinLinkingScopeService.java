/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextBuiltinLinkingScopeService extends AbstractLinkingScopeService {

	/* Returns all EObjects of all Resources of the ResourceSet of a given context.
	 * @see org.eclipse.xtext.crossref.ILinkingScopeService#getObjectsInScope(org.eclipse.emf.ecore.EObject)
	 */
	public List<EObject> getObjectsInScope(EObject context) {
		List<EObject> result = new ArrayList<EObject>();

		TreeIterator<Object> iter = EcoreUtil.getAllContents(context.eResource().getResourceSet(), false);
		while (iter.hasNext()) {
			Object o = iter.next();
			if (o instanceof EObject)
				result.add((EObject) o);
		}
		return result;		
	}
}
