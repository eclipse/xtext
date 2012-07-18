/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO this class should be removed
 */
@NonNullByDefault
public class ExpressionAwareUnboundTypeReference extends UnboundTypeReference {

	private XExpression expression;

	protected ExpressionAwareUnboundTypeReference(TypeReferenceOwner owner, XExpression expression, JvmTypeParameter typeParameter) {
		super(owner, typeParameter, new Object());
		this.expression = expression;
	}
	
	private ExpressionAwareUnboundTypeReference(TypeReferenceOwner owner, XExpression expression, JvmTypeParameter typeParameter, Object handle) {
		super(owner, typeParameter, handle);
		this.expression = expression;
	}
	
	public XExpression getExpression() {
		return expression;
	}
	
	@Override
	protected ExpressionAwareUnboundTypeReference createCopy(TypeReferenceOwner owner) {
		return new ExpressionAwareUnboundTypeReference(owner, expression, getTypeParameter(), getHandle());
	}
	
	@Override
	public Object getHandle() {
		return super.getHandle();
	}
	
	public void tryResolve() {
		if (internalIsResolved())
			return;
		List<LightweightBoundTypeArgument> hints = getAllHints();
		if (!hints.isEmpty()) {
			resolveWithHints(hints);
		}
	}
	
}
