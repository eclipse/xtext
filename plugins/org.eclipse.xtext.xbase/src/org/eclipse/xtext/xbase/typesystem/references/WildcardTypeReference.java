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
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class WildcardTypeReference extends LightweightTypeReference {

	private List<LightweightTypeReference> upperBounds;
	private LightweightTypeReference lowerBound;
	private boolean resolved;
	
	protected WildcardTypeReference(TypeReferenceOwner owner) {
		super(owner);
		resolved = true;
	}
	
	@Override
	public boolean isResolved() {
		return resolved;
	}
	
	public List<LightweightTypeReference> getUpperBounds() {
		return expose(upperBounds);
	}
	
	@Nullable
	public LightweightTypeReference getLowerBound() {
		return lowerBound;
	}

	@Override
	protected WildcardTypeReference doCopyInto(TypeReferenceOwner owner) {
		WildcardTypeReference result = new WildcardTypeReference(owner);
		if (upperBounds != null && !upperBounds.isEmpty()) {
			for(LightweightTypeReference upperBound: upperBounds) {
				result.addUpperBound(upperBound.copyInto(owner));
			}
		}
		if (lowerBound != null) {
			result.lowerBound = lowerBound.copyInto(owner);
		}
		return result;
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		TypesFactory typesFactory = getTypesFactory();
		JvmWildcardTypeReference result = typesFactory.createJvmWildcardTypeReference();
		if (upperBounds != null && !upperBounds.isEmpty()) {
			for(LightweightTypeReference typeArgument: upperBounds) {
				JvmUpperBound constraint = typesFactory.createJvmUpperBound();
				constraint.setTypeReference(typeArgument.toTypeReference());
				result.getConstraints().add(constraint);
			}
		}
		if (lowerBound != null) {
			JvmLowerBound constraint = typesFactory.createJvmLowerBound();
			constraint.setTypeReference(lowerBound.toTypeReference());
			result.getConstraints().add(constraint);
		}
		return result;
	}
	
	protected void addUpperBound(LightweightTypeReference upperBound) {
		if (upperBound == null) {
			throw new NullPointerException("upperBound may not be null");
		}
		if (!upperBound.isOwnedBy(getOwner())) {
			throw new NullPointerException("upperBound is not valid in current context");
		}
		if (upperBounds == null)
			upperBounds = Lists.newArrayListWithCapacity(2);
		upperBounds.add(upperBound);
		resolved &= upperBound.isResolved();
	}
	
	protected void setLowerBound(LightweightTypeReference lowerBound) {
		if (lowerBound == null) {
			throw new NullPointerException("lowerBound may not be null");
		}
		if (!lowerBound.isOwnedBy(getOwner())) {
			throw new NullPointerException("lowerBound is not valid in current context");
		}
		if (this.lowerBound != null && this.lowerBound != lowerBound) {
			throw new IllegalStateException("only one lower bound is supported");
		}
		this.lowerBound = lowerBound;
		resolved &= lowerBound.isResolved();
	}

	@Override
	public String toString() {
		if (lowerBound != null) {
			return "? super " + lowerBound;
		}
		if (upperBounds != null && upperBounds.size() == 1 && upperBounds.get(0).isType(Object.class)) {
			return "?";
		}
		return "?" + ( upperBounds != null ? " extends " + Joiner.on(" & ").join(upperBounds) : "");
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitWildcardTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitWildcardTypeReference(this, param);
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitWildcardTypeReference(this);
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitWildcardTypeReference(this, param);
	}
}
