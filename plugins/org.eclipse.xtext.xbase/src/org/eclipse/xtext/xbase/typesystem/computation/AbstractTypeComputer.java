/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeComputationState;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractTypeComputer implements ITypeComputer {

	{
		checkIsSingelton();
	}
	
	protected final void checkIsSingelton() {
		Singleton singleton = getClass().getAnnotation(Singleton.class);
		if (singleton==null) {
			throw new IllegalStateException("The class "+getClass().getSimpleName()+" must be annotated with @Singleton annotation.");
		}
	}
	
	public void computeTypes(XExpression expression, LightweightTypeComputationState state) {
		_computeTypes(expression, state);
	}
	
	protected void _computeTypes(XExpression expression, LightweightTypeComputationState state) {
		throw new UnsupportedOperationException("Missing type computation for expression type: " + expression.eClass().getName() + " / " + state);
	}

}
