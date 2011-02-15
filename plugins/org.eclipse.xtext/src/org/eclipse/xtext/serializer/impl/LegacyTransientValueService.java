/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class LegacyTransientValueService extends TransientValueService {

	@Inject
	protected ITransientValueService legacy;

	@Override
	public ListTransient isListTransient(EObject semanitcObject, EStructuralFeature feature) {
		if (legacy.isCheckElementsIndividually(semanitcObject, feature))
			return ListTransient.SOME;
		if (legacy.isTransient(semanitcObject, feature, -1))
			return ListTransient.YES;
		else
			return ListTransient.NO;
	}

	@Override
	public boolean isValueInListTransient(EObject semanitcObject, int index, EStructuralFeature feature) {
		return legacy.isTransient(semanitcObject, feature, index);
	}

	@Override
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
