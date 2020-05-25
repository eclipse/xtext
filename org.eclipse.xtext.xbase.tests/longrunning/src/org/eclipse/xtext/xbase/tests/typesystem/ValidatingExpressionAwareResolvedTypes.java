/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

public class ValidatingExpressionAwareResolvedTypes extends ExpressionAwareStackedResolvedTypes {
	public ValidatingExpressionAwareResolvedTypes(ResolvedTypes parent, XExpression expression) {
		super(parent, expression);
	}

	@Override
	public StackedResolvedTypes pushReassigningTypes() {
		return new ValidatingReassigningResolvedTypes(this);
	}

	@Override
	public StackedResolvedTypes pushTypes() {
		return new ValidatingStackedResolvedTypes(this);
	}

	@Override
	public ExpressionAwareStackedResolvedTypes pushTypes(XExpression context) {
		return new ValidatingExpressionAwareResolvedTypes(this, context);
	}

	@Override
	public void setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (!reference.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("reference is not owned by this resolved types");
		}
		super.setType(identifiable, reference);
	}

	@Override
	public void reassignType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (reference != null && !reference.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("reference is not owned by this resolved types");
		}
		super.reassignType(identifiable, reference);
	}

	@Override
	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		if (boundTypeArgument.getTypeReference() != null && !boundTypeArgument.getTypeReference().isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("reference is not owned by this resolved types");
		}
		super.acceptHint(handle, boundTypeArgument);
	}

	@Override
	protected List<LightweightBoundTypeArgument> getHints(Object handle) {
		List<LightweightBoundTypeArgument> result = super.getHints(handle);
		for (LightweightBoundTypeArgument it : result) {
			if (it.getTypeReference() != null && !it.getTypeReference().isOwnedBy(getReferenceOwner())) {
				throw new IllegalArgumentException("reference is not owned by this resolved types");
			}
		}
		return result;
	}

	@Override
	public LightweightTypeReference acceptType(XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type,
			boolean returnType, int hints) {
		if (!expectation.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("expectation is not owned by this resolved types");
		}
		if (!type.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("type is not owned by this resolved types");
		}
		return super.acceptType(expression, expectation, type, returnType, hints);
	}

	@Override
	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		List<LightweightBoundTypeArgument> result = super.getAllHints(handle);
		for (LightweightBoundTypeArgument it : result) {
			if (it.getTypeReference() != null && !it.getTypeReference().isOwnedBy(getReferenceOwner())) {
				throw new IllegalArgumentException("hint is not owned by this resolved types");
			}
		}
		return result;
	}

	@Override
	public UnboundTypeReference getUnboundTypeReference(Object handle) {
		UnboundTypeReference result = super.getUnboundTypeReference(handle);
		if (!result.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("result is not owned by this resolved types");
		}
		return result;
	}

	@Override
	public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = super.getActualType(identifiable);
		if (!result.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("result is not owned by this resolved types");
		}
		return result;
	}

	@Override
	public LightweightTypeReference getActualType(XExpression expression) {
		LightweightTypeReference result = super.getActualType(expression);
		if (!result.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("result is not owned by this resolved types");
		}
		return result;
	}

	@Override
	public LightweightTypeReference getExpectedType(XExpression expression) {
		LightweightTypeReference result = super.getExpectedType(expression);
		if (!result.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("result is not owned by this resolved types");
		}
		return result;
	}

	@Override
	public LightweightTypeReference getMergedType(List<LightweightTypeReference> types) {
		for (LightweightTypeReference it : types) {
			if (!it.isOwnedBy(it.getOwner())) {
				throw new IllegalArgumentException("result is not owned by this resolved types");
			}
		}
		LightweightTypeReference result = super.getMergedType(types);
		if (!result.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("result is not owned by this resolved types");
		}
		return result;
	}

	@Override
	public TypeData mergeTypeData(XExpression expression, List<TypeData> allValues, boolean returnType, boolean nullIfEmpty) {
		for (TypeData it : allValues) {
			if (!it.isOwnedBy(getReferenceOwner())) {
				throw new IllegalArgumentException("result is not owned by this resolved types");
			}
		}
		TypeData result = super.mergeTypeData(expression, allValues, returnType, nullIfEmpty);
		if (result != null && !result.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("result is not owned by this resolved types");
		}
		return result;
	}
}
