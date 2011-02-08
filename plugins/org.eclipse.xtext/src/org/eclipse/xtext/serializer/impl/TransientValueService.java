/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TransientValueService implements org.eclipse.xtext.serializer.ITransientValueService {

	@Inject
	protected ITransientValueService legacy;

	protected boolean defaultValueIsSerializeable(EStructuralFeature feature) {
		// TODO: this needs a generic implementation
		if (feature instanceof EAttribute) {
			return feature.getEType() == EcorePackage.eINSTANCE.getEInt() || feature.getEType() instanceof EEnum;
		}
		return false;
	}

	public ListTransient isListTransient(EObject semanitcObject, EStructuralFeature feature) {
		if (legacy.isCheckElementsIndividually(semanitcObject, feature))
			return ListTransient.SOME;
		if (legacy.isTransient(semanitcObject, feature, -1))
			return ListTransient.YES;
		else
			return ListTransient.NO;
	}

	public boolean isValueInListTransient(EObject semanitcObject, int index, EStructuralFeature feature) {
		return legacy.isTransient(semanitcObject, feature, index);
	}

	public ValueTransient isValueTransient(EObject semanitcObject, EStructuralFeature feature) {
		if (feature.isTransient())
			return ValueTransient.YES;
		boolean isSet = semanitcObject.eIsSet(feature);
		if (defaultValueIsSerializeable(feature) && !isSet)
			return ValueTransient.PREFERABLY;
		if (legacy.isTransient(semanitcObject, feature, 0))
			return ValueTransient.YES;
		return isSet ? ValueTransient.NO : ValueTransient.YES;
	}

}
