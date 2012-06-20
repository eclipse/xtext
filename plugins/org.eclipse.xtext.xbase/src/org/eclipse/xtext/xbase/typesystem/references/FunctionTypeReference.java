/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FunctionTypeReference extends ParameterizedTypeReference {

	private List<LightweightTypeReference> parameterTypes;
	private LightweightTypeReference returnType;
	
	protected FunctionTypeReference(ResolvedTypes types, JvmType type) {
		super(types, type);
	}
	
	@Override
	protected FunctionTypeReference doCopyInto(ResolvedTypes types) {
		FunctionTypeReference result = new FunctionTypeReference(types, getType());
		copyTypeArguments(result, types);
		if (parameterTypes != null && !parameterTypes.isEmpty()) {
			for(LightweightTypeReference typeArgument: parameterTypes) {
				result.addParameterType(typeArgument.copyInto(types));
			}
			if (returnType != null) {
				result.returnType = returnType.copyInto(types);
			}
		}
		return result;
	}
	
	protected void addParameterType(LightweightTypeReference parameterType) {
		if (parameterType == null) {
			throw new NullPointerException("parameterType may not be null");
		}
		if (!parameterType.isValidInContext(getContext())) {
			throw new NullPointerException("parameterType is not valid in current context");
		}
		if (parameterTypes == null)
			parameterTypes = Lists.newArrayListWithCapacity(2);
		parameterTypes.add(parameterType);
		resolved &= parameterType.isResolved();
	}
	
	protected void setLowerBound(LightweightTypeReference returnType) {
		if (returnType == null) {
			throw new NullPointerException("returnType may not be null");
		}
		if (!returnType.isValidInContext(getContext())) {
			throw new NullPointerException("returnType is not valid in current context");
		}
		this.returnType = returnType;
		resolved &= returnType.isResolved();
	}
	
	@Override
	public String toString() {
		return "(" + Joiner.on(", ").join(parameterTypes) + ")=>" + returnType + " // " + super.toString();
	}
	

}
