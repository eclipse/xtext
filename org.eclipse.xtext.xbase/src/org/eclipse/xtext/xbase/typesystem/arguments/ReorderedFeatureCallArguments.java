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

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Returns all arguments first, that match the given parameters.
 * Next slots will yield the shifted arguments according to the shifted parameters.
 * The last tranch of slots yields the superfluous arguments.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReorderedFeatureCallArguments extends StandardFeatureCallArguments {

	protected final List<XExpression> shiftedArguments;
	protected final List<JvmFormalParameter> shiftedParameters;

	public ReorderedFeatureCallArguments(
			List<XExpression> arguments, List<JvmFormalParameter> parameters,
			List<XExpression> shiftedArguments, List<JvmFormalParameter> shiftedParameters,
			boolean hasReceiver, ITypeReferenceOwner owner) {
		super(arguments, parameters, hasReceiver, owner);
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
		int unshiftedParameterSize = parameters.size();
		int unshiftedArgumentSize = arguments.size();
		if (idx >= unshiftedParameterSize || idx >= unshiftedArgumentSize) {
			// number of args matches number of parameters
			if (unshiftedParameterSize == unshiftedArgumentSize) {
				return shiftedArguments.get(idx - unshiftedParameterSize);
			}
			// superfluous args available
			if (unshiftedParameterSize < unshiftedArgumentSize) {
				int shiftedIdx = idx - unshiftedParameterSize;
				if (shiftedIdx >= shiftedArguments.size())
					return arguments.get(idx - shiftedArguments.size());
				return shiftedArguments.get(shiftedIdx);
			}
			// too few args available
			return shiftedArguments.get(idx - unshiftedArgumentSize);
		}
		return super.internalGetArgument(idx);
	}
	
	@Override
	protected LightweightTypeReference internalGetParameterTypeForLambda(int idx) {
		if (idx > parameters.size() + shiftedParameters.size() && idx < arguments.size() + shiftedArguments.size()) {
			return null;
		}
		return super.internalGetParameterTypeForLambda(idx);
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference internalGetParameterType(int idx) {
		JvmFormalParameter parameter = internalGetParameter(idx);
		return toLightweightTypeReference(parameter);
	}
	
	protected JvmFormalParameter internalGetParameter(int idx) {
		int unshiftedParameterSize = parameters.size();
		int unshiftedArgumentSize = arguments.size();
		if (idx >= unshiftedParameterSize || idx >= unshiftedArgumentSize) {
			// number of args matches number of parameters
			if (unshiftedParameterSize == unshiftedArgumentSize) {
				return shiftedParameters.get(idx - unshiftedParameterSize);
			}
			// superfluous args available
			if (unshiftedParameterSize < unshiftedArgumentSize) {
				int shiftedIdx = idx - unshiftedParameterSize;
				if (shiftedIdx >= shiftedArguments.size())
					return parameters.get(idx - shiftedArguments.size());
				return shiftedParameters.get(shiftedIdx);
			}
			// too few args available
			return shiftedParameters.get(idx - unshiftedArgumentSize);
		}
		return parameters.get(idx);
	}

}
