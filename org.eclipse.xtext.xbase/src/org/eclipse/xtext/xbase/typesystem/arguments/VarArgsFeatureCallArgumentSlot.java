/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.arguments;

import java.util.List;

import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class VarArgsFeatureCallArgumentSlot extends StandardFeatureCallArgumentSlot {

	protected VarArgsFeatureCallArgumentSlot(StandardFeatureCallArguments parent, int idx) {
		super(parent, idx);
	}
	
	@Override
	public boolean isVarArg() {
		return true;
	}

	@Override
	public XExpression getArgumentExpression() {
		List<XExpression> arguments = getArgumentExpressions();
		if (arguments.size() == 1) {
			return arguments.get(0);
		}
		throw new IllegalStateException("Var args have to be queried for all expressions");
	}

	@Override
	public List<XExpression> getArgumentExpressions() {
		return parent.arguments.subList(idx, parent.arguments.size());
	}
	
	@Override
	public void markProcessed() {
		parent.markProcessed(parent.arguments.size() - 1);
	}
	
}
