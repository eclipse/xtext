/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString etc
 */
public class StackedUnboundParameter extends BaseUnboundTypeParameter {

	private BaseUnboundTypeParameter parent;

	public StackedUnboundParameter(BaseUnboundTypeParameter parent, StackedResolvedTypes resolvedTypes) {
		super(resolvedTypes);
		this.parent = parent;
	}

	@Override
	public XExpression getExpression() {
		return parent.getExpression();
	}

	@Override
	public JvmTypeParameter getTypeParameter() {
		return parent.getTypeParameter();
	}
	
	@Override
	public List<BoundTypeArgument> getAllHints() {
		List<BoundTypeArgument> result = parent.getAllHints();
		result.addAll(super.getAllHints());
		return result;
	}
	
	public void mergeIntoParent() {
		if (getBoundTo() != null) {
			parent.setBoundTo(getBoundTo());
		}
		parent.getHints().addAll(getHints());
		parent.getEquallyBoundHandles().addAll(getEquallyBoundHandles());
	}
	
	@Override
	public Object getHandle() {
		return parent.getHandle();
	}

}
