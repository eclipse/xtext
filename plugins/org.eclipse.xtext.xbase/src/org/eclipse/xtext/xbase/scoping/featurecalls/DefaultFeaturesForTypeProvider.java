/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typing.SynonymTypesProvider;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class DefaultFeaturesForTypeProvider implements IFeaturesForTypeProvider {

	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private SynonymTypesProvider synonymesProvider;

	public Iterable<JvmFeature> getFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		return doGetFeaturesByName(name, declarator, hierarchy);
	}
	
	protected Iterable<JvmFeature> doGetFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		if (declarator == null)
			return Collections.emptyList();
		List<JvmFeature> result = Lists.newArrayList();
		JvmType rawType = typeReferences.getRawType(declarator);
		if (rawType instanceof JvmDeclaredType) {
			collectFeatures(name, rawType, result);
		} else if (rawType == null) { // TODO remove special treatment of multi types and other specialized type reference implementations
			for(JvmTypeReference reference: hierarchy) {
				JvmType referenceRawType = typeReferences.getRawType(reference);
				collectFeatures(name, referenceRawType, result);
			}
			return result;
		}
		for(JvmTypeReference synonym: synonymesProvider.getSynonymTypes(declarator)) {
			JvmType synonymRawType = typeReferences.getRawType(synonym);
			collectFeatures(name, synonymRawType, result);
		}
		return result;
	}

	protected void collectFeatures(String name, JvmType rawType, List<JvmFeature> result) {
		if (rawType instanceof JvmDeclaredType) {
			if (name != null)
				Iterables.addAll(result, ((JvmDeclaredType) rawType).findAllFeaturesByName(name));
			else
				Iterables.addAll(result, ((JvmDeclaredType) rawType).getAllFeatures());
		}
	}
	
	public Iterable<JvmFeature> getAllFeatures(JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		return doGetFeaturesByName(null, declarator, hierarchy);
	}
	
	public boolean isExtensionProvider() {
		return false;
	}

}
