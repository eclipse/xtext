/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class DelegatingTypeExpectation extends AbstractReturnAwareTypeExpectation {

	private final AbstractTypeExpectation delegate;

	protected DelegatingTypeExpectation(AbstractTypeExpectation delegate, AbstractTypeComputationState state, boolean returnType) {
		super(state, returnType);
		this.delegate = delegate;
	}

	public JvmTypeReference getExpectedType() {
		return delegate.getExpectedType();
	}

	public boolean isNoTypeExpectation() {
		return delegate.isNoTypeExpectation();
	}
	
	@Override
	public void acceptActualType(JvmTypeReference type, ConformanceHint conformanceHint) {
		super.acceptActualType(type, conformanceHint);
		delegate.acceptActualType(type, conformanceHint);
	}

}
