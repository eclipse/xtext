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
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ObservableTypeExpectation  extends AbstractReturnAwareTypeExpectation {

	interface Observer {
		void accept(ObservableTypeExpectation expectation, JvmTypeReference actual, ConformanceHint conformanceHint);
	}
	
	private JvmTypeReference computedReference;
	private final IJvmTypeReferenceProvider expectedType;
	private final Observer observer;
	
	public ObservableTypeExpectation(IJvmTypeReferenceProvider expectedType, AbstractTypeComputationState state, boolean returnType, Observer observer) {
		super(state, returnType);
		this.expectedType = expectedType;
		this.observer = observer;
	}
	
	@Override
	public void acceptActualType(JvmTypeReference type, ConformanceHint conformanceHint) {
		observer.accept(this, type, conformanceHint);
		super.acceptActualType(type, conformanceHint);
	}

	public boolean isNoTypeExpectation() {
		return false;
	}
	
	public JvmTypeReference getExpectedType() {
		if (computedReference == null)
			computedReference = expectedType.getTypeReference();
		return computedReference;
	}

}
