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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

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
	protected final OwnedConverter converter;
	
	protected int nextUnprocessedArgument = 0;

	public StandardFeatureCallArguments(List<XExpression> arguments, List<JvmFormalParameter> parameters, boolean hasReceiver, OwnedConverter converter) {
		this.parameters = parameters;
		this.receiverFixup = hasReceiver ? 1 : 0;
		this.arguments = arguments;
		this.converter = converter;
	}
	
	public boolean hasUnprocessedArguments() {
		return nextUnprocessedArgument < arguments.size();
	}

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
	public XExpression getArgument(int idx) {
		return internalGetArgument(idx - receiverFixup);
	}
	
	public int getArgumentCount() {
		return arguments.size() + receiverFixup;
	}
	
	public boolean hasEmptyTrailingVarArg() {
		return false;
	}
	
	/* @Nullable */
	protected XExpression internalGetArgument(int idx) {
		if (idx < 0)
			return null;
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
		LightweightTypeReference result = converter.toLightweightReference(parameterType);
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%s with %s", getClass().getSimpleName(), arguments);
	}
}
