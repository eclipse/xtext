/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class BrokenTypeRefDetector extends AbstractTypeReferenceVisitor.InheritanceAware<Boolean> {
  protected Boolean handleNullReference() {
    return Boolean.valueOf(true);
  }
  
  public Boolean doVisitTypeReference(final JvmTypeReference it) {
    boolean _or = false;
    JvmType _type = it.getType();
    boolean _equals = Objects.equal(_type, null);
    if (_equals) {
      _or = true;
    } else {
      JvmType _type_1 = it.getType();
      boolean _eIsProxy = _type_1.eIsProxy();
      _or = (_equals || _eIsProxy);
    }
    return Boolean.valueOf(_or);
  }
  
  public Boolean doVisitCompoundTypeReference(final JvmCompoundTypeReference it) {
    boolean _or = false;
    Boolean _doVisitTypeReference = this.doVisitTypeReference(it);
    if ((_doVisitTypeReference).booleanValue()) {
      _or = true;
    } else {
      EList<JvmTypeReference> _references = it.getReferences();
      final Function1<JvmTypeReference,Boolean> _function = new Function1<JvmTypeReference,Boolean>() {
        public Boolean apply(final JvmTypeReference it) {
          Boolean _visit = BrokenTypeRefDetector.this.visit(it);
          return _visit;
        }
      };
      boolean _exists = IterableExtensions.<JvmTypeReference>exists(_references, _function);
      _or = ((_doVisitTypeReference).booleanValue() || _exists);
    }
    return Boolean.valueOf(_or);
  }
  
  public Boolean doVisitParameterizedTypeReference(final JvmParameterizedTypeReference it) {
    boolean _or = false;
    Boolean _doVisitTypeReference = this.doVisitTypeReference(it);
    if ((_doVisitTypeReference).booleanValue()) {
      _or = true;
    } else {
      EList<JvmTypeReference> _arguments = it.getArguments();
      final Function1<JvmTypeReference,Boolean> _function = new Function1<JvmTypeReference,Boolean>() {
        public Boolean apply(final JvmTypeReference it) {
          Boolean _visit = BrokenTypeRefDetector.this.visit(it);
          return _visit;
        }
      };
      boolean _exists = IterableExtensions.<JvmTypeReference>exists(_arguments, _function);
      _or = ((_doVisitTypeReference).booleanValue() || _exists);
    }
    return Boolean.valueOf(_or);
  }
  
  public Boolean doVisitWildcardTypeReference(final JvmWildcardTypeReference it) {
    EList<JvmTypeConstraint> _constraints = it.getConstraints();
    final Function1<JvmTypeConstraint,Boolean> _function = new Function1<JvmTypeConstraint,Boolean>() {
      public Boolean apply(final JvmTypeConstraint it) {
        JvmTypeReference _typeReference = it.getTypeReference();
        Boolean _visit = BrokenTypeRefDetector.this.visit(_typeReference);
        return _visit;
      }
    };
    boolean _exists = IterableExtensions.<JvmTypeConstraint>exists(_constraints, _function);
    return Boolean.valueOf(_exists);
  }
}
