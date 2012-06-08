/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
public class RootUnboundTypeParameter extends BaseUnboundTypeParameter {

	private final XExpression expression;
	private final JvmTypeParameter typeParameter;
	private final Object handle;
	
	protected RootUnboundTypeParameter(XExpression expression, JvmTypeParameter typeParameter, 
			ResolvedTypes resolvedTypes) {
		super(resolvedTypes);
		this.expression = expression;
		this.typeParameter = typeParameter;
		this.handle = new Object();
	}

	@Override
	public XExpression getExpression() {
		return expression;
	}
	
	@Override
	public JvmTypeParameter getTypeParameter() {
		return typeParameter;
	}

	@Override
	public Object getHandle() {
		return handle;
	}

}
