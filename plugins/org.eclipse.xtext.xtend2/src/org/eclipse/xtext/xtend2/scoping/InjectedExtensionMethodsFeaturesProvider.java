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

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.scoping.featurecalls.AbstractFeaturesForTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendField;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class InjectedExtensionMethodsFeaturesProvider extends AbstractFeaturesForTypeProvider {
	
	private XtendField xtendField;
	
	public void setContext(XtendField xtendField) {
		this.xtendField = xtendField;
	}
	
	public Iterable<JvmFeature> getFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		JvmTypeReference typeReference = xtendField.getType();
		List<JvmType> rawTypes = getRawTypeHelper().getAllRawTypes(typeReference, xtendField.eResource());
		List<JvmFeature> result = newArrayList();
		for(JvmType rawType: rawTypes) {
			if (rawType instanceof JvmDeclaredType) {
				Iterable<JvmFeature> features = ((JvmDeclaredType) rawType).findAllFeaturesByName(name);
				collectExtensions(hierarchy, features, result);
			}
		}
		return result;
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
						if (parameter.getParameterType() != null && isSameTypeOrAssignableToUpperBound(superType, parameterType)) {
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
		List<JvmType> rawTypes = getRawTypeHelper().getAllRawTypes(typeReference, xtendField.eResource());
		List<JvmFeature> result = newArrayList();
		for(JvmType rawType: rawTypes) {
			if (rawType instanceof JvmDeclaredType) {
				Iterable<JvmFeature> features = ((JvmDeclaredType) rawType).getAllFeatures();
				collectExtensions(hierarchy, features, result);
			}
		}
		return result;
	}
	
//	protected boolean isCompatibleType(JvmTypeReference type, JvmTypeReference declaration) {
//		if (declaration.getType()==type.getType()) {
//			return true;
//		}
//		if (declaration.getType() instanceof JvmTypeParameter) {
//			boolean upperBoundSeen = false;
//			for(JvmTypeConstraint constraint: ((JvmTypeParameter) declaration.getType()).getConstraints()) {
//				if (constraint instanceof JvmUpperBound) {
//					upperBoundSeen = true;
//					if (getTypeConformanceComputer().isConformant(constraint.getTypeReference(), type, true))
//						return true;
//				}
//			}
//			if (!upperBoundSeen) {
//				if (getTypeReferences().is(type, Object.class)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	public boolean isExtensionProvider() {
		return true;
	}

}
