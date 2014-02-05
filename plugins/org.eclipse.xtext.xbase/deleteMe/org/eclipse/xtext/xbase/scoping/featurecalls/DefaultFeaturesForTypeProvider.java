/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typing.SynonymTypesProvider;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated
@Singleton
public class DefaultFeaturesForTypeProvider extends AbstractFeaturesForTypeProvider {

	@Inject
	private SynonymTypesProvider synonymTypesProvider;
	
	public Iterable<JvmFeature> getFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		return doGetFeaturesByName(name, declarator, hierarchy);
	}
	
	/**
	 * @param name the name of the requested feature. May be <code>null</code>.
	 * @param declarator the feature declarator. Never <code>null</code>.
	 * @param hierarchy the type hierarchy of {@code declarator}. May be explored by custom implementations for whatever purpose.
	 * @return the matching features. Never <code>null</code>.
	 */
	protected Iterable<JvmFeature> doGetFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		if (declarator == null)
			return Collections.emptyList();
		List<JvmFeature> result = Lists.newArrayList();
		List<JvmType> rawTypes = getRawTypeHelper().getAllRawTypes(declarator, null);
		for(JvmType rawType: rawTypes) {
			if (rawType instanceof JvmDeclaredType) {
				collectFeatures(name, rawType, result);
			}
		}
		// TODO : move synonym support to creation time of type references
		Iterator<JvmTypeReference> synonymesIterator = synonymTypesProvider.getSynonymTypes(declarator, false).iterator();
		while(synonymesIterator.hasNext()) {
			JvmTypeReference synonym = synonymesIterator.next();
			List<JvmType> synonymRawTypes = getRawTypeHelper().getAllRawTypes(synonym, declarator.eResource());
			for(JvmType synonymRawType: synonymRawTypes) {
				if (synonymRawType instanceof JvmDeclaredType && !rawTypes.contains(synonymRawType)) {
					collectFeatures(name, synonymRawType, result);
				}
			}
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
