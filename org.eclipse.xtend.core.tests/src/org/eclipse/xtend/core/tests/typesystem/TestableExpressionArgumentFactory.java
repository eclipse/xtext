/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionArgumentFactory;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TestableExpressionArgumentFactory extends ExpressionArgumentFactory {
	
	public IFeatureCallArguments createStandardArguments(List<XExpression> arguments,
			List<JvmFormalParameter> parameters, boolean hasReceiver, ITypeReferenceOwner owner) {
		return createArgumentsForExecutable(false, arguments, parameters, hasReceiver, owner);
	}
	public IFeatureCallArguments createVarArgArguments(List<XExpression> arguments,
			List<JvmFormalParameter> parameters, boolean hasReceiver, ITypeReferenceOwner owner) {
		return createArgumentsForExecutable(true, arguments, parameters, hasReceiver, owner);
	}
}
