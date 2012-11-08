/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public interface ITypeComputationState {

	/**
	 * The given expectation will be resolved if it contains unresolved type
	 * arguments, e.g. an operation that declares two parameters of the very
	 * same type argument will yield a more detailed expectation if possible.
	 * <code>&lt;T&gt; T foo(T, T)</code> with
	 * <code>foo&lt;String&gt;(null, 'string')</code> will allow to pass the unresolved T as expectation
	 * where clients would be invoked with the better candidate 'string'.
	 */
	ITypeComputationState withExpectation(LightweightTypeReference expectation);
	
	void refineExpectedType(XExpression expression, LightweightTypeReference expectation);
	
	ITypeComputationState withRootExpectation(LightweightTypeReference expectation);
	
	ITypeComputationState withNonVoidExpectation();
	
	/**
	 * Transfers the available return type expectation to the actual expectation of this
	 * computation step. 
	 */
	ITypeComputationState withReturnExpectation();
	
	/**
	 * Keeps the return type expectation. Otherwise the state is free of expectations.
	 */
	ITypeComputationState withoutExpectation();

	ITypeComputationState withTypeCheckpoint();

	ITypeComputationResult computeTypes(@Nullable XExpression expression);
	
	/**
	 * @param type the type of the element. <code>null</code> or other invalid types will be treated as error types.
	 */
	ITypeComputationState assignType(JvmIdentifiableElement element, LightweightTypeReference type);
	
	ITypeAssigner assignTypes();
	
	void addLocalToCurrentScope(JvmIdentifiableElement element);
	
	/**
	 * The result is never empty.
	 */
	List<? extends ITypeExpectation> getExpectations();
	
	/**
	 * The result is never empty.
	 */
	List<? extends IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall);
	
	/**
	 * The result is never empty.
	 */
	List<? extends IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall);
	
	void acceptActualType(LightweightTypeReference type);
	
	// TODO implement this better, especially for instanceof in conditions
	
	void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type);
	
	void discardReassignedTypes(JvmIdentifiableElement refinable);

	ITypeReferenceOwner getReferenceOwner();
	
	OwnedConverter getConverter();
	
}
