/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public interface ITypeComputationState {
	
	interface Fork {
		
		/**
		 * The given expectation will be resolved if it contains unresolved type
		 * arguments, e.g. an operation that declares two parameters of the very
		 * same type argument will yield a more detailed expectation if possible.
		 * <code>&lt;T&gt; T foo(T, T)</code> with
		 * <code>foo&lt;String&gt;(null, 'string')</code> will allow to pass the unresolved T as expectation
		 * where clients would be invoked with the better candidate 'string'.
		 */
		ITypeComputationState withExpectation(JvmTypeReference expectation);
		
		ITypeComputationState withNonVoidExpectation();
		
		/**
		 * Discards the current expectation and allows to use return and throw 
		 * independently from the parent's state.
		 */
		ITypeComputationState withoutExpectation();
		
		/**
		 * Transfers the available return type expectation to the immediate expectation of this
		 * computation step. 
		 */
		ITypeComputationState withReturnExpectation();
		
		/**
		 * Keeps the return type expectation. Otherwise the state is free of expectations.
		 */
		ITypeComputationState withoutImmediateExpectation();
	
		ITypeComputationState withTypeCheckpoint();
		
	}
	
	Fork fork();

	ITypeComputationResult computeTypes(@Nullable XExpression expression);
	
	/**
	 * @param type the type of the element. <code>null</code> or other invalid types will be treated as error types.
	 */
	ITypeComputationState assignType(JvmIdentifiableElement element, JvmTypeReference type);
	
	ITypeAssigner assignTypes();
	
	void addLocalToCurrentScope(JvmIdentifiableElement element);
	
	/**
	 * The result is never empty.
	 */
	List<? extends ITypeExpectation> getImmediateExpectations();
	
	/**
	 * The result is never empty.
	 */
	List<? extends ITypeExpectation> getReturnExpectations();
	
	/**
	 * The result is never empty.
	 */
	List<IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall);
	
	/**
	 * The result is never empty.
	 */
	List<IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall);
	
	void acceptActualType(JvmTypeReference type);
	
	@Nullable JvmTypeReference getType(JvmIdentifiableElement element);

	// TODO implement this better, especially for instanceof in conditions
	
	void reassignType(XExpression object, JvmTypeReference type);
	
	void discardReassignedTypes(XExpression object);
	
	UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter);
	
	ActualTypeArgumentCollector createTypeArgumentCollector(List<JvmTypeParameter> typeParameters, BoundTypeArgumentSource source);

	UnboundTypeParameterPreservingSubstitutor createSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping);
}
