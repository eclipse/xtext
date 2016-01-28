/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.validation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class ReferencedInvalidTypeFinder extends TypeReferenceVisitorWithResult<LightweightTypeReference> {
  @Inject
  private CommonTypeComputationServices services;
  
  public LightweightTypeReference findReferencedInvalidType(final JvmIdentifiableElement element) {
    return this.internalFindReferencedInvalidType(element);
  }
  
  protected LightweightTypeReference _internalFindReferencedInvalidType(final JvmIdentifiableElement field) {
    return null;
  }
  
  protected LightweightTypeReference _internalFindReferencedInvalidType(final JvmField field) {
    JvmTypeReference _type = field.getType();
    final LightweightTypeReference type = this.toLightweightTypeReference(_type);
    boolean _isPrimitiveVoid = type.isPrimitiveVoid();
    if (_isPrimitiveVoid) {
      return type;
    }
    return this.findUnknownType(type);
  }
  
  protected LightweightTypeReference _internalFindReferencedInvalidType(final JvmOperation operation) {
    JvmTypeReference _returnType = operation.getReturnType();
    final LightweightTypeReference unknownType = this.findUnknownType(_returnType);
    if ((unknownType != null)) {
      return unknownType;
    }
    return this._internalFindReferencedInvalidType(((JvmExecutable) operation));
  }
  
  protected LightweightTypeReference _internalFindReferencedInvalidType(final JvmExecutable executable) {
    EList<JvmTypeParameter> _typeParameters = executable.getTypeParameters();
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = new Function1<JvmTypeParameter, EList<JvmTypeConstraint>>() {
      @Override
      public EList<JvmTypeConstraint> apply(final JvmTypeParameter it) {
        return it.getConstraints();
      }
    };
    List<EList<JvmTypeConstraint>> _map = ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(_typeParameters, _function);
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(_map);
    final Function1<JvmTypeConstraint, JvmTypeReference> _function_1 = new Function1<JvmTypeConstraint, JvmTypeReference>() {
      @Override
      public JvmTypeReference apply(final JvmTypeConstraint it) {
        return it.getTypeReference();
      }
    };
    Iterable<JvmTypeReference> _map_1 = IterableExtensions.<JvmTypeConstraint, JvmTypeReference>map(_flatten, _function_1);
    for (final JvmTypeReference typeReference : _map_1) {
      {
        final LightweightTypeReference unknownType = this.findUnknownType(typeReference);
        if ((unknownType != null)) {
          return unknownType;
        }
      }
    }
    EList<JvmFormalParameter> _parameters = executable.getParameters();
    final Function1<JvmFormalParameter, LightweightTypeReference> _function_2 = new Function1<JvmFormalParameter, LightweightTypeReference>() {
      @Override
      public LightweightTypeReference apply(final JvmFormalParameter it) {
        JvmTypeReference _parameterType = it.getParameterType();
        return ReferencedInvalidTypeFinder.this.toLightweightTypeReference(_parameterType);
      }
    };
    List<LightweightTypeReference> _map_2 = ListExtensions.<JvmFormalParameter, LightweightTypeReference>map(_parameters, _function_2);
    for (final LightweightTypeReference parameterType : _map_2) {
      {
        boolean _isPrimitiveVoid = parameterType.isPrimitiveVoid();
        if (_isPrimitiveVoid) {
          return parameterType;
        }
        final LightweightTypeReference unknownType = this.findUnknownType(parameterType);
        if ((unknownType != null)) {
          return unknownType;
        }
      }
    }
    EList<JvmTypeReference> _exceptions = executable.getExceptions();
    for (final JvmTypeReference exception : _exceptions) {
      {
        final LightweightTypeReference unknownType = this.findUnknownType(exception);
        if ((unknownType != null)) {
          return unknownType;
        }
      }
    }
    return null;
  }
  
  protected LightweightTypeReference findUnknownType(final JvmTypeReference reference) {
    LightweightTypeReference _lightweightTypeReference = this.toLightweightTypeReference(reference);
    return this.findUnknownType(_lightweightTypeReference);
  }
  
  protected LightweightTypeReference findUnknownType(final LightweightTypeReference type) {
    return type.<LightweightTypeReference>accept(this);
  }
  
  @Override
  protected LightweightTypeReference doVisitTypeReference(final LightweightTypeReference reference) {
    boolean _isUnknown = reference.isUnknown();
    if (_isUnknown) {
      return reference;
    }
    return null;
  }
  
  @Override
  protected LightweightTypeReference doVisitArrayTypeReference(final ArrayTypeReference reference) {
    LightweightTypeReference _componentType = reference.getComponentType();
    return _componentType.<LightweightTypeReference>accept(this);
  }
  
  @Override
  protected LightweightTypeReference doVisitWildcardTypeReference(final WildcardTypeReference reference) {
    List<LightweightTypeReference> _upperBounds = reference.getUpperBounds();
    final LightweightTypeReference unknownType = this.visit(_upperBounds);
    if ((unknownType != null)) {
      return unknownType;
    }
    final LightweightTypeReference lowerBound = reference.getLowerBound();
    if ((lowerBound != null)) {
      return lowerBound.<LightweightTypeReference>accept(this);
    }
    return null;
  }
  
  @Override
  protected LightweightTypeReference doVisitParameterizedTypeReference(final ParameterizedTypeReference reference) {
    List<LightweightTypeReference> _typeArguments = reference.getTypeArguments();
    return this.visit(_typeArguments);
  }
  
  @Override
  protected LightweightTypeReference doVisitCompoundTypeReference(final CompoundTypeReference reference) {
    List<LightweightTypeReference> _multiTypeComponents = reference.getMultiTypeComponents();
    return this.visit(_multiTypeComponents);
  }
  
  protected LightweightTypeReference visit(final List<LightweightTypeReference> references) {
    final Function1<LightweightTypeReference, LightweightTypeReference> _function = new Function1<LightweightTypeReference, LightweightTypeReference>() {
      @Override
      public LightweightTypeReference apply(final LightweightTypeReference it) {
        return it.<LightweightTypeReference>accept(ReferencedInvalidTypeFinder.this);
      }
    };
    List<LightweightTypeReference> _map = ListExtensions.<LightweightTypeReference, LightweightTypeReference>map(references, _function);
    Iterable<LightweightTypeReference> _filterNull = IterableExtensions.<LightweightTypeReference>filterNull(_map);
    return IterableExtensions.<LightweightTypeReference>head(_filterNull);
  }
  
  protected LightweightTypeReference toLightweightTypeReference(final JvmTypeReference typeRef) {
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, typeRef);
    return _standardTypeReferenceOwner.toLightweightTypeReference(typeRef);
  }
  
  protected LightweightTypeReference internalFindReferencedInvalidType(final JvmIdentifiableElement operation) {
    if (operation instanceof JvmOperation) {
      return _internalFindReferencedInvalidType((JvmOperation)operation);
    } else if (operation instanceof JvmExecutable) {
      return _internalFindReferencedInvalidType((JvmExecutable)operation);
    } else if (operation instanceof JvmField) {
      return _internalFindReferencedInvalidType((JvmField)operation);
    } else if (operation != null) {
      return _internalFindReferencedInvalidType(operation);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(operation).toString());
    }
  }
}
