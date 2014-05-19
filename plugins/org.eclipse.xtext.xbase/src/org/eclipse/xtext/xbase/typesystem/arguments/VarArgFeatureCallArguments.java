/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.arguments;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * A representation of {@link IFeatureCallArguments} that does not handle
 * {@link JvmExecutable#isVarArgs() var args} or closures at an unexpected index.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class VarArgFeatureCallArguments extends StandardFeatureCallArguments {

	public VarArgFeatureCallArguments(List<XExpression> arguments, List<JvmFormalParameter> parameters, boolean hasReceiver, OwnedConverter converter) {
		super(arguments, parameters, hasReceiver, converter);
	}
	
	@Override
	public IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot() {
		if (!hasUnprocessedArguments()) {
			throw new NoSuchElementException();
		}
		if (nextUnprocessedArgument < parameters.size() - 1) {
			return new StandardFeatureCallArgumentSlot(this, nextUnprocessedArgument);
		}
		return new VarArgsFeatureCallArgumentSlot(this, nextUnprocessedArgument);
	}
	
	@Override
	public boolean hasEmptyTrailingVarArg() {
		return arguments.size() < parameters.size();
	}
	
}
