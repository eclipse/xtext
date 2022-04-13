/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class TypeReferenceImpl extends AbstractDelegator<LightweightTypeReference> implements TypeReference {
  @Accessors
  private JvmTypeReference source;

  @Override
  public String getName() {
    return this.getDelegate().getJavaIdentifier();
  }

  @Override
  public String getSimpleName() {
    return this.getDelegate().getSimpleName();
  }

  @Override
  public Type getType() {
    Type _switchResult = null;
    LightweightTypeReference _delegate = this.getDelegate();
    final LightweightTypeReference it = _delegate;
    boolean _matched = false;
    boolean _isUnknown = it.isUnknown();
    if (_isUnknown) {
      _matched=true;
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      String _packageName = this.getCompilationUnit().getPackageName();
      String _plus = (_packageName + ".");
      String _simpleName = it.getSimpleName();
      String _plus_1 = (_plus + _simpleName);
      _switchResult = new UnknownType(_compilationUnit, _plus_1);
    }
    if (!_matched) {
      _switchResult = this.getCompilationUnit().toType(it.getType());
    }
    return _switchResult;
  }

  @Override
  public String toString() {
    return this.getDelegate().toString();
  }

  @Override
  public List<TypeReference> getActualTypeArguments() {
    final Function1<LightweightTypeReference, TypeReference> _function = (LightweightTypeReference it) -> {
      return this.getCompilationUnit().toTypeReference(it);
    };
    return ListExtensions.<LightweightTypeReference, TypeReference>map(this.getDelegate().getTypeArguments(), _function);
  }

  @Override
  public TypeReference getArrayComponentType() {
    final LightweightTypeReference componentType = this.getDelegate().getComponentType();
    if ((componentType == null)) {
      return null;
    }
    return this.getCompilationUnit().toTypeReference(componentType);
  }

  @Override
  public TypeReference getLowerBound() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getLowerBoundSubstitute());
  }

  @Override
  public TypeReference getPrimitiveIfWrapper() {
    TypeReference _xblockexpression = null;
    {
      boolean _isWrapper = this.isWrapper();
      boolean _not = (!_isWrapper);
      if (_not) {
        return this;
      }
      _xblockexpression = this.getCompilationUnit().toTypeReference(this.getDelegate().getPrimitiveIfWrapperType());
    }
    return _xblockexpression;
  }

  @Override
  public TypeReference getUpperBound() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getUpperBoundSubstitute());
  }

  @Override
  public TypeReference getWrapperIfPrimitive() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getWrapperTypeIfPrimitive());
  }

  @Override
  public boolean isAnyType() {
    return this.getDelegate().isAny();
  }

  @Override
  public boolean isArray() {
    return this.getDelegate().isArray();
  }

  @Override
  public boolean isAssignableFrom(final TypeReference typeReference) {
    boolean _xblockexpression = false;
    {
      boolean _isInferred = typeReference.isInferred();
      if (_isInferred) {
        throw new UnsupportedOperationException("Cannot check assignability with an inferred type reference.");
      }
      _xblockexpression = this.getDelegate().isAssignableFrom(((TypeReferenceImpl) typeReference).getDelegate());
    }
    return _xblockexpression;
  }

  @Override
  public boolean isPrimitive() {
    return this.getDelegate().isPrimitive();
  }

  @Override
  public boolean isVoid() {
    return this.getDelegate().isPrimitiveVoid();
  }

  @Override
  public boolean isWildCard() {
    return this.getDelegate().isWildcard();
  }

  @Override
  public boolean isWrapper() {
    return this.getDelegate().isWrapper();
  }

  public LightweightTypeReference getLightweightTypeReference() {
    return this.getDelegate();
  }

  @Override
  public Iterable<? extends TypeReference> getDeclaredSuperTypes() {
    final Function1<LightweightTypeReference, TypeReference> _function = (LightweightTypeReference it) -> {
      return this.getCompilationUnit().toTypeReference(it);
    };
    return ListExtensions.<LightweightTypeReference, TypeReference>map(this.getDelegate().getSuperTypes(), _function);
  }

  @Override
  public Iterable<? extends ResolvedMethod> getDeclaredResolvedMethods() {
    final Function1<IResolvedOperation, ResolvedMethod> _function = (IResolvedOperation it) -> {
      return this.getCompilationUnit().toResolvedMethod(it);
    };
    return ListExtensions.<IResolvedOperation, ResolvedMethod>map(this.getCompilationUnit().getOverrideHelper().getResolvedFeatures(this.getDelegate()).getDeclaredOperations(), _function);
  }

  @Override
  public Iterable<? extends ResolvedConstructor> getDeclaredResolvedConstructors() {
    final Function1<IResolvedConstructor, ResolvedConstructor> _function = (IResolvedConstructor it) -> {
      return this.getCompilationUnit().toResolvedConstructor(it);
    };
    return ListExtensions.<IResolvedConstructor, ResolvedConstructor>map(this.getCompilationUnit().getOverrideHelper().getResolvedFeatures(this.getDelegate()).getDeclaredConstructors(), _function);
  }

  @Override
  public Iterable<? extends ResolvedMethod> getAllResolvedMethods() {
    final Function1<IResolvedOperation, ResolvedMethod> _function = (IResolvedOperation it) -> {
      return this.getCompilationUnit().toResolvedMethod(it);
    };
    return ListExtensions.<IResolvedOperation, ResolvedMethod>map(this.getCompilationUnit().getOverrideHelper().getResolvedFeatures(this.getDelegate()).getAllOperations(), _function);
  }

  @Override
  public boolean isInferred() {
    return false;
  }

  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof TypeReferenceImpl)) {
      String _identifier = this.getDelegate().getIdentifier();
      String _identifier_1 = ((TypeReferenceImpl)obj).getDelegate().getIdentifier();
      return Objects.equal(_identifier, _identifier_1);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return this.getDelegate().getIdentifier().hashCode();
  }

  @Pure
  public JvmTypeReference getSource() {
    return this.source;
  }

  public void setSource(final JvmTypeReference source) {
    this.source = source;
  }
}
