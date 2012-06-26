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
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xtype.XComputedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class UnboundTypeReference extends LightweightTypeReference {

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
		if (resolvedTo != null) {
			return resolvedTo.toTypeReference();
		}
		XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
		result.setTypeProvider(new AbstractReentrantTypeReferenceProvider() {
			@Override
			protected JvmTypeReference doGetTypeReference() {
				if (resolvedTo != null) {
					resolve();
				}
				return resolvedTo.toTypeReference();
			}
		});
		return result;
	}
	
	@Override
	public boolean isRawType() {
		if (resolvedTo != null)
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
		return resolvedTo;
	}
	
	protected void resolve() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Always copies the reference since we want to reduce the nesting iff the
	 * reference was resolved and we have to copy it if the reference is not 
	 * yet resolved.
	 */
	@Override
	public LightweightTypeReference copyInto(TypeReferenceOwner owner) {
		return doCopyInto(owner);
	}
	
	@Override
	public boolean isResolved() {
		if (resolvedTo != null) {
			return resolvedTo.isResolved();
		}
		return false;
	}
	
	@Override
	public boolean isArray() {
		if (resolvedTo != null) {
			return resolvedTo.isArray();
		}
		return false;
	}
	
	@Override
	@Nullable
	public JvmType getType() {
		if (resolvedTo != null)
			return resolvedTo.getType();
		return getTypeParameter();
	}
	
	@Override
	public boolean isType(Class<?> clazz) {
		if (resolvedTo != null) {
			return resolvedTo.isType(clazz);
		}
		return false;
	}
	
	@Override
	public List<LightweightTypeReference> getSuperTypes() {
		if (resolvedTo != null)
			return resolvedTo.getSuperTypes();
		return Collections.emptyList();
	}
	
	@Override
	public LightweightTypeReference getWrapperTypeIfPrimitive() {
		if (resolvedTo != null)
			return resolvedTo.getWrapperTypeIfPrimitive();
		return super.getWrapperTypeIfPrimitive();
	}

	@Override
	protected LightweightTypeReference doCopyInto(TypeReferenceOwner owner) {
		if (resolvedTo != null) {
			return resolvedTo.copyInto(owner);
		}
		UnboundTypeReference result = createCopy(owner);
		return result;
	}

	protected UnboundTypeReference createCopy(TypeReferenceOwner owner) {
		return new UnboundTypeReference(owner, typeParameter, handle);
	}

	@Override
	public String getSimpleName() {
		if (resolvedTo != null) {
			return resolvedTo.getSimpleName();
		}
		return "Unbound <" + typeParameter.getSimpleName() + ">";
	}
	
	@Override
	public String getIdentifier() {
		if (resolvedTo != null) {
			return resolvedTo.getIdentifier();
		}
		return "Unbound <" + typeParameter.getIdentifier() + ">";
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		if (resolvedTo != null) {
			resolvedTo.accept(visitor);
		} else {
			visitor.doVisitUnboundTypeReference(this);
		}
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		if (resolvedTo != null) {
			resolvedTo.accept(visitor, param);
		} else {
			visitor.doVisitUnboundTypeReference(this, param);
		}
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		if (resolvedTo != null) {
			return resolvedTo.accept(visitor);
		} else {
			return visitor.doVisitUnboundTypeReference(this);
		}
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		if (resolvedTo != null) {
			return resolvedTo.accept(visitor, param);
		} else {
			return visitor.doVisitUnboundTypeReference(this, param);
		}
	}

	public void acceptHint(
			LightweightTypeReference hint, BoundTypeArgumentSource source, Object origin,
			VarianceInfo expectedVariance, VarianceInfo actualVariance) {
		acceptHint(new LightweightBoundTypeArgument(hint, source, origin, expectedVariance, actualVariance));
	}
	
	public void acceptHint(LightweightBoundTypeArgument hint) {
		if (resolvedTo != null) {
			throw new IllegalStateException("Cannot add hints to a resolved reference");
		}
		getOwner().acceptHint(this.getHandle(), hint);
	}

	public List<LightweightBoundTypeArgument> getAllHints() {
		if (resolvedTo != null) {
			throw new IllegalStateException("Cannot query hints for a resolved reference");
		}
		return getOwner().getAllHints(getHandle());
	}

	public boolean equalHandles(UnboundTypeReference reference) {
		return getHandle().equals(reference.getHandle());
	}
}
