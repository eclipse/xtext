/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * Externalized strategy for closure type computation which allows for easier unit testing.
 * Clients will usually not alter the implementation. Public methods are mostly public 
 * for testing purpose.
 * 
 * @see XbaseTypeComputer#_computeTypes(XClosure, ITypeComputationState)
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClosureTypeComputer {

	private final XClosure closure;
	private final ITypeComputationState state;
	
	private final CommonTypeComputationServices services;
	private final FunctionTypes functionTypes;
	private final ITypeExpectation expectation;
	private AbstractClosureTypeHelper strategy;
	
	public ClosureTypeComputer(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		this.closure = closure;
		this.expectation = expectation;
		this.state = state;
		this.services = state.getReferenceOwner().getServices();
		this.functionTypes = services.getFunctionTypes();
	}
	
	public void computeTypes() {
		selectStrategy();
		strategy.computeTypes();
		state.acceptCandidate(closure, strategy);
	}
	
	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void selectStrategy() {
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null) {
			strategy = getClosureWithoutExpectationHelper();
		} else {
			JvmOperation operation = functionTypes.findImplementingOperation(expectedType);
			JvmType type = expectedType.getType();
			int closureParameterSize;
			if (closure.isExplicitSyntax()) {
				closureParameterSize = closure.getDeclaredFormalParameters().size();
			} else if (operation != null) {
				closureParameterSize = operation.getParameters().size();
			} else {
				closureParameterSize = 1;
			}
			if (operation == null || operation.getParameters().size() != closureParameterSize || type == null) {
				strategy = getClosureWithoutExpectationHelper();
			} else {
				strategy = createClosureWithExpectationHelper(operation);
			}
		}
		
	}

	protected AbstractClosureTypeHelper getClosureWithoutExpectationHelper() {
		if (functionTypes.isFunctionAndProcedureAvailable(expectation.getReferenceOwner()))
			return createClosureWithoutExpectationHelper();
		return createUnknownClosureTypeHelper();
	}

	protected ClosureWithExpectationHelper createClosureWithExpectationHelper(JvmOperation operation) {
		return new ClosureWithExpectationHelper(closure, operation, expectation, state);
	}
	
	protected UnknownClosureTypeHelper createUnknownClosureTypeHelper() {
		return new UnknownClosureTypeHelper(closure, expectation, state);
	}

	protected ClosureWithoutExpectationHelper createClosureWithoutExpectationHelper() {
		return new ClosureWithoutExpectationHelper(closure, expectation, state);
	}

	protected XClosure getClosure() {
		return closure;
	}
	
	protected ITypeExpectation getExpectation() {
		return expectation;
	}
	
	protected ITypeComputationState getState() {
		return state;
	}
	
	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	/* @Nullable */
	public FunctionTypeReference getExpectedClosureType() {
		if (strategy == null)
			selectStrategy();
		return strategy.getExpectedClosureType();
	}

	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	/* @Nullable */
	public JvmOperation getOperation() {
		if (strategy == null)
			selectStrategy();
		return strategy.getOperation();
	}
}
