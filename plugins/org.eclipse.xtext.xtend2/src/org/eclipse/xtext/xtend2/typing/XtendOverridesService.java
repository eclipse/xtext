/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.typing;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendOverridesService {
	
	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

	@Inject
	private FeatureOverridesService featureOverridesService;
	
	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;
	
	@Inject
	private TypeReferences typeReferences;
	
	public JvmOperation findOverriddenOperation(XtendFunction function) {
		final JvmParameterizedTypeReference typeRef = typeReferences
				.createTypeRef(xtend2jvmAssociations.getDirectlyInferredOperation(function).getDeclaringType());
		TypeArgumentContext typeArgumentContext = typeArgumentContextProvider.getReceiverContext(typeRef);
		JvmOperation inferredJvmOperation = xtend2jvmAssociations.getDirectlyInferredOperation(function);
		if (function.getDeclaringType().getExtends() != null || !function.getDeclaringType().getImplements().isEmpty()) {
			for (JvmOperation superOperation : allSuperOperations(function.getDeclaringType())) {
				if (superOperation.getVisibility() != JvmVisibility.PRIVATE) {
					if (featureOverridesService.isOverridden(inferredJvmOperation, superOperation, typeArgumentContext,
							false)) {
						return superOperation;
					}
				}
			}
		}
		return null;
	}
	
	protected Iterable<JvmOperation> allSuperOperations(final XtendClass xtendClass) {
		// I love Google collections
		Iterable<JvmOperation> result = filter(
				concat(transform(
						filter(concat(singleton(xtendClass.getExtends()), xtendClass.getImplements()),
								Predicates.notNull()), new Function<JvmTypeReference, Iterable<JvmFeature>>() {
							public Iterable<JvmFeature> apply(JvmTypeReference from) {
								return featureOverridesService.getAllJvmFeatures(from);
							}
						})), JvmOperation.class);
		return result;
	}
	
	public JvmTypeReference getOverriddenReturnType(XtendFunction func) {
		JvmOperation operation = findOverriddenOperation(func);
		if (operation==null)
			return null;
		return operation.getReturnType();
	}
}
