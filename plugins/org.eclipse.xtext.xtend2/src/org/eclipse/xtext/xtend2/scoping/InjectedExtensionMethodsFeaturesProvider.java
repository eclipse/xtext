/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.scoping.featurecalls.IFeaturesForTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.DeclaredDependency;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class InjectedExtensionMethodsFeaturesProvider implements IFeaturesForTypeProvider {
	
	@Inject
	private FeatureOverridesService overridesService;
	
	@Inject
	private TypeReferences typeRefs;
	
	@Inject
	private TypeConformanceComputer typeConformanceComputer;
	
	private DeclaredDependency declaredDependency;
	
	public void setContext(DeclaredDependency declaredDependency) {
		this.declaredDependency = declaredDependency;
	}
	
	public Iterable<? extends JvmFeature> getFeaturesForType(JvmTypeReference type) {
		List<JvmFeature> result = newArrayList();
		JvmTypeReference typeReference = declaredDependency.getType();
		Iterable<JvmFeature> iterable = overridesService.getAllJvmFeatures(typeReference);
		for (JvmFeature jvmFeature : iterable) {
			if (jvmFeature instanceof JvmOperation) {
				final JvmOperation jvmOperation = (JvmOperation) jvmFeature;
				List<JvmFormalParameter> parameters = jvmOperation.getParameters();
				if (!jvmOperation.isStatic() && parameters.size()>0) {
					JvmFormalParameter parameter = parameters.get(0);
					if (parameter.getParameterType() != null && isCompatibleType(type, parameter.getParameterType()))
						result.add(jvmFeature);
				}
			}
		}
		return result;
	}

	protected boolean isCompatibleType(JvmTypeReference type, JvmTypeReference declaration) {
		if (declaration.getType()==type.getType()) {
			return true;
		}
		if (declaration.getType() instanceof JvmTypeParameter) {
			boolean upperBoundSeen = false;
			for(JvmTypeConstraint constraint: ((JvmTypeParameter) declaration.getType()).getConstraints()) {
				if (constraint instanceof JvmUpperBound) {
					upperBoundSeen = true;
					if (typeConformanceComputer.isConformant(constraint.getTypeReference(), type, true))
						return true;
				}
			}
			if (!upperBoundSeen) {
				if (typeRefs.is(type, Object.class)) {
					return true;
				}
			}
		}
		return false;
	}

}
