/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * TODO JavaDoc, is this an interface?
 */
public abstract class UnboundTypeParameter extends AbstractReentrantTypeReferenceProvider {

	public void acceptHint(JvmTypeReference hint, BoundTypeArgumentSource source, Object origin, VarianceInfo declaredVariance, VarianceInfo actualVariance) {
		BoundTypeArgument boundArgument = new BoundTypeArgument(hint, source, origin, declaredVariance, actualVariance);
		acceptHint(boundArgument);
	}
	
	public abstract void acceptHint(BoundTypeArgument boundArgument);
	
	public abstract XExpression getExpression();
	
	public abstract JvmTypeParameter getTypeParameter();
	
	public abstract boolean isComputed();
	
	/*
	 * TODO should be internal
	 * @see UnboundTypeParameters#isUnboundAndEqual(UnboundTypeParameter, JvmTypeReference)
	 */
	public abstract Object getHandle();
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName());
		builder.append(" [typeParameter=");
		builder.append(getTypeParameter());
		builder.append("]");
		return builder.toString();
	}

}
