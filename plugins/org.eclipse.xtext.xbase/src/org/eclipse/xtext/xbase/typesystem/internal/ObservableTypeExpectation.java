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
 */
public class ObservableTypeExpectation extends TypeExpectation {

	interface Observer {
		void accept(ObservableTypeExpectation expectation, JvmTypeReference actual, ConformanceHint conformanceHint);
	}
	
	private final Observer observer;
	
	public ObservableTypeExpectation(JvmTypeReference reference, AbstractTypeComputationState state, boolean returnType, Observer observer) {
		super(reference, state, returnType);
		this.observer = observer;
	}
	
	@Override
	public void acceptActualType(JvmTypeReference type, ConformanceHint conformanceHint) {
		observer.accept(this, type, conformanceHint);
		super.acceptActualType(type, conformanceHint);
	}

}
