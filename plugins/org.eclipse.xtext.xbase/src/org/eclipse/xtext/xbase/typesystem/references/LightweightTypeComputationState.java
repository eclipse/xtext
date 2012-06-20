/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface LightweightTypeComputationState extends ITypeComputationState {

	interface LightweightFork extends ITypeComputationState.Fork {
		
		/**
		 * The given expectation will be resolved if it contains unresolved type
		 * arguments, e.g. an operation that declares two parameters of the very
		 * same type argument will yield a more detailed expectation if possible.
		 * <code>&lt;T&gt; T foo(T, T)</code> with
		 * <code>foo&lt;String&gt;(null, 'string')</code> will allow to pass the unresolved T as expectation
		 * where clients would be invoked with the better candidate 'string'.
		 */
		LightweightTypeComputationState withExpectation(LightweightTypeReference expectation);
		
		LightweightTypeComputationState withNonVoidExpectation();
		
		/**
		 * Discards the current expectation and allows to use return and throw 
		 * independently from the parent's state.
		 */
		LightweightTypeComputationState withoutExpectation();
		
		/**
		 * Transfers the available return type expectation to the immediate expectation of this
		 * computation step. 
		 */
		LightweightTypeComputationState withReturnExpectation();
		
		/**
		 * Keeps the return type expectation. Otherwise the state is free of expectations.
		 */
		LightweightTypeComputationState withoutImmediateExpectation();
	
		LightweightTypeComputationState withTypeCheckpoint();
		
	}
	
	LightweightFork fork();

	LightweightTypeComputationResult computeTypes(@Nullable XExpression expression);
	
	/**
	 * @param type the type of the element. <code>null</code> or other invalid types will be treated as error types.
	 */
	LightweightTypeComputationState assignType(JvmIdentifiableElement element, LightweightTypeReference type);
	
	LightweightTypeAssigner assignTypes();
	
	void addLocalToCurrentScope(JvmIdentifiableElement element);
	
	/**
	 * The result is never empty.
	 */
	List<LightweightTypeExpectation> getImmediateExpectations();
	
	/**
	 * The result is never empty.
	 */
	List<LightweightTypeExpectation> getReturnExpectations();
	
	/**
	 * The result is never empty.
	 */
	List<IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall);
	
	/**
	 * The result is never empty.
	 */
	List<IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall);
	
	void acceptActualType(LightweightTypeReference type);
	
	@Nullable LightweightTypeReference internalGetType(JvmIdentifiableElement element);

	// TODO implement this better, especially for instanceof in conditions
	
	void reassignType(XExpression object, LightweightTypeReference type);
	
	void discardReassignedTypes(XExpression object);
	
}
