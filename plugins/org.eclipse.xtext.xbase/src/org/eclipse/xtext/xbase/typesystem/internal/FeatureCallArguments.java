/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureCallArguments implements IFeatureCallArguments {

	private int nextArgument = 0;
	private int fixedArityArgumentCount;
	private List<XExpression> arguments;
	private boolean varArgs;
	private List<JvmFormalParameter> parameters;
	private OwnedConverter converter;
	private final int argumentSizeFixup;
	
	public FeatureCallArguments(AbstractLinkingCandidate<? extends XExpression> candidate) {
		int fixedArityParameterCount = 0;
		varArgs = false;
		JvmIdentifiableElement feature = candidate.getFeature();
		if (feature instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) feature;
			parameters = executable.getParameters();
			varArgs = executable.isVarArgs();
			fixedArityParameterCount = varArgs ? parameters.size() - 1 : parameters.size();
		}
		arguments = candidate.getArguments();
		converter = candidate.getState().getConverter();
		argumentSizeFixup = candidate.hasReceiver() ? 1 : 0;
		nextArgument = argumentSizeFixup;
		fixedArityArgumentCount = Math.min(fixedArityParameterCount, arguments.size()) + argumentSizeFixup;
	}
	
	protected int getArgumentSizeFixup() {
		return argumentSizeFixup;
	}
	
	protected List<JvmFormalParameter> getParameters() {
		return parameters;
	}
	
	protected OwnedConverter getConverter() {
		return converter;
	}
	
	protected List<XExpression> getArguments() {
		return arguments;
	}
	
	public LightweightTypeReference getDeclaredType(int argumentIndex) {
		int idx = argumentIndex - argumentSizeFixup;
		JvmFormalParameter parameter = parameters.get(idx);
		JvmTypeReference parameterType = parameter.getParameterType();
		LightweightTypeReference result = converter.toLightweightReference(parameterType);
		return result;
	}
	
	public int getFixedArityArgumentCount() {
		return fixedArityArgumentCount;
	}
	
	public boolean isVarArgs() {
		return varArgs;
	}
	
	public boolean isExactArity() {
		return arguments.size() == parameters.size();
	}
	
	public int getArgumentSize() {
		return arguments.size() + argumentSizeFixup;
	}
	
	public ArrayTypeReference getVarArgType() {
		JvmFormalParameter lastParameter = parameters.get(parameters.size() - 1);
		JvmTypeReference parameterType = lastParameter.getParameterType();
		LightweightTypeReference result = converter.toLightweightReference(parameterType);
		if (!(result instanceof ArrayTypeReference))
			throw new IllegalStateException("Unexpected var arg type: " + result);
		return (ArrayTypeReference) result;
	}
	
	public boolean hasUnprocessedArguments() {
		return parameters != null && nextArgument - argumentSizeFixup < arguments.size();
	}
	
	public int getNextUnprocessedNextArgument() {
		return nextArgument;
	}

	public boolean isProcessed(int argumentIndex) {
		return parameters == null || argumentIndex < nextArgument || arguments.size() == 0 || argumentIndex - argumentSizeFixup >= arguments.size();
	}

	public XExpression getArgument(int argumentIndex) {
		return arguments.get(argumentIndex - argumentSizeFixup);
	}

	public void markProcessed(int argumentIndex) {
		nextArgument = Math.max(argumentIndex + 1, nextArgument);
	}

}
