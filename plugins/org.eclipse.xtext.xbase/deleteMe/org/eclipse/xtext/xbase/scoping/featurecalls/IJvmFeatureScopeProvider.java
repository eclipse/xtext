/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Function;
import com.google.inject.ImplementedBy;

/**
 * Provides a feature scope for a type, based on the type hierarchy.
 * It also allows to add additional secondary elements, it sorts 
 * invalid elements out and adds it to the end of the scope hierarchy,
 * and it allows to apply lower prioritized, sugared versions of the
 * {@link JvmFeatureDescription}s contained in the provided Scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated
@ImplementedBy(JvmFeatureScopeProvider.class)
public interface IJvmFeatureScopeProvider {

	static class FeatureScopeDescription {

		private final JvmTypeReference receiverType;
		private final Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> contextFactory;
		private final IJvmFeatureDescriptionProvider descriptionProvider;

		public FeatureScopeDescription(
				JvmTypeReference receiverType,
				Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> contextFactory,
				IJvmFeatureDescriptionProvider descriptionProvider) {
					this.receiverType = receiverType;
					this.contextFactory = contextFactory;
					this.descriptionProvider = descriptionProvider;
		}

		public JvmTypeReference getReceiverType() {
			return receiverType;
		}

		public Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> getContextFactory() {
			return contextFactory;
		}

		public IJvmFeatureDescriptionProvider getDescriptionProvider() {
			return descriptionProvider;
		}

		@Override
		public String toString() {
			return "FeatureScopeDescription [receiverType=" + receiverType + ", descriptionProvider="
					+ descriptionProvider + "]";
		}
		
	}
	
	/**
	 * <p>
	 * Provides the feature scope for a given {@link JvmTypeReference}, using the given {@link IJvmFeatureDescriptionProvider}.
	 * </p><p>
	 * It traverses the type hierarchy of the given {@link JvmTypeReference} for each
	 * {@link IJvmFeatureDescriptionProvider} passed to this method subsequent in the order they are provided.
	 * 
	 * For a sugared scope, you'd typical pass in two {@link IJvmFeatureDescriptionProvider}s the first one will create the primary features,
	 * the second will create sugared elements. 
	 * </p><p>
	 * {@link JvmFeatureDescription}s marked as invalid {@link JvmFeatureDescription#isValid()}, will be sorted last (even after sugar). This ensures that
	 * it is shadowed by valid elements and can be filtered out if not needed.
	 * </p>
	 * @param featureScopeDescriptions the description of the feature scopes whose contents should be provided.
	 */
	public JvmFeatureScope createFeatureScope(
			IScope parent, 
			List<FeatureScopeDescription> featureScopeDescriptions);
}
