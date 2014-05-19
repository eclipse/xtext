/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.arguments;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AssignmentFeatureCallArguments implements IFeatureCallArguments, IFeatureCallArgumentSlot {

	private XExpression expression;
	private LightweightTypeReference type;
	private boolean processed = false;
	
	public AssignmentFeatureCallArguments(XExpression expression, /* @Nullable */ LightweightTypeReference type) {
		this.expression = expression;
		this.type = type;
	}
	
	public boolean hasUnprocessedArguments() {
		return !processed;
	}

	public IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot() {
		if (hasUnprocessedArguments())
			return this;
		throw new NoSuchElementException();
	}

	public XExpression getArgument(int idx) {
		return expression;
	}

	public int getArgumentCount() {
		return 1;
	}

	public boolean isProcessed(int argumentIndex) {
		return processed;
	}

	public boolean isVarArg() {
		return false;
	}

	public boolean isSuperfluous() {
		return false;
	}

	public List<XExpression> getArgumentExpressions() {
		return Collections.singletonList(expression);
	}

	public XExpression getArgumentExpression() {
		return expression;
	}

	/* @Nullable */
	public LightweightTypeReference getDeclaredType() {
		return type;
	}

	public void markProcessed() {
		this.processed = true;
	}
	
	public boolean hasEmptyTrailingVarArg() {
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("AssignmentFeatureCallArguments for %s [processed = %s]", expression, String.valueOf(processed));
	}

}
