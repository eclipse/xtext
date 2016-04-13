/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.core.macro.declaration.AbstractDelegator;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.UnknownType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class TypeReferenceImpl extends AbstractDelegator<LightweightTypeReference> implements TypeReference {
  @Accessors
  private JvmTypeReference source;
  
  @Override
  public String getName() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.getJavaIdentifier();
  }
  
  @Override
  public String getSimpleName() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.getSimpleName();
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
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      String _packageName = _compilationUnit_1.getPackageName();
      String _plus = (_packageName + ".");
      String _simpleName = it.getSimpleName();
      String _plus_1 = (_plus + _simpleName);
      _switchResult = new UnknownType(_compilationUnit, _plus_1);
    }
    if (!_matched) {
      CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
      JvmType _type = it.getType();
      _switchResult = _compilationUnit_2.toType(_type);
    }
    return _switchResult;
  }
  
  @Override
  public String toString() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.toString();
  }
  
  @Override
  public List<TypeReference> getActualTypeArguments() {
    LightweightTypeReference _delegate = this.getDelegate();
    List<LightweightTypeReference> _typeArguments = _delegate.getTypeArguments();
    final Function1<LightweightTypeReference, TypeReference> _function = new Function1<LightweightTypeReference, TypeReference>() {
      @Override
      public TypeReference apply(final LightweightTypeReference it) {
        CompilationUnitImpl _compilationUnit = TypeReferenceImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeReference(it);
      }
    };
    return ListExtensions.<LightweightTypeReference, TypeReference>map(_typeArguments, _function);
  }
  
  @Override
  public TypeReference getArrayComponentType() {
    LightweightTypeReference _delegate = this.getDelegate();
    final LightweightTypeReference componentType = _delegate.getComponentType();
    if ((componentType == null)) {
      return null;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    return _compilationUnit.toTypeReference(componentType);
  }
  
  @Override
  public TypeReference getLowerBound() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _lowerBoundSubstitute = _delegate.getLowerBoundSubstitute();
    return _compilationUnit.toTypeReference(_lowerBoundSubstitute);
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
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      LightweightTypeReference _delegate = this.getDelegate();
      LightweightTypeReference _primitiveIfWrapperType = _delegate.getPrimitiveIfWrapperType();
      _xblockexpression = _compilationUnit.toTypeReference(_primitiveIfWrapperType);
    }
    return _xblockexpression;
  }
  
  @Override
  public TypeReference getUpperBound() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _upperBoundSubstitute = _delegate.getUpperBoundSubstitute();
    return _compilationUnit.toTypeReference(_upperBoundSubstitute);
  }
  
  @Override
  public TypeReference getWrapperIfPrimitive() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _wrapperTypeIfPrimitive = _delegate.getWrapperTypeIfPrimitive();
    return _compilationUnit.toTypeReference(_wrapperTypeIfPrimitive);
  }
  
  @Override
  public boolean isAnyType() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isAny();
  }
  
  @Override
  public boolean isArray() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isArray();
  }
  
  @Override
  public boolean isAssignableFrom(final TypeReference typeReference) {
    boolean _xblockexpression = false;
    {
      boolean _isInferred = typeReference.isInferred();
      if (_isInferred) {
        throw new UnsupportedOperationException("Cannot check assignability with an inferred type reference.");
      }
      LightweightTypeReference _delegate = this.getDelegate();
      LightweightTypeReference _delegate_1 = ((TypeReferenceImpl) typeReference).getDelegate();
      _xblockexpression = _delegate.isAssignableFrom(_delegate_1);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isPrimitive() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isPrimitive();
  }
  
  @Override
  public boolean isVoid() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isPrimitiveVoid();
  }
  
  @Override
  public boolean isWildCard() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isWildcard();
  }
  
  @Override
  public boolean isWrapper() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isWrapper();
  }
  
  public LightweightTypeReference getLightweightTypeReference() {
    return this.getDelegate();
  }
  
  @Override
  public Iterable<? extends TypeReference> getDeclaredSuperTypes() {
    LightweightTypeReference _delegate = this.getDelegate();
    List<LightweightTypeReference> _superTypes = _delegate.getSuperTypes();
    final Function1<LightweightTypeReference, TypeReference> _function = new Function1<LightweightTypeReference, TypeReference>() {
      @Override
      public TypeReference apply(final LightweightTypeReference it) {
        CompilationUnitImpl _compilationUnit = TypeReferenceImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeReference(it);
      }
    };
    return ListExtensions.<LightweightTypeReference, TypeReference>map(_superTypes, _function);
  }
  
  @Override
  public Iterable<? extends ResolvedMethod> getDeclaredResolvedMethods() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    OverrideHelper _overrideHelper = _compilationUnit.getOverrideHelper();
    LightweightTypeReference _delegate = this.getDelegate();
    ResolvedFeatures _resolvedFeatures = _overrideHelper.getResolvedFeatures(_delegate);
    List<IResolvedOperation> _declaredOperations = _resolvedFeatures.getDeclaredOperations();
    final Function1<IResolvedOperation, ResolvedMethod> _function = new Function1<IResolvedOperation, ResolvedMethod>() {
      @Override
      public ResolvedMethod apply(final IResolvedOperation it) {
        CompilationUnitImpl _compilationUnit = TypeReferenceImpl.this.getCompilationUnit();
        return _compilationUnit.toResolvedMethod(it);
      }
    };
    return ListExtensions.<IResolvedOperation, ResolvedMethod>map(_declaredOperations, _function);
  }
  
  @Override
  public Iterable<? extends ResolvedConstructor> getDeclaredResolvedConstructors() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    OverrideHelper _overrideHelper = _compilationUnit.getOverrideHelper();
    LightweightTypeReference _delegate = this.getDelegate();
    ResolvedFeatures _resolvedFeatures = _overrideHelper.getResolvedFeatures(_delegate);
    List<IResolvedConstructor> _declaredConstructors = _resolvedFeatures.getDeclaredConstructors();
    final Function1<IResolvedConstructor, ResolvedConstructor> _function = new Function1<IResolvedConstructor, ResolvedConstructor>() {
      @Override
      public ResolvedConstructor apply(final IResolvedConstructor it) {
        CompilationUnitImpl _compilationUnit = TypeReferenceImpl.this.getCompilationUnit();
        return _compilationUnit.toResolvedConstructor(it);
      }
    };
    return ListExtensions.<IResolvedConstructor, ResolvedConstructor>map(_declaredConstructors, _function);
  }
  
  @Override
  public Iterable<? extends ResolvedMethod> getAllResolvedMethods() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    OverrideHelper _overrideHelper = _compilationUnit.getOverrideHelper();
    LightweightTypeReference _delegate = this.getDelegate();
    ResolvedFeatures _resolvedFeatures = _overrideHelper.getResolvedFeatures(_delegate);
    List<IResolvedOperation> _allOperations = _resolvedFeatures.getAllOperations();
    final Function1<IResolvedOperation, ResolvedMethod> _function = new Function1<IResolvedOperation, ResolvedMethod>() {
      @Override
      public ResolvedMethod apply(final IResolvedOperation it) {
        CompilationUnitImpl _compilationUnit = TypeReferenceImpl.this.getCompilationUnit();
        return _compilationUnit.toResolvedMethod(it);
      }
    };
    return ListExtensions.<IResolvedOperation, ResolvedMethod>map(_allOperations, _function);
  }
  
  @Override
  public boolean isInferred() {
    return false;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof TypeReferenceImpl)) {
      LightweightTypeReference _delegate = this.getDelegate();
      String _identifier = _delegate.getIdentifier();
      LightweightTypeReference _delegate_1 = ((TypeReferenceImpl)obj).getDelegate();
      String _identifier_1 = _delegate_1.getIdentifier();
      return Objects.equal(_identifier, _identifier_1);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    LightweightTypeReference _delegate = this.getDelegate();
    String _identifier = _delegate.getIdentifier();
    return _identifier.hashCode();
  }
  
  @Pure
  public JvmTypeReference getSource() {
    return this.source;
  }
  
  public void setSource(final JvmTypeReference source) {
    this.source = source;
  }
}
