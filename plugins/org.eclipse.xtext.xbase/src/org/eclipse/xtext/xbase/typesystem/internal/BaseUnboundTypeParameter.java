/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
public abstract class BaseUnboundTypeParameter extends UnboundTypeParameter {

	private final List<BoundTypeArgument> hints;
	private MergedBoundTypeArgument boundTo;
	private Set<Object> equallyBoundHandles;
	private ResolvedTypes resolvedTypes;
	
	public BaseUnboundTypeParameter(ResolvedTypes resolvedTypes) {
		this.resolvedTypes = resolvedTypes;
		this.hints = Lists.newArrayList();
		this.equallyBoundHandles = Sets.newHashSetWithExpectedSize(2);
	}
	
	@Override
	protected JvmTypeReference doGetTypeReference() {
		if (boundTo != null) {
			return boundTo.getTypeReference();
		}
		List<BoundTypeArgument> allHints = getAllHints();
		if (!allHints.isEmpty()) {
			MergedBoundTypeArgument typeArgument = getServices().getBoundTypeArgumentMerger().merge(allHints);
			if (typeArgument != null) {
				boundTo = typeArgument;
				return typeArgument.getTypeReference();
			}
		}
		TypeParameterByConstraintSubstitutor unboundSubstitutor = new TypeParameterByConstraintSubstitutor(
				Collections.<JvmTypeParameter, MergedBoundTypeArgument>emptyMap(), getServices());
		JvmTypeReference substitute = unboundSubstitutor.substitute(getServices().getTypeReferences().createTypeRef(getTypeParameter()));
		boundTo = new MergedBoundTypeArgument(substitute, VarianceInfo.INVARIANT /* TODO which variance info to use? */);
		return substitute;
	}
	
	protected CommonTypeComputationServices getServices() {
		return resolvedTypes.getResolver().getServices();
	}
	
	protected void setResolvedTypes(ResolvedTypes resolvedTypes) {
		this.resolvedTypes = resolvedTypes;
	}
	
	public MergedBoundTypeArgument getBoundTo() {
		return boundTo;
	}
	
	protected void setBoundTo(MergedBoundTypeArgument boundTo) {
		this.boundTo = boundTo;
	}
	
	@Override
	public void acceptHint(BoundTypeArgument boundArgument) {
		if (boundTo != null) {
			throw new IllegalStateException("Type parameter was already bound. No more hints may be accepted.");
		}
		JvmTypeReference hint = boundArgument.getTypeReference();
		if (hint instanceof XComputedTypeReference) {
			IJvmTypeReferenceProvider typeProvider = ((XComputedTypeReference) hint).getTypeProvider();
			if (typeProvider instanceof BaseUnboundTypeParameter) {
				BaseUnboundTypeParameter other = (BaseUnboundTypeParameter) typeProvider;
				if (other.getBoundTo() != null) {
					throw new IllegalStateException();
				} else {
					if (other.getHandle().equals(getHandle())) {
						throw new IllegalStateException("Cannot add recursive hint");
					}
					equallyBoundHandles.add(other.getHandle());
					other.equallyBoundHandles.add(getHandle());
					return;
				}
			}
		}
		hints.add(boundArgument);
	}
	
	protected List<BoundTypeArgument> getHints() {
		return hints;
	}
	
	protected Set<Object> getEquallyBoundHandles() {
		return equallyBoundHandles;
	}
	
	public List<BoundTypeArgument> getAllHints() {
		if (!hints.isEmpty() || !equallyBoundHandles.isEmpty()) {
			List<BoundTypeArgument> allHints = Lists.newArrayList(hints);
			for(Object handle: equallyBoundHandles) {
				// TODO transitivity ?
				BaseUnboundTypeParameter similar = resolvedTypes.getUnboundTypeParameter(handle);
				allHints.addAll(similar.hints);
			}
			return allHints;
		}
		return Collections.emptyList();
	}
	
	@Override
	public abstract XExpression getExpression();
	
	@Override
	public abstract JvmTypeParameter getTypeParameter();
	
	@Override
	public abstract Object getHandle();
	
	@Override
	public boolean isComputed() {
		return boundTo != null;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName());
		builder.append(" [typeParameter=");
		builder.append(getTypeParameter());
		builder.append("]");
		return builder.toString();
	}

	
}
