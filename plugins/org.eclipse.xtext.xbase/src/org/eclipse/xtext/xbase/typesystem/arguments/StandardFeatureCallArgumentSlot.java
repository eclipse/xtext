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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class StandardFeatureCallArgumentSlot implements IFeatureCallArgumentSlot {

	protected final StandardFeatureCallArguments arguments;
	protected final int idx;

	protected StandardFeatureCallArgumentSlot(StandardFeatureCallArguments arguments, int idx) {
		this.arguments = arguments;
		this.idx = idx;
	}
	
	public boolean isVarArg() {
		return false;
	}

	public boolean isSuperfluous() {
		return false;
	}

	public List<XExpression> getArgumentExpressions() {
		return Collections.singletonList(getArgumentExpression());
	}

	public XExpression getArgumentExpression() {
		return arguments.doGetArgument(idx);
	}

	public LightweightTypeReference getDeclaredType() {
		JvmFormalParameter parameter = arguments.getParameters().get(idx);
		return arguments.toLightweightTypeReference(parameter);
	}

	public void markProcessed() {
		arguments.markProcessed(idx);
	}

}
