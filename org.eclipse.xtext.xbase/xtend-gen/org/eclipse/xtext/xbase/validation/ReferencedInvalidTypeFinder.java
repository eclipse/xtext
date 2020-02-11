/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
  
  protected LightweightTypeReference _internalFindReferencedInvalidType(final Void field) {
    return null;
  }
  
  protected LightweightTypeReference _internalFindReferencedInvalidType(final JvmField field) {
    final LightweightTypeReference type = this.toLightweightTypeReference(field.getType());
    boolean _isPrimitiveVoid = type.isPrimitiveVoid();
    if (_isPrimitiveVoid) {
      return type;
    }
    return this.findUnknownType(type);
  }
  
  protected LightweightTypeReference _internalFindReferencedInvalidType(final JvmOperation operation) {
    final LightweightTypeReference unknownType = this.findUnknownType(operation.getReturnType());
    if ((unknownType != null)) {
      return unknownType;
    }
    return this._internalFindReferencedInvalidType(((JvmExecutable) operation));
  }
  
  protected LightweightTypeReference _internalFindReferencedInvalidType(final JvmExecutable executable) {
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = (JvmTypeParameter it) -> {
      return it.getConstraints();
    };
    final Function1<JvmTypeConstraint, JvmTypeReference> _function_1 = (JvmTypeConstraint it) -> {
      return it.getTypeReference();
    };
    Iterable<JvmTypeReference> _map = IterableExtensions.<JvmTypeConstraint, JvmTypeReference>map(Iterables.<JvmTypeConstraint>concat(ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(executable.getTypeParameters(), _function)), _function_1);
    for (final JvmTypeReference typeReference : _map) {
      {
        final LightweightTypeReference unknownType = this.findUnknownType(typeReference);
        if ((unknownType != null)) {
          return unknownType;
        }
      }
    }
    final Function1<JvmFormalParameter, LightweightTypeReference> _function_2 = (JvmFormalParameter it) -> {
      return this.toLightweightTypeReference(it.getParameterType());
    };
    List<LightweightTypeReference> _map_1 = ListExtensions.<JvmFormalParameter, LightweightTypeReference>map(executable.getParameters(), _function_2);
    for (final LightweightTypeReference parameterType : _map_1) {
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
    return this.findUnknownType(this.toLightweightTypeReference(reference));
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
    return reference.getComponentType().<LightweightTypeReference>accept(this);
  }
  
  @Override
  protected LightweightTypeReference doVisitWildcardTypeReference(final WildcardTypeReference reference) {
    final LightweightTypeReference unknownType = this.visit(reference.getUpperBounds());
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
    return this.visit(reference.getTypeArguments());
  }
  
  @Override
  protected LightweightTypeReference doVisitCompoundTypeReference(final CompoundTypeReference reference) {
    return this.visit(reference.getMultiTypeComponents());
  }
  
  protected LightweightTypeReference visit(final List<LightweightTypeReference> references) {
    final Function1<LightweightTypeReference, LightweightTypeReference> _function = (LightweightTypeReference it) -> {
      return it.<LightweightTypeReference>accept(this);
    };
    return IterableExtensions.<LightweightTypeReference>head(IterableExtensions.<LightweightTypeReference>filterNull(ListExtensions.<LightweightTypeReference, LightweightTypeReference>map(references, _function)));
  }
  
  protected LightweightTypeReference toLightweightTypeReference(final JvmTypeReference typeRef) {
    return new StandardTypeReferenceOwner(this.services, typeRef).toLightweightTypeReference(typeRef);
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
    } else if (operation == null) {
      return _internalFindReferencedInvalidType((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(operation).toString());
    }
  }
}
