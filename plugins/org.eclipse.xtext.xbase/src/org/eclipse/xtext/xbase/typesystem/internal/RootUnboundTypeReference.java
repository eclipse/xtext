/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class RootUnboundTypeReference extends UnboundTypeReference {

	private XExpression expression;

	protected RootUnboundTypeReference(TypeReferenceOwner owner, XExpression expression, JvmTypeParameter typeParameter) {
		super(owner, typeParameter, new Object());
		this.expression = expression;
	}
	
	public XExpression getExpression() {
		return expression;
	}
	
	@Override
	public Object getHandle() {
		return super.getHandle();
	}
	
}
