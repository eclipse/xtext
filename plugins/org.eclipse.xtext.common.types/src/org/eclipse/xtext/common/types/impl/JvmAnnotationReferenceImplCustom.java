/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmAnnotationReferenceImplCustom extends JvmAnnotationReferenceImpl {

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
