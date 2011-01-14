/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Collections;
import java.util.List;

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
		if (feature instanceof EAttribute) {
			return feature.getEType() == EcorePackage.eINSTANCE.getEInt() || feature.getEType() instanceof EEnum;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getNonTransientValues(EObject semanticObject, EStructuralFeature multiValueFeature) {
		if (multiValueFeature.isTransient())
			return Collections.emptyList();
		return (List<T>) semanticObject.eGet(multiValueFeature);
	}

	public boolean isOptional(EObject semanticObject, EStructuralFeature singelValueFeature) {
		return semanticObject.eIsSet(singelValueFeature);
	}

	public boolean isTransient(EObject semanticObject, EStructuralFeature singelValueFeature) {
		if (singelValueFeature.isTransient())
			return true;
		if (defaultValueIsSerializeable(singelValueFeature))
			return false;
		if (legacy.isTransient(semanticObject, singelValueFeature, 0))
			return true;
		return !semanticObject.eIsSet(singelValueFeature);
	}

}
