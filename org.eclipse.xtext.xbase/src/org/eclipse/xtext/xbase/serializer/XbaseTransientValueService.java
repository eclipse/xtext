/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.serializer.sequencer.LegacyTransientValueService;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseTransientValueService extends LegacyTransientValueService {

	@Override
	public ValueTransient isValueTransient(EObject semanticObject, EStructuralFeature feature) {
		if (feature == TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT) {
			return ValueTransient.YES;
		}
		return super.isValueTransient(semanticObject, feature);
	}
}
