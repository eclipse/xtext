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
import java.util.NoSuchElementException;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A representation of {@link IFeatureCallArguments} that does not handle
 * {@link JvmExecutable#isVarArgs() var args} or closures at an unexpected index.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class VarArgFeatureCallArguments extends StandardFeatureCallArguments {

	public VarArgFeatureCallArguments(List<XExpression> arguments, List<JvmFormalParameter> parameters, boolean hasReceiver, ITypeReferenceOwner owner) {
		super(arguments, parameters, hasReceiver, owner);
	}
	
	@Override
	protected LightweightTypeReference internalGetParameterTypeForLambda(int idx) {
		if (idx >= arguments.size()) {
			throw new IndexOutOfBoundsException("Cannot read type for argument that is not present.");
		} else if (idx >= parameters.size()) {
			idx = parameters.size() - 1;
		}
		LightweightTypeReference result = super.internalGetParameterTypeForLambda(idx);
		return getComponentTypeIfLast(result, parameters, idx);
	}

	protected static LightweightTypeReference getComponentTypeIfLast(LightweightTypeReference type, List<JvmFormalParameter> parameter, int idx) {
		if (type != null) {
			if (idx >= parameter.size() - 1) {
				LightweightTypeReference componentType = type.getComponentType();
				if (componentType != null) {
					return componentType;
				}
			}
		}
		return type;
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
