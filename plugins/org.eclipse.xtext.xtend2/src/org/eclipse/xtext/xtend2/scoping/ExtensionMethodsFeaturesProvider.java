/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.scoping.featurecalls.AbstractFeaturesForTypeProvider;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ExtensionMethodsFeaturesProvider extends AbstractFeaturesForTypeProvider {
	
	private JvmTypeReference extensionProvidingType;
	
	public void setContext(JvmTypeReference type) {
		this.extensionProvidingType = type;
	}
	
	public Iterable<JvmFeature> getFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		if(extensionProvidingType == null)
			return emptyList();
		List<JvmFeature> result = Lists.newArrayList();
		JvmType rawType = getTypeReferences().getRawType(extensionProvidingType);
		if (rawType instanceof JvmDeclaredType) {
			Iterable<JvmFeature> candidates = ((JvmDeclaredType) rawType).findAllFeaturesByName(name);
			collectExtensionMethods(hierarchy, candidates, result);
		}
		return result;
	}

	protected void collectExtensionMethods(Iterable<JvmTypeReference> hierarchy, Iterable<JvmFeature> candidates,
			Collection<JvmFeature> result) {
		boolean atLeastOneCandidate = false;
		for(JvmTypeReference reference: hierarchy) {
			for(JvmFeature candidate: candidates) {
				if (candidate instanceof JvmOperation) {
					JvmOperation operation = (JvmOperation) candidate;
					List<JvmFormalParameter> parameters = operation.getParameters();
					if (!operation.isStatic() && parameters.size()>0) {
						atLeastOneCandidate = true;
						JvmTypeReference parameterType = parameters.get(0).getParameterType();
						if (isSameTypeOrAssignableToUpperBound(reference, parameterType)) {
							result.add(operation);
						}
					}
				}
			}
			if (!atLeastOneCandidate)
				return;
		}
	}
	
	public Iterable<JvmFeature> getAllFeatures(JvmTypeReference typeReference,
			Iterable<JvmTypeReference> hierarchy) {
		if(extensionProvidingType == null)
			return emptyList();
		List<JvmFeature> result = newArrayList();
		JvmType rawType = getTypeReferences().getRawType(extensionProvidingType);
		if (rawType instanceof JvmDeclaredType) {
			Iterable<JvmFeature> candidates = ((JvmDeclaredType) rawType).getAllFeatures();
			collectExtensionMethods(hierarchy, candidates, result);
		}
		return result;
	}

	public boolean isExtensionProvider() {
		return true;
	}

}
