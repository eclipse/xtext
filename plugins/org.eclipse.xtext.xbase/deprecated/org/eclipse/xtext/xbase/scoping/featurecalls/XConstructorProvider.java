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

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
@Singleton
public class XConstructorProvider extends AbstractFeaturesForTypeProvider {

	public boolean isExtensionProvider() {
		return false;
	}

	public Iterable<JvmFeature> getFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		return doGetFeatures(name, declarator, hierarchy);
	}

	public Iterable<JvmFeature> getAllFeatures(JvmTypeReference declarator, Iterable<JvmTypeReference> hierarchy) {
		return doGetFeatures(null, declarator, hierarchy);
	}
	
	/**
	 * @param name the name of the requested feature. May be <code>null</code>.
	 * @param declarator the feature declarator. Never <code>null</code>.
	 * @param hierarchy the type hierarchy of {@code declarator}. May be explored by custom implementations for whatever purpose.
	 * @return the matching features. Never <code>null</code>.
	 */
	public Iterable<JvmFeature> doGetFeatures(String name, JvmTypeReference declarator, Iterable<JvmTypeReference> hierarchy) {
		if (declarator != null && (name == null || "this".equals(name) || "super".equals(name))) {
			List<JvmType> rawTypes = getRawTypeHelper().getAllRawTypes(declarator, null);
			List<JvmFeature> result = Lists.newArrayList();
			for(JvmType rawType: rawTypes) {
				if (rawType instanceof JvmDeclaredType) {
					if (name == null || "this".equals(name)) {
						collectConstructors((JvmDeclaredType) rawType, result);
					} 
					if (name == null || "super".equals(name)) {
						if (rawType instanceof JvmGenericType) {
							JvmTypeReference extendedClass = ((JvmGenericType) rawType).getExtendedClass();
							List<JvmType> rawSuperTypes = getRawTypeHelper().getAllRawTypes(extendedClass, null);
							for(JvmType rawSuperType: rawSuperTypes) {
								if (rawSuperType instanceof JvmDeclaredType) {
									collectConstructors((JvmDeclaredType) rawSuperType, result);
								}
							}
						}
					}
				}
			}
			return result;
		}
		return Collections.emptyList();
	}
	
	protected void collectConstructors(JvmDeclaredType rawType, List<JvmFeature> result) {
		for(JvmMember member: rawType.getMembers()) {
			if (member instanceof JvmConstructor) {
				result.add((JvmConstructor)member);
			}
		}
	}

}
