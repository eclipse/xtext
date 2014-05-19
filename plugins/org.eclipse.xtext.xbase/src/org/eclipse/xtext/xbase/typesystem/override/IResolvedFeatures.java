/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * The {@link IResolvedFeatures} allow to obtain the actual reachable API of a {@link JvmType}.
 * This means, it properly applies shadowing semantics and override resolution, especially
 * if type parameters and type arguments are present.
 * 
 * Instances of {@link IResolvedFeatures} are obtained via 
 * {@link IResolvedFeatures.Provider#getResolvedFeatures(JvmType)}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IResolvedFeatures {

	/**
	 * Returns all reachable features with the given {@code simpleName}.
	 * 
	 * Bound type parameters are properly considered when the override semantics are applied for
	 * these features.
	 */
	List<JvmFeature> getAllFeatures(String simpleName);
	
	/**
	 * Returns all reachable features.
	 * 
	 * Bound type parameters are properly considered when the override semantics are applied for
	 * these features.
	 */
	List<JvmFeature> getAllFeatures();

	/**
	 * Applies concretely bound type arguments to this instance of {@link IResolvedFeatures}.
	 */
	IResolvedFeatures getParameterizedView(LightweightTypeReference concrete);

	/**
	 * The Provider allows to obtain an instance of the {@link IResolvedFeatures features} for
	 * a given {@link JvmType type}.
	 */
	class Provider {
		
		@Inject
		private CommonTypeComputationServices services;
		
		public IResolvedFeatures getResolvedFeatures(JvmType type) {
			if (type instanceof JvmDeclaredType && !type.eIsProxy()) {
				return RawResolvedFeatures.getResolvedFeatures((JvmDeclaredType) type, services);
			}
			return NO_FEATURES;
		}
	}
	
	/**
	 * Convenience access to an instance that does not hold any features.
	 */
	IResolvedFeatures NO_FEATURES = new IResolvedFeatures() {
		
		public IResolvedFeatures getParameterizedView(LightweightTypeReference concrete) {
			return this;
		}
		
		public List<JvmFeature> getAllFeatures(String simpleName) {
			return Collections.emptyList();
		}
		
		public List<JvmFeature> getAllFeatures() {
			return Collections.emptyList();
		}

	};
}
