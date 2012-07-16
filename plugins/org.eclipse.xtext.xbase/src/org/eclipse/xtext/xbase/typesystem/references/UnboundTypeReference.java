/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class UnboundTypeReference extends LightweightTypeReference {

	private LightweightTypeReference resolvedTo;
	private final JvmTypeParameter typeParameter;
	private final Object handle;
	
	public UnboundTypeReference(TypeReferenceOwner owner, JvmTypeParameter typeParameter, Object handle) {
		super(owner);
		this.typeParameter = typeParameter;
		this.handle = handle;
	}

	@Override
	public JvmTypeReference toTypeReference() {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.toTypeReference();
		}
		XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
		result.setTypeProvider(new UnboundTypeReferenceResolver(this));
		return result;
	}
	
	@Override
	public boolean isRawType() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.isRawType();
		return false;
	}
	
	public JvmTypeParameter getTypeParameter() {
		return typeParameter;
	}
	
	protected Object getHandle() {
		return handle;
	}
	
	@Nullable
	public LightweightTypeReference getResolvedTo() {
		return internalGetResolvedTo();
	}
	
	public LightweightTypeReference resolve() {
		List<LightweightBoundTypeArgument> allHints = getOwner().getAllHints(getHandle());
		if (!allHints.isEmpty() && resolveWithHints(allHints)) {
			LightweightTypeReference result = internalGetResolvedTo();
			if (result != null) {
				return result;
			}
		}
		TypeParameterByConstraintSubstitutor unboundSubstitutor = new TypeParameterByConstraintSubstitutor(
				Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), getOwner());
		LightweightTypeReference substitute = unboundSubstitutor.substitute(new ParameterizedTypeReference(getOwner(), typeParameter));
		getOwner().acceptHint(getHandle(), new LightweightBoundTypeArgument(substitute, BoundTypeArgumentSource.RESOLVED, this, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT));
		return substitute;
	}

	protected boolean resolveWithHints(List<LightweightBoundTypeArgument> allHints) {
		List<LightweightBoundTypeArgument> inferredHints = Lists.newArrayListWithCapacity(allHints.size());
		for(LightweightBoundTypeArgument hint: allHints) {
			if (hint.getSource() == BoundTypeArgumentSource.INFERRED) {
				inferredHints.add(hint);
			}
		}
		LightweightMergedBoundTypeArgument typeArgument = getServices().getBoundTypeArgumentMerger().merge(!inferredHints.isEmpty() ? inferredHints : allHints, getOwner());
		if (typeArgument != null) {
			if (!inferredHints.isEmpty() && inferredHints.size() != allHints.size()) {
				DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(getOwner()) {
					@Override
					protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
						return new UnboundTypeReferenceTraverser() {
							@Override
							public void doVisitParameterizedTypeReference(ParameterizedTypeReference reference, UnboundTypeReference param) {
								if (!param.isResolved() && param.getTypeParameter() == reference.getType()) {
									return;
								}
								super.doVisitParameterizedTypeReference(reference, param);
							}
						};
					}
				};
				for(LightweightBoundTypeArgument hint: allHints) {
					if (hint.getSource() != BoundTypeArgumentSource.INFERRED) {
						collector.processPairedReferences(typeArgument.getTypeReference(), hint.getTypeReference());
					}
				}
			}
			resolvedTo = typeArgument.getTypeReference();
			getOwner().acceptHint(getHandle(), new LightweightBoundTypeArgument(typeArgument.getTypeReference(), BoundTypeArgumentSource.RESOLVED, this, VarianceInfo.INVARIANT, typeArgument.getVariance()));
			return true;
		}
		return false;
	}

	/**
	 * Always copies the reference since we want to reduce the nesting level
	 * of references if this one was resolved but points to something unresolved.
	 * In that case, we only want to copy the remaining unresolved parts.
	 * Otherwise we copy this reference.
	 */
	@Override
	public LightweightTypeReference copyInto(TypeReferenceOwner owner) {
		return doCopyInto(owner);
	}
	
	@Override
	public boolean isResolved() {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.isResolved();
		}
		return false;
	}
	
	public boolean internalIsResolved() {
		return internalGetResolvedTo() != null;
	}
	
	@Nullable
	protected LightweightTypeReference internalGetResolvedTo() {
		if (resolvedTo != null)
			return resolvedTo;
		if (getOwner().isResolved(getHandle())) {
			List<LightweightBoundTypeArgument> hints = getOwner().getAllHints(getHandle());
			if (hints.size() != 1)
				return null;
			LightweightBoundTypeArgument singleHint = hints.get(0);
			if (singleHint.getSource() == BoundTypeArgumentSource.RESOLVED) {
				resolvedTo = singleHint.getTypeReference();
				return resolvedTo;
			}
		}
		return null;
	}
	
	@Override
	public boolean isArray() {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.isArray();
		}
		return false;
	}
	
	@Override
	@Nullable
	public JvmType getType() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.getType();
		return getTypeParameter();
	}
	
	@Override
	public boolean isType(Class<?> clazz) {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.isType(clazz);
		}
		return false;
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		if (internalGetResolvedTo() != null)
			return resolvedTo.getSuperTypes(substitutor);
		return Collections.emptyList();
	}
	
	@Override
	public LightweightTypeReference getWrapperTypeIfPrimitive() {
		if (internalGetResolvedTo() != null)
			return resolvedTo.getWrapperTypeIfPrimitive();
		return super.getWrapperTypeIfPrimitive();
	}

	@Override
	protected LightweightTypeReference doCopyInto(TypeReferenceOwner owner) {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.copyInto(owner);
		}
		UnboundTypeReference result = createCopy(owner);
		return result;
	}

	protected abstract UnboundTypeReference createCopy(TypeReferenceOwner owner);

	@Override
	public String getSimpleName() {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.getSimpleName();
		}
		return "Unbound <" + typeParameter.getSimpleName() + ">";
	}
	
	@Override
	public String getIdentifier() {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.getIdentifier();
		}
		return "Unbound <" + typeParameter.getIdentifier() + ">";
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		if (internalGetResolvedTo() != null) {
			resolvedTo.accept(visitor);
		} else {
			visitor.doVisitUnboundTypeReference(this);
		}
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		if (internalGetResolvedTo() != null) {
			resolvedTo.accept(visitor, param);
		} else {
			visitor.doVisitUnboundTypeReference(this, param);
		}
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.accept(visitor);
		} else {
			return visitor.doVisitUnboundTypeReference(this);
		}
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		if (internalGetResolvedTo() != null) {
			return resolvedTo.accept(visitor, param);
		} else {
			return visitor.doVisitUnboundTypeReference(this, param);
		}
	}

	public void acceptHint(
			LightweightTypeReference hint, BoundTypeArgumentSource source, Object origin,
			VarianceInfo expectedVariance, VarianceInfo actualVariance) {
		acceptHint(new LightweightBoundTypeArgument(hint.getWrapperTypeIfPrimitive(), source, origin, expectedVariance, actualVariance));
	}
	
	public void acceptHint(LightweightBoundTypeArgument hint) {
		if (internalIsResolved()) {
			throw new IllegalStateException("Cannot add hints to a resolved reference");
		}
		getOwner().acceptHint(this.getHandle(), hint);
	}

	public List<LightweightBoundTypeArgument> getAllHints() {
		if (internalGetResolvedTo() != null) {
			throw new IllegalStateException("Cannot query hints for a resolved reference");
		}
		return getOwner().getAllHints(getHandle());
	}

	public boolean equalHandles(UnboundTypeReference reference) {
		return getHandle().equals(reference.getHandle());
	}
}
