/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.arguments;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class VarArgsFeatureCallArgumentSlot extends StandardFeatureCallArgumentSlot {

	protected VarArgsFeatureCallArgumentSlot(StandardFeatureCallArguments arguments, int idx) {
		super(arguments, idx);
	}
	
	@Override
	public boolean isVarArg() {
		return true;
	}

	@Override
	public XExpression getArgumentExpression() {
		throw new IllegalStateException("Var args have to be queried for all expressions");
	}

	@Override
	public List<XExpression> getArgumentExpressions() {
		return arguments.arguments.subList(idx, arguments.arguments.size());
	}
	
	@Override
	public void markProcessed() {
		arguments.markProcessed(arguments.arguments.size() - 1);
	}
	
}
