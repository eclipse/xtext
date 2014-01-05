/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionArgumentFactory;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TestableExpressionArgumentFactory extends ExpressionArgumentFactory {
	
	public IFeatureCallArguments createStandardArguments(List<XExpression> arguments,
			List<JvmFormalParameter> parameters, boolean hasReceiver, OwnedConverter converter) {
		return createArgumentsForExecutable(false, arguments, parameters, hasReceiver, converter);
	}
	public IFeatureCallArguments createVarArgArguments(List<XExpression> arguments,
			List<JvmFormalParameter> parameters, boolean hasReceiver, OwnedConverter converter) {
		return createArgumentsForExecutable(true, arguments, parameters, hasReceiver, converter);
	}
}
