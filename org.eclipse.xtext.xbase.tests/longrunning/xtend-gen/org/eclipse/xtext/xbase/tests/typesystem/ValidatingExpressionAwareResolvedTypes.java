/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.typesystem.ValidatingReassigningResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.ValidatingStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

@SuppressWarnings("all")
public class ValidatingExpressionAwareResolvedTypes extends ExpressionAwareStackedResolvedTypes {
  public ValidatingExpressionAwareResolvedTypes(final ResolvedTypes parent, final XExpression expression) {
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
  public ExpressionAwareStackedResolvedTypes pushTypes(final XExpression context) {
    return new ValidatingExpressionAwareResolvedTypes(this, context);
  }
  
  @Override
  public void setType(final JvmIdentifiableElement identifiable, final LightweightTypeReference reference) {
    boolean _isOwnedBy = reference.isOwnedBy(this.getReferenceOwner());
    boolean _not = (!_isOwnedBy);
    if (_not) {
      throw new IllegalArgumentException("reference is not owned by this resolved types");
    }
    super.setType(identifiable, reference);
  }
  
  @Override
  public void reassignType(final JvmIdentifiableElement identifiable, final LightweightTypeReference reference) {
    if (((reference != null) && (!reference.isOwnedBy(this.getReferenceOwner())))) {
      throw new IllegalArgumentException("reference is not owned by this resolved types");
    }
    super.reassignType(identifiable, reference);
  }
  
  @Override
  public void acceptHint(final Object handle, final LightweightBoundTypeArgument boundTypeArgument) {
    if (((boundTypeArgument.getTypeReference() != null) && (!boundTypeArgument.getTypeReference().isOwnedBy(this.getReferenceOwner())))) {
      throw new IllegalArgumentException("reference is not owned by this resolved types");
    }
    super.acceptHint(handle, boundTypeArgument);
  }
  
  @Override
  protected List<LightweightBoundTypeArgument> getHints(final Object handle) {
    final List<LightweightBoundTypeArgument> result = super.getHints(handle);
    final Consumer<LightweightBoundTypeArgument> _function = (LightweightBoundTypeArgument it) -> {
      if (((it.getTypeReference() != null) && (!it.getTypeReference().isOwnedBy(this.getReferenceOwner())))) {
        throw new IllegalArgumentException("reference is not owned by this resolved types");
      }
    };
    result.forEach(_function);
    return result;
  }
  
  @Override
  public LightweightTypeReference acceptType(final XExpression expression, final AbstractTypeExpectation expectation, final LightweightTypeReference type, final boolean returnType, final int hints) {
    LightweightTypeReference _xblockexpression = null;
    {
      boolean _isOwnedBy = expectation.isOwnedBy(this.getReferenceOwner());
      boolean _not = (!_isOwnedBy);
      if (_not) {
        throw new IllegalArgumentException("expectation is not owned by this resolved types");
      }
      boolean _isOwnedBy_1 = type.isOwnedBy(this.getReferenceOwner());
      boolean _not_1 = (!_isOwnedBy_1);
      if (_not_1) {
        throw new IllegalArgumentException("type is not owned by this resolved types");
      }
      _xblockexpression = super.acceptType(expression, expectation, type, returnType, hints);
    }
    return _xblockexpression;
  }
  
  @Override
  public List<LightweightBoundTypeArgument> getAllHints(final Object handle) {
    final List<LightweightBoundTypeArgument> result = super.getAllHints(handle);
    final Consumer<LightweightBoundTypeArgument> _function = (LightweightBoundTypeArgument it) -> {
      if (((it.getTypeReference() != null) && (!it.getTypeReference().isOwnedBy(this.getReferenceOwner())))) {
        throw new IllegalArgumentException("hint is not owned by this resolved types");
      }
    };
    result.forEach(_function);
    return result;
  }
  
  @Override
  public UnboundTypeReference getUnboundTypeReference(final Object handle) {
    final UnboundTypeReference result = super.getUnboundTypeReference(handle);
    boolean _isOwnedBy = result.isOwnedBy(this.getReferenceOwner());
    boolean _not = (!_isOwnedBy);
    if (_not) {
      throw new IllegalArgumentException("result is not owned by this resolved types");
    }
    return result;
  }
  
  @Override
  public LightweightTypeReference getActualType(final JvmIdentifiableElement identifiable) {
    final LightweightTypeReference result = super.getActualType(identifiable);
    boolean _isOwnedBy = result.isOwnedBy(this.getReferenceOwner());
    boolean _not = (!_isOwnedBy);
    if (_not) {
      throw new IllegalArgumentException("result is not owned by this resolved types");
    }
    return result;
  }
  
  @Override
  public LightweightTypeReference getActualType(final XExpression expression) {
    final LightweightTypeReference result = super.getActualType(expression);
    boolean _isOwnedBy = result.isOwnedBy(this.getReferenceOwner());
    boolean _not = (!_isOwnedBy);
    if (_not) {
      throw new IllegalArgumentException("result is not owned by this resolved types");
    }
    return result;
  }
  
  @Override
  public LightweightTypeReference getExpectedType(final XExpression expression) {
    final LightweightTypeReference result = super.getExpectedType(expression);
    boolean _isOwnedBy = result.isOwnedBy(this.getReferenceOwner());
    boolean _not = (!_isOwnedBy);
    if (_not) {
      throw new IllegalArgumentException("result is not owned by this resolved types");
    }
    return result;
  }
  
  @Override
  public LightweightTypeReference getMergedType(final List<LightweightTypeReference> types) {
    final Consumer<LightweightTypeReference> _function = (LightweightTypeReference it) -> {
      boolean _isOwnedBy = it.isOwnedBy(it.getOwner());
      boolean _not = (!_isOwnedBy);
      if (_not) {
        throw new IllegalArgumentException("result is not owned by this resolved types");
      }
    };
    types.forEach(_function);
    final LightweightTypeReference result = super.getMergedType(types);
    boolean _isOwnedBy = result.isOwnedBy(this.getReferenceOwner());
    boolean _not = (!_isOwnedBy);
    if (_not) {
      throw new IllegalArgumentException("result is not owned by this resolved types");
    }
    return result;
  }
  
  @Override
  public TypeData mergeTypeData(final XExpression expression, final List<TypeData> allValues, final boolean returnType, final boolean nullIfEmpty) {
    final Consumer<TypeData> _function = (TypeData it) -> {
      boolean _isOwnedBy = it.isOwnedBy(this.getReferenceOwner());
      boolean _not = (!_isOwnedBy);
      if (_not) {
        throw new IllegalArgumentException("result is not owned by this resolved types");
      }
    };
    allValues.forEach(_function);
    final TypeData result = super.mergeTypeData(expression, allValues, returnType, nullIfEmpty);
    if (((result != null) && (!result.isOwnedBy(this.getReferenceOwner())))) {
      throw new IllegalArgumentException("result is not owned by this resolved types");
    }
    return result;
  }
}
