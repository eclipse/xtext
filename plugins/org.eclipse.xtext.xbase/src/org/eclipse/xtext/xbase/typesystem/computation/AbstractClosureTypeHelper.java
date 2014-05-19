/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ExpectationTypeParameterHintCollector;

/**
 * Base strategy to compute the type of lambda expressions.
 *
 * @noextend This class is not intended to be subclassed by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractClosureTypeHelper {

	private final XClosure closure;
	private final ITypeComputationState state;
	private final CommonTypeComputationServices services;
	private final ITypeExpectation expectation;
	
	protected AbstractClosureTypeHelper(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		this.closure = closure;
		this.expectation = expectation;
		this.state = state;
		this.services = state.getReferenceOwner().getServices();
	}
	
	protected ITypeComputationState getState() {
		return state;
	}
	
	protected ITypeExpectation getExpectation() {
		return expectation;
	}
	
	protected XClosure getClosure() {
		return closure;
	}
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected abstract void computeTypes();

	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	/* @Nullable */
	public abstract FunctionTypeReference getExpectedClosureType();

	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	/* @Nullable */
	public abstract JvmOperation getOperation();

	protected void deferredBindTypeArgument(/* @Nullable */ LightweightTypeReference declared, LightweightTypeReference actual, final BoundTypeArgumentSource source) {
		if (declared != null) { 
			// TODO double check other clients of the ExpectationTypeParameterHintCollector
			// It may be possible / necessary to use the very same implementation instead of anonymous 
			// specializations or it may be possible that this specialization is no longer necessary.
			ExpectationTypeParameterHintCollector collector = new ExpectationTypeParameterHintCollector(expectation.getReferenceOwner()) {
				
				class UnboundParameterizedTypeReferencePreserver extends DeferredParameterizedTypeReferenceTraverser {
					@Override
					public void doVisitUnboundTypeReference(UnboundTypeReference reference,
							ParameterizedTypeReference declaration) {
						if (reference.internalIsResolved() || getOwner().isResolved(reference.getHandle())) {
							reference.tryResolve();
							outerVisit(reference, declaration);
						} else {
							addHint(reference, declaration);
						}
					}
				}
				class UnboundArrayTypeReferencePreserver extends DeferredArrayTypeReferenceTraverser {
					@Override
					public void doVisitUnboundTypeReference(UnboundTypeReference reference,
							ArrayTypeReference declaration) {
						if (reference.internalIsResolved() || getOwner().isResolved(reference.getHandle())) {
							reference.tryResolve();
							outerVisit(reference, declaration);
						} else {
							addHint(reference, declaration);
						}
					}
				}
				
				@Override
				protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
					LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
					if (source == BoundTypeArgumentSource.INFERRED_CONSTRAINT) {
						wrapped = getStricterConstraint(typeParameter, wrapped);
					}
					typeParameter.acceptHint(wrapped, source, getOrigin(), getExpectedVariance(), getActualVariance());
				}
				
				@Override
				protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
					return new UnboundParameterizedTypeReferencePreserver();
				}
				@Override
				protected ArrayTypeReferenceTraverser createArrayTypeReferenceTraverser() {
					return new UnboundArrayTypeReferencePreserver();
				}
			};
			collector.processPairedReferences(declared, actual);
		}
	}

}
