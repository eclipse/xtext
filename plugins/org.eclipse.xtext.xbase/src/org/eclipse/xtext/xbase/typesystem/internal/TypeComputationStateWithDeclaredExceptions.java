/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TypeComputationStateWithDeclaredExceptions extends AbstractStackedTypeComputationState {

	protected TypeComputationStateWithDeclaredExceptions(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession, DefaultReentrantTypeResolver reentrantTypeResolver,
			AbstractTypeComputationState parent, List<JvmType> declaredExceptions) {
		super(resolvedTypes, featureScopeSession, reentrantTypeResolver, parent);
		this.declaredExceptions = declaredExceptions;
	}

	private List<JvmType> declaredExceptions;

	@Override
	public List<JvmType> getDeclaredExceptions() {
		return declaredExceptions;
	}
}
