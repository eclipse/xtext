/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import static com.google.common.collect.Lists.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.scoping.featurecalls.IFeaturesForTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendField;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class InjectedExtensionMethodsFeaturesProvider implements IFeaturesForTypeProvider {
	
	@Inject
	private TypeReferences typeRefs;
	
	@Inject
	private TypeConformanceComputer typeConformanceComputer;
	
	private XtendField xtendField;
	
	public void setContext(XtendField xtendField) {
		this.xtendField = xtendField;
	}
	
	public Iterable<JvmFeature> getFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		JvmTypeReference typeReference = xtendField.getType();
		JvmType rawType = typeRefs.getRawType(typeReference);
		if (rawType instanceof JvmDeclaredType) {
			List<JvmFeature> result = newArrayList();
			Iterable<JvmFeature> features = ((JvmDeclaredType) rawType).findAllFeaturesByName(name);
			collectExtensions(hierarchy, features, result);
			return result;
		} else {
			return Collections.emptyList();
		}
	}

	protected void collectExtensions(Iterable<JvmTypeReference> hierarchy, Iterable<JvmFeature> candidates,
			List<JvmFeature> result) {
		for(JvmFeature feature: candidates) {
			if (feature instanceof JvmOperation) {
				final JvmOperation jvmOperation = (JvmOperation) feature;
				List<JvmFormalParameter> parameters = jvmOperation.getParameters();
				if (!jvmOperation.isStatic() && parameters.size()>0) {
					JvmFormalParameter parameter = parameters.get(0);
					JvmTypeReference parameterType = parameter.getParameterType();
					for(JvmTypeReference superType: hierarchy) {
						if (parameter.getParameterType() != null && isCompatibleType(superType, parameterType)) {
							result.add(feature);
							break;
						}
					}
					
				}
			}
		}
	}
	
	public Iterable<JvmFeature> getAllFeatures(JvmTypeReference reference,
			Iterable<JvmTypeReference> hierarchy) {
		JvmTypeReference typeReference = xtendField.getType();
		JvmType rawType = typeRefs.getRawType(typeReference);
		if (rawType instanceof JvmDeclaredType) {
			List<JvmFeature> result = newArrayList();
			Iterable<JvmFeature> features = ((JvmDeclaredType) rawType).getAllFeatures();
			collectExtensions(hierarchy, features, result);
			return result;
		} else {
			return Collections.emptyList();
		}
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

	public boolean isExtensionProvider() {
		return true;
	}

}
