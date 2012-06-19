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
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameters;
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
			List<BoundTypeArgument> inferredHints = Lists.newArrayListWithCapacity(allHints.size());
			for(BoundTypeArgument hint: allHints) {
				if (hint.getSource() == BoundTypeArgumentSource.INFERRED) {
					inferredHints.add(hint);
				}
			}
			MergedBoundTypeArgument typeArgument = getServices().getBoundTypeArgumentMerger().merge(!inferredHints.isEmpty() ? inferredHints : allHints);
			if (typeArgument != null) {
				if (!inferredHints.isEmpty() && inferredHints.size() != allHints.size()) {
					DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(getServices()) {
						@Override
						protected ComputedTypeReferenceTraverser createComputedTypeReferenceTraverser() {
							return new ComputedTypeReferenceTraverser() {
								@Override
								public Void doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, XComputedTypeReference param) {
									if (UnboundTypeParameters.isUnboundTypeParameter(param)) {
										if (reference.getType() instanceof JvmTypeParameter) {
											return null;
										}
									}
									return super.doVisitParameterizedTypeReference(reference, param);
								}
							};
						}
						@Override
						protected TypeParameterSubstitutor createTypeParameterSubstitutor(
								Map<JvmTypeParameter, MergedBoundTypeArgument> mapping) {
							return resolvedTypes.createSubstitutor(mapping);
						}
					};
					for(BoundTypeArgument hint: allHints) {
						if (hint.getSource() != BoundTypeArgumentSource.INFERRED) {
							collector.processPairedReferences(typeArgument.getTypeReference(), hint.getTypeReference());
						}
					}
				}
				setBoundTo(typeArgument);
				return getBoundTo().getTypeReference();
			}
		}
		TypeParameterByConstraintSubstitutor unboundSubstitutor = new TypeParameterByConstraintSubstitutor(
				Collections.<JvmTypeParameter, MergedBoundTypeArgument>emptyMap(), getServices());
		JvmTypeReference substitute = unboundSubstitutor.substitute(getServices().getTypeReferences().createTypeRef(getTypeParameter()));
		setBoundTo(new MergedBoundTypeArgument(substitute, VarianceInfo.INVARIANT /* TODO which variance info to use? */));
		return getBoundTo().getTypeReference();
	}
	
	protected CommonTypeComputationServices getServices() {
		return resolvedTypes.getResolver().getServices();
	}
	
	protected void setResolvedTypes(ResolvedTypes resolvedTypes) {
		this.resolvedTypes = resolvedTypes;
	}
	
	protected ResolvedTypes getResolvedTypes() {
		return resolvedTypes;
	}
	
	public MergedBoundTypeArgument getBoundTo() {
		return boundTo;
	}
	
	protected void setBoundTo(MergedBoundTypeArgument boundTo) {
		if (this.boundTo != null)
			throw new IllegalStateException("Cannot resolve twice");
		this.boundTo = boundTo;
	}
	
	@Override
	public void acceptHint(BoundTypeArgument boundArgument) {
		if (boundTo != null) {
			throw new IllegalStateException("Type parameter was already bound. No more hints may be accepted.");
		}
		
		if (boundArgument.getSource() == BoundTypeArgumentSource.EXPLICIT) {
			boundTo = new MergedBoundTypeArgument(boundArgument.getTypeReference(), boundArgument.getActualVariance());
		} else {
			JvmTypeReference hint = boundArgument.getTypeReference();
			if (hint instanceof XComputedTypeReference) {
				IJvmTypeReferenceProvider typeProvider = ((XComputedTypeReference) hint).getTypeProvider();
				if (typeProvider instanceof BaseUnboundTypeParameter) {
					BaseUnboundTypeParameter other = (BaseUnboundTypeParameter) typeProvider;
					if (other.getResolvedTypes() != getResolvedTypes()) {
						throw new IllegalStateException("Other unbound parameter was not substituted properly");
					}
					if (other.getBoundTo() != null) {
						throw new IllegalStateException("Other parameter was already bound");
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
	}
	
	protected List<BoundTypeArgument> getHints() {
		return hints;
	}
	
	protected Set<Object> getEquallyBoundHandles() {
		return equallyBoundHandles;
	}
	
	public List<BoundTypeArgument> getAllHints() {
		if (!hints.isEmpty() || !equallyBoundHandles.isEmpty()) {
			List<BoundTypeArgument> allHints = Lists.newArrayList();
			collectHints(this, allHints, Sets.newHashSet());
			return allHints;
		}
		return Collections.emptyList();
	}
	
	private void collectHints(BaseUnboundTypeParameter parameter, List<BoundTypeArgument> result, Set<Object> visited) {
		if (visited.add(parameter.getHandle())) {
			result.addAll(parameter.hints);
			for(Object handle: parameter.equallyBoundHandles) {
				collectHints(resolvedTypes.getUnboundTypeParameter(handle), result, visited);
			}
		}
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
