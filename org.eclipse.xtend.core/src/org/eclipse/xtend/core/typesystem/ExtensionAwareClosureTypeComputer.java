/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import java.util.List;

import org.eclipse.xtend.core.xtend.XtendFormalParameter;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.typesystem.computation.ClosureTypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ClosureWithExpectationHelper;
import org.eclipse.xtext.xbase.typesystem.computation.ClosureWithoutExpectationHelper;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.computation.UnknownClosureTypeHelper;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExtensionAwareClosureTypeComputer extends ClosureTypeComputer {
	protected ExtensionAwareClosureTypeComputer(XClosure closure, ITypeExpectation expectation,
			ITypeComputationState state) {
		super(closure, expectation, state);
	}

	@Override
	protected ClosureWithExpectationHelper createClosureWithExpectationHelper(JvmOperation operation) {
		return new ClosureWithExpectationHelper(getClosure(), operation, getExpectation(), getState()) {
			@Override
			protected ITypeComputationState assignParameters(ITypeAssigner typeAssigner) {
				ITypeComputationState result = super.assignParameters(typeAssigner);
				addExtensions(result);
				return result;
			}
		};
	}

	@Override
	protected UnknownClosureTypeHelper createUnknownClosureTypeHelper() {
		return new UnknownClosureTypeHelper(getClosure(), getExpectation(), getState()) {
			@Override
			protected ITypeComputationState assignParameters(ITypeAssigner typeAssigner) {
				ITypeComputationState result = super.assignParameters(typeAssigner);
				addExtensions(result);
				return result;
			}
		};
	}

	@Override
	protected ClosureWithoutExpectationHelper createClosureWithoutExpectationHelper() {
		return new ClosureWithoutExpectationHelper(getClosure(), getExpectation(), getState()) {
			@Override
			protected ITypeComputationState assignParameters(ITypeAssigner typeAssigner,
					FunctionTypeReference incompleteClosureType) {
				ITypeComputationState result = super.assignParameters(typeAssigner, incompleteClosureType);
				addExtensions(result);
				return result;
			}
		};
	}
	
	protected void addExtensions(ITypeComputationState state) {
		List<JvmFormalParameter> extensionProviders = null;
		for(JvmFormalParameter parameter: getClosure().getDeclaredFormalParameters()) {
			if (parameter instanceof XtendFormalParameter && ((XtendFormalParameter) parameter).isExtension()) {
				if (extensionProviders == null)
					extensionProviders = Lists.newLinkedList();
				extensionProviders.add(parameter);
			}
		}
		if (extensionProviders != null)
			state.addExtensionsToCurrentScope(extensionProviders);
	}
}