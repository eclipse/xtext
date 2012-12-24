/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
public class ExpectedTypeResolver {
	
	@Inject
	private CommonTypeComputationServices computationServices;
	
	@Inject
	private ITypeProvider typeProvider;
	
	public JvmTypeReference resolveExpectedType(final EObject context, JvmTypeReference expectedType) {
		ITypeReferenceOwner owner = new ITypeReferenceOwner() {

			@NonNull
			public CommonTypeComputationServices getServices() {
				return computationServices;
			}

			@NonNull
			public List<LightweightBoundTypeArgument> getAllHints(@NonNull Object handle) {
				throw new UnsupportedOperationException();
			}

			public void acceptHint(@NonNull Object handle,
					@NonNull LightweightBoundTypeArgument boundTypeArgument) {
				throw new UnsupportedOperationException();
			}

			@NonNull
			public ResourceSet getContextResourceSet() {
				return context.eResource().getResourceSet();
			}
			
			public boolean isResolved(@NonNull Object handle) {
				throw new UnsupportedOperationException();
			}
			
			@NonNull
			public List<JvmTypeParameter> getDeclaredTypeParameters() {
				throw new UnsupportedOperationException();
			}
		};
		TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(
				Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument> emptyMap(),
				owner);
		JvmTypeReference resolvedExpectedType = substitutor.substitute(
				new OwnedConverter(owner).toLightweightReference(expectedType)).toTypeReference();
		return resolvedExpectedType;
	}
}
