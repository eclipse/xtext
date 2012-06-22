/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ParameterizedTypeReference extends LightweightTypeReference {

	private List<LightweightTypeReference> typeArguments;
	private JvmType type;
	protected boolean resolved;
	
	protected ParameterizedTypeReference(TypeReferenceOwner owner, JvmType type) {
		super(owner);
		this.type = type;
		// TODO check against owner
		this.resolved = !(type instanceof JvmTypeParameter);
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmParameterizedTypeReference result = getTypesFactory().createJvmParameterizedTypeReference();
		result.setType(type);
		if (typeArguments != null) {
			for(LightweightTypeReference typeArgument: typeArguments) {
				result.getArguments().add(typeArgument.toTypeReference());
			}
		}
		return result;
	}
	
	@Override
	public JvmType getType() {
		return type;
	}
	
	public List<LightweightTypeReference> getTypeArguments() {
		return expose(typeArguments);
	}

	@Override
	protected ParameterizedTypeReference doCopyInto(TypeReferenceOwner owner) {
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, type);
		copyTypeArguments(result, owner);
		return result;
	}

	protected void copyTypeArguments(ParameterizedTypeReference result, TypeReferenceOwner owner) {
		if (typeArguments != null && !typeArguments.isEmpty()) {
			for(LightweightTypeReference typeArgument: typeArguments) {
				result.addTypeArgument(typeArgument.copyInto(owner));
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
		if (!argument.isOwnedBy(getOwner())) {
			throw new NullPointerException("argument is not valid in current context");
		}
		if (typeArguments == null)
			typeArguments = Lists.newArrayListWithCapacity(2);
		typeArguments.add(argument);
		resolved &= argument.isResolved();
	}
	
	@Override
	public String toString() {
		if (typeArguments != null)
			return type.getSimpleName() + "<" + Joiner.on(", ").join(getTypeArguments()) + ">";
		return type.getSimpleName();
	}

	@Override
	public boolean isType(Class<?> clazz) {
		if (type != null) {
			return clazz.getCanonicalName().equals(type.getIdentifier());
		}
		return false;
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitParameterizedTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitParameterizedTypeReference(this, param);
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitParameterizedTypeReference(this);
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitParameterizedTypeReference(this, param);
	}
}
