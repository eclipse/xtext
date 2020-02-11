/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

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
	public ListTransient isListTransient(EObject semanticObject, EStructuralFeature feature) {
		if (legacy.isCheckElementsIndividually(semanticObject, feature))
			return ListTransient.SOME;
		if (legacy.isTransient(semanticObject, feature, -1))
			return ListTransient.YES;
		else
			return ListTransient.NO;
	}

	@Override
	public boolean isValueInListTransient(EObject semanticObject, int index, EStructuralFeature feature) {
		return legacy.isTransient(semanticObject, feature, index);
	}

	@Override
	public ValueTransient isValueTransient(EObject semanticObject, EStructuralFeature feature) {
		if (feature.isTransient())
			return ValueTransient.YES;
		boolean isSet = semanticObject.eIsSet(feature);
		if (defaultValueIsSerializeable(feature) && !isSet)
			return ValueTransient.PREFERABLY;
		if (legacy.isTransient(semanticObject, feature, 0))
			return ValueTransient.YES;
		return isSet ? ValueTransient.NO : ValueTransient.YES;
	}

}
