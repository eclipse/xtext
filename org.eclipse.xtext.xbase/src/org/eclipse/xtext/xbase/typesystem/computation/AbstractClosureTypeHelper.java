/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.impl.XClosureImplCustom;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
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
public abstract class AbstractClosureTypeHelper implements IClosureCandidate {

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
			ExpectationTypeParameterHintCollector collector = new ResolvingTypeParameterHintCollector(expectation.getReferenceOwner(), source) {
				@Override
				protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
					LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
					if (source == BoundTypeArgumentSource.INFERRED_CONSTRAINT) {
						wrapped = getStricterConstraint(typeParameter, wrapped);
					}
					if (wrapped != null) {
						typeParameter.acceptHint(wrapped, source, getOrigin(), getExpectedVariance(), getActualVariance());	
					}
				}
			};
			collector.processPairedReferences(declared, actual);
		}
	}
	
	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		if (!closure.isExplicitSyntax()) {
			List<JvmFormalParameter> parametersToAdd = getParameters();
			InternalEList<JvmFormalParameter> targetList = (InternalEList<JvmFormalParameter>) closure.getImplicitFormalParameters();
			if (!targetList.isEmpty()) {
				// things are already available, do nothing
				return;
			}
			for(int i = 0; i < parametersToAdd.size(); i++) {
				JvmFormalParameter parameter = parametersToAdd.get(i);
				LightweightTypeReference parameterType = resolvedTypes.getActualType(parameter);
				if (parameterType == null) {
					throw new IllegalStateException("Cannot find type for parameter " + parameter.getSimpleName());
				}
				JvmTypeReference typeReference = parameterType.toTypeReference();
				parameter.setParameterType(typeReference);
				targetList.addUnique(parameter);
			}
		}
		((XClosureImplCustom) closure).setLinked(true);
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		return true;
	}
	
	@Override
	public abstract List<JvmFormalParameter> getParameters();

}
