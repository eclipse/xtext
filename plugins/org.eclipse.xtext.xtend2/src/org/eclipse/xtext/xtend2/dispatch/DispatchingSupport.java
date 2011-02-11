/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.dispatch;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DispatchingSupport {

	@Inject
	private FeatureOverridesService overridesService;

	@Inject
	private TypeReferences typeRefs;
	
	public Multimap<Pair<String, Integer>, JvmOperation> getDispatchMethods(JvmGenericType type) {
		Multimap<Pair<String, Integer>, JvmOperation> result = HashMultimap.create();
		collectDispatchMethods(type, result);
		return result;
	}

	protected void collectDispatchMethods(JvmGenericType type, Multimap<Pair<String, Integer>, JvmOperation> result) {
		Iterable<JvmOperation> features = filter(overridesService.getAllJvmFeatures(typeRefs.createTypeRef(type)), JvmOperation.class);
		for (JvmOperation operation : features) {
			if (isDispatchOperation(operation)) {
				final Pair<String, Integer> signatureTuple = Tuples.create(operation.getSimpleName().substring(1), operation.getParameters().size());
				result.put(signatureTuple,operation);
			}
		}
	}

	protected boolean isDispatchOperation(JvmOperation operation) {
		return !operation.getParameters().isEmpty() && !operation.isStatic()
				&& operation.getSimpleName().startsWith("_");
	}
}
