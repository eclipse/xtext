/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeReferences;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class DefaultFeaturesForTypeProvider implements IFeaturesForTypeProvider {

	@Inject
	private TypeReferences typeReferences;

	public Iterable<JvmFeature> getFeaturesByName(String name, JvmTypeReference declarator,
			TypeArgumentContext context, Iterable<JvmTypeReference> hierarchy) {
		List<JvmFeature> result = Lists.newArrayList();
		for(JvmTypeReference reference: hierarchy) { 
			JvmType rawType = typeReferences.getRawType(reference);
			if (rawType instanceof JvmDeclaredType) {
				Iterables.addAll(result, ((JvmDeclaredType) rawType).findAllFeaturesByName(name));
			}
		}
		return result;
	}
	
	public Iterable<JvmFeature> getAllFeatures(JvmTypeReference typeReference, TypeArgumentContext context,
			Iterable<JvmTypeReference> hierarchy) {
		Set<JvmFeature> result = Sets.newLinkedHashSet();
		for(JvmTypeReference reference: hierarchy) { 
			JvmType rawType = typeReferences.getRawType(reference);
			if (rawType instanceof JvmDeclaredType) {
				Iterables.addAll(result, ((JvmDeclaredType) rawType).getAllFeatures());
			}
		}
		return result;
	}
	
	public boolean isExtensionProvider() {
		return false;
	}

}
