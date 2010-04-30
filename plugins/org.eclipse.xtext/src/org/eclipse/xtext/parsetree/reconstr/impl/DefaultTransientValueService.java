/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Jan Koehnlein - support for cross-resource containment
 */
public class DefaultTransientValueService extends AbstractTransientValueService {

	public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
		return feature.isTransient() || !owner.eIsSet(feature) || isContainerReferenceInSameResource(owner, feature);
	}

	protected boolean isContainerReferenceInSameResource(EObject owner, EStructuralFeature feature) {
		if (feature instanceof EReference && ((EReference) feature).isContainer()) {
			Resource ownerResource = ((InternalEObject) owner).eDirectResource();
			// if eDirectResource is set, owner is a root element, so its container 
			// must be in another resource 
			return (ownerResource == null);
		}
		return false;
	}
}
