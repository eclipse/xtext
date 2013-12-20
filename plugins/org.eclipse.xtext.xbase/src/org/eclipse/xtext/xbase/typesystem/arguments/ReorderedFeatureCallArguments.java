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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * Returns all arguments first, that match the given parameters.
 * Next slots will yield the shifted arguments according to the shifted parameters.
 * The last tranch of slots yields the superfluous arguments.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ReorderedFeatureCallArguments extends StandardFeatureCallArguments {

	protected final List<XExpression> shiftedArguments;
	protected final List<JvmFormalParameter> shiftedParameters;

	public ReorderedFeatureCallArguments(
			List<XExpression> arguments, List<JvmFormalParameter> parameters,
			List<XExpression> shiftedArguments, List<JvmFormalParameter> shiftedParameters,
			boolean hasReceiver, OwnedConverter converter) {
		super(arguments, parameters, hasReceiver, converter);
		this.shiftedArguments = shiftedArguments;
		this.shiftedParameters = shiftedParameters;
	}
	
	@Override
	public boolean hasUnprocessedArguments() {
		return nextUnprocessedArgument < arguments.size() + shiftedArguments.size();
	}
	
	@Override
	public IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot() {
		if (!hasUnprocessedArguments()) {
			throw new NoSuchElementException();
		}
		if (nextUnprocessedArgument >= parameters.size() && nextUnprocessedArgument - parameters.size() < shiftedParameters.size()) {
			return new StandardFeatureCallArgumentSlot(this, nextUnprocessedArgument);
		}
		return super.getNextUnprocessedArgumentSlot();
	}
	
	@Override
	public int getArgumentCount() {
		return super.getArgumentCount() + shiftedArguments.size();
	}
	
	@Override
	public XExpression internalGetArgument(int idx) {
		if (idx >= parameters.size()) {
			if (idx >= shiftedParameters.size() + parameters.size()) {
				return arguments.get(idx - shiftedParameters.size());
			}
			return shiftedArguments.get(idx - parameters.size());
		}
		if (idx>=arguments.size())
			return null;
		return arguments.get(idx);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference internalGetParameterType(int idx) {
		if (idx >= parameters.size()) {
			JvmFormalParameter parameter = shiftedParameters.get(idx - parameters.size());
			return toLightweightTypeReference(parameter);
		}
		JvmFormalParameter parameter = parameters.get(idx);
		return toLightweightTypeReference(parameter);
	}

}
