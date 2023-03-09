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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReorderedVarArgFeatureCallArguments extends ReorderedFeatureCallArguments {

	public ReorderedVarArgFeatureCallArguments(List<XExpression> arguments, List<JvmFormalParameter> parameters,
			List<XExpression> shiftedArguments, List<JvmFormalParameter> shiftedParameters, boolean hasReceiver,
			ITypeReferenceOwner owner) {
		super(arguments, parameters, shiftedArguments, shiftedParameters, hasReceiver, owner);
	}
	
	@Override
	public IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot() {
		if (!hasUnprocessedArguments()) {
			throw new NoSuchElementException();
		}
		if (nextUnprocessedArgument >= parameters.size()) {
			if (nextUnprocessedArgument < arguments.size()) {
				throw new IllegalStateException();
			}
			return new StandardFeatureCallArgumentSlot(this, nextUnprocessedArgument); 
		}
		if (nextUnprocessedArgument == parameters.size() - 1 && nextUnprocessedArgument < arguments.size()) {
			return new VarArgsFeatureCallArgumentSlot(this, nextUnprocessedArgument);
		}
		return new StandardFeatureCallArgumentSlot(this, nextUnprocessedArgument);
	}
	
	@Override
	public XExpression internalGetArgument(int idx) {
		if (idx >= arguments.size()) {
			return shiftedArguments.get(idx - arguments.size());
		}
		return arguments.get(idx);
	}
	
	@Override
	protected LightweightTypeReference internalGetParameterTypeForLambda(int idx) {
		LightweightTypeReference result = internalGetParameterType(idx);
		return VarArgFeatureCallArguments.getComponentTypeIfLast(result, parameters, idx);
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference internalGetParameterType(int idx) {
		if (idx >= arguments.size()) {
			// idx is the index of the arguments thus idx - arguments.size to get
			// the shifted index
			JvmFormalParameter parameter = shiftedParameters.get(idx - arguments.size());
			return toLightweightTypeReference(parameter);
		}
		if (idx >= parameters.size()) {
			idx = parameters.size() - 1;
		}
		JvmFormalParameter parameter = parameters.get(idx);
		return toLightweightTypeReference(parameter);
	}
	
	@Override
	public boolean hasEmptyTrailingVarArg() {
		return arguments.size() < parameters.size();
	}
}
