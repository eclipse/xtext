/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class OperationBodyComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public OperationBodyComputationState(TypeResolution typeResolution, JvmOperation operation,
			LogicalContainerAwareReentrantTypeResolver reentrantTypeResolver) {
		super(typeResolution, operation, reentrantTypeResolver);
	}

	@Override
	protected JvmOperation getMember() {
		return (JvmOperation) super.getMember();
	}

	@Override
	protected List<ITypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		JvmTypeReference type = getMember().getReturnType();
		ITypeExpectation result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		return Collections.singletonList(result);
	}
}
