/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TransientValueService implements ITransientValueService {

	protected boolean defaultValueIsSerializeable(EStructuralFeature feature) {
		if (feature instanceof EAttribute) {
			if (feature.getEType() == EcorePackage.eINSTANCE.getEString() && feature.getDefaultValue() == null)
				return false;
			return true;
		}
		return false;
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

	@Override
	public ListTransient isListTransient(EObject semanticObject, EStructuralFeature feature) {
		if (feature.isTransient() || isContainerReferenceInSameResource(semanticObject, feature))
			return ListTransient.YES;
		else
			return ListTransient.NO;
	}

	@Override
	public boolean isValueInListTransient(EObject semanticObject, int index, EStructuralFeature feature) {
		return false;
	}

	@Override
	public ValueTransient isValueTransient(EObject semanticObject, EStructuralFeature feature) {
		if (feature.isTransient() || !semanticObject.eIsSet(feature)
				|| isContainerReferenceInSameResource(semanticObject, feature)) {
			if (defaultValueIsSerializeable(feature))
				return ValueTransient.PREFERABLY;
			else
				return ValueTransient.YES;
		} else
			return ValueTransient.NO;
	}
}
