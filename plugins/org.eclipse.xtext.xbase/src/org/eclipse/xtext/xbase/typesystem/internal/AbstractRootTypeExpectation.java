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
public abstract class AbstractRootTypeExpectation extends AbstractTypeExpectation {

	public AbstractRootTypeExpectation(AbstractTypeComputationState state) {
		super(state);
	}
	
	public void acceptActualType(JvmTypeReference type, ConformanceHint hint) {
		getState().acceptType(this, type, hint, true);
		getState().acceptType(this, type, hint, false);
	}

}
