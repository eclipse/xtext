/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.inject.ImplementedBy;

/**
 * Implementations of this interface decide which values are serialized during serialization. The behavior differs
 * slightly for single-value features and multi-value features, because single-value-features have an extra status:
 * "optional".
 * 
 * Transient Values must not be serialized in any case.
 * 
 * Optional Values should not be serialized, but the serializer may decide to serialize them anyway, if needed. The use
 * case for this is that if a features holds its default value, this values doesn't need to be serialized. However, the
 * grammar may require the feature to be serialized. Example: (x=INT y=INT)?; For x=1 and y=0 with 0 being y's default
 * value, 0 needs to be serialized since otherwise x can not be serialized.
 * 
 * Multi-Value-Features don't have this "optional" status, because even if their list holds a default-value, this value
 * needs to be serialized to be preserved.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(LegacyTransientValueService.class)
public interface ITransientValueService {

	enum ListTransient {
		NO, SOME, YES
	}

	enum ValueTransient {
		NO, PREFERABLY, YES
	}

	public ListTransient isListTransient(EObject semanticObject, EStructuralFeature feature);

	public boolean isValueInListTransient(EObject semanticObject, int index, EStructuralFeature feature);

	public ValueTransient isValueTransient(EObject semanticObject, EStructuralFeature feature);
}
