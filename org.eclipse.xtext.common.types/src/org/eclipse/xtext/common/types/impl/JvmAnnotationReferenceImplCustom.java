/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmAnnotationReferenceImplCustom extends JvmAnnotationReferenceImpl {

	@Override
	public EObject eResolveProxy(InternalEObject proxy) {
		Resource resource = eResource();
		if (resource instanceof IJavaSchemeUriResolver) {
			EObject result = ((IJavaSchemeUriResolver) resource).resolveJavaObjectURIProxy(proxy, this);
			if (result != null)
				return result;
		}
		return super.eResolveProxy(proxy);
	}
	
	@Override
	public EList<JvmAnnotationValue> getValues() {
		EList<JvmAnnotationValue> explicitValues = getExplicitValues();
		List<JvmOperation> operations = Lists.newArrayList(getAnnotation().getDeclaredOperations());
		if (operations.size() <= explicitValues.size()) {
			return ECollections.unmodifiableEList(explicitValues);
		}
		Set<JvmOperation> seenOperations = Sets.newHashSetWithExpectedSize(operations.size());
		BasicEList<JvmAnnotationValue> result = new BasicEList<JvmAnnotationValue>(operations.size());
		for(JvmAnnotationValue value: explicitValues) {
			seenOperations.add(value.getOperation());
			result.add(value);
		}
		for(JvmOperation operation: operations) {
			if (seenOperations.add(operation)) {
				JvmAnnotationValue defaultValue = operation.getDefaultValue();
				if (defaultValue != null) {
					result.add(defaultValue);
				}
			}
		}
		return ECollections.unmodifiableEList(result);
	}
	
}
