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
public class ParameterizedTypeReference extends LightweightTypeReference {

	private List<LightweightTypeReference> typeArguments;
	private JvmType type;
	protected boolean resolved;
	
	protected ParameterizedTypeReference(ResolvedTypes types, JvmType type) {
		super(types);
		this.type = type;
		this.resolved = true;
	}
	
	protected JvmType getType() {
		return type;
	}

	@Override
	protected ParameterizedTypeReference doCopyInto(ResolvedTypes types) {
		ParameterizedTypeReference result = new ParameterizedTypeReference(types, type);
		copyTypeArguments(result, types);
		return result;
	}

	protected void copyTypeArguments(ParameterizedTypeReference result, ResolvedTypes types) {
		if (typeArguments != null && !typeArguments.isEmpty()) {
			for(LightweightTypeReference typeArgument: typeArguments) {
				result.addTypeArgument(typeArgument.copyInto(types));
			}
		}
	}
	
	@Override
	public boolean isResolved() {
		return resolved;
	}

	protected void addTypeArgument(LightweightTypeReference argument) {
		if (argument == null) {
			throw new NullPointerException("argument may not be null");
		}
		if (!argument.isValidInContext(getContext())) {
			throw new NullPointerException("argument is not valid in current context");
		}
		if (typeArguments == null)
			typeArguments = Lists.newArrayListWithCapacity(2);
		typeArguments.add(argument);
		resolved &= argument.isResolved();
	}
	
	@Override
	public String toString() {
		return type.getSimpleName() + "<" + Joiner.on(", ").join(typeArguments) + ">";
	}

}
