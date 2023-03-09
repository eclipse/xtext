/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.arguments;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StandardFeatureCallArgumentSlot implements IFeatureCallArgumentSlot {

	protected final StandardFeatureCallArguments parent;
	protected final int idx;

	protected StandardFeatureCallArgumentSlot(StandardFeatureCallArguments parent, int idx) {
		this.parent = parent;
		this.idx = idx;
	}
	
	@Override
	public boolean isVarArg() {
		return false;
	}

	@Override
	public boolean isSuperfluous() {
		return false;
	}

	@Override
	public List<XExpression> getArgumentExpressions() {
		return Collections.singletonList(getArgumentExpression());
	}

	/* @Nullable */
	@Override
	public XExpression getArgumentExpression() {
		return parent.internalGetArgument(idx);
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getDeclaredType() {
		return parent.internalGetParameterType(idx);
	}

	@Override
	public void markProcessed() {
		parent.markProcessed(idx);
	}
	
	@Override
	public String toString() {
		return String.format("%s @ %d for %s", getClass().getSimpleName(), idx, getArgumentExpressions());
	}

}
