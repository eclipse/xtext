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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A representation of {@link IFeatureCallArguments} that does not handle
 * {@link JvmExecutable#isVarArgs() var args} or closures at an unexpected index.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StandardFeatureCallArguments implements IFeatureCallArguments {

	protected final List<JvmFormalParameter> parameters;
	protected final int receiverFixup;
	protected final List<XExpression> arguments;
	protected final ITypeReferenceOwner owner;
	
	protected int nextUnprocessedArgument = 0;

	public StandardFeatureCallArguments(List<XExpression> arguments, List<JvmFormalParameter> parameters, boolean hasReceiver, ITypeReferenceOwner owner) {
		this.parameters = parameters;
		this.receiverFixup = hasReceiver ? 1 : 0;
		this.arguments = arguments;
		this.owner = owner;
	}
	
	@Override
	public boolean hasUnprocessedArguments() {
		return nextUnprocessedArgument < arguments.size();
	}

	@Override
	public IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot() {
		if (!hasUnprocessedArguments()) {
			throw new NoSuchElementException();
		}
		if (nextUnprocessedArgument < parameters.size()) {
			return new StandardFeatureCallArgumentSlot(this, nextUnprocessedArgument);
		}
		return new SuperfluousFeatureCallArgumentSlot(this, nextUnprocessedArgument);
	}

	/* @Nullable */
	@Override
	public XExpression getArgument(int idx) {
		int fixedIdx = idx - receiverFixup;
		if (fixedIdx < 0) {
			return null;
		}
		return internalGetArgument(fixedIdx);
	}
	
	@Override
	public final LightweightTypeReference getDeclaredTypeForLambda(int idx) {
		int fixedIdx = idx - receiverFixup;
		if (fixedIdx < 0) {
			return null;
		}
		return internalGetParameterTypeForLambda(fixedIdx);
	}
	
	protected LightweightTypeReference internalGetParameterTypeForLambda(int idx) {
		if (idx >= parameters.size() && idx < arguments.size()) {
			return null;
		}
		return internalGetParameterType(idx);
	}

	@Override
	public int getArgumentCount() {
		return arguments.size() + receiverFixup;
	}
	
	@Override
	public boolean hasEmptyTrailingVarArg() {
		return false;
	}
	
	/* @Nullable */
	protected XExpression internalGetArgument(int idx) {
		return arguments.get(idx);
	}
	
	/* @Nullable */
	protected LightweightTypeReference internalGetParameterType(int idx) {
		JvmFormalParameter parameter = parameters.get(idx);
		return toLightweightTypeReference(parameter);
	}

	/**
	 * @param argumentIndex the external argument index.
	 */
	@Override
	public boolean isProcessed(int argumentIndex) {
		return argumentIndex - receiverFixup < nextUnprocessedArgument || argumentIndex >= getArgumentCount();
	}
	
	/**
	 * @param argumentIndex the internal argument index.
	 */
	protected void markProcessed(int argumentIndex) {
		this.nextUnprocessedArgument = Math.max(argumentIndex + 1, nextUnprocessedArgument);
	}
	
	/* @Nullable */
	protected LightweightTypeReference toLightweightTypeReference(JvmFormalParameter parameter) {
		JvmTypeReference parameterType = parameter.getParameterType();
		if (parameterType == null) {
			return null;
		}
		LightweightTypeReference result = owner.toLightweightTypeReference(parameterType);
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%s with %s", getClass().getSimpleName(), arguments);
	}
}
