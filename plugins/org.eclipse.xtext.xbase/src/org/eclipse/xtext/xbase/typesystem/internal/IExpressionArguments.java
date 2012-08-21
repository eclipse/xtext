/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IExpressionArguments {

	LightweightTypeReference getDeclaredType(int argumentIndex);

	int getFixedArityArgumentCount();

	boolean isVarArgs();

	boolean isExactArity();

	int getArgumentSize();

	ArrayTypeReference getVarArgType();

	boolean hasUnprocessedArguments();

	int getNextUnprocessedNextArgument();

	boolean isProcessed(int argumentIndex);

	XExpression getArgument(int argumentIndex);

	void markProcessed(int argumentIndex);

}