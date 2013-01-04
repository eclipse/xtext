/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeReferenceImpl;
import org.eclipse.xtend.lib.macro.type.ParameterizedTypeReference;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtend.lib.macro.type.WildCardTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class WildCardTypeReferenceImpl extends JvmTypeReferenceImpl<JvmWildcardTypeReference> implements WildCardTypeReference {
  public ParameterizedTypeReference getLowerBound() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmWildcardTypeReference _delegate = this.getDelegate();
    EList<JvmTypeConstraint> _constraints = _delegate.getConstraints();
    Iterable<JvmLowerBound> _filter = Iterables.<JvmLowerBound>filter(_constraints, JvmLowerBound.class);
    JvmLowerBound _head = IterableExtensions.<JvmLowerBound>head(_filter);
    JvmTypeReference _typeReference = _head==null?(JvmTypeReference)null:_head.getTypeReference();
    TypeReference _typeReference_1 = _compilationUnit.toTypeReference(_typeReference);
    return ((ParameterizedTypeReference) _typeReference_1);
  }
  
  public ParameterizedTypeReference getUpperBound() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmWildcardTypeReference _delegate = this.getDelegate();
    EList<JvmTypeConstraint> _constraints = _delegate.getConstraints();
    Iterable<JvmUpperBound> _filter = Iterables.<JvmUpperBound>filter(_constraints, JvmUpperBound.class);
    JvmUpperBound _head = IterableExtensions.<JvmUpperBound>head(_filter);
    JvmTypeReference _typeReference = _head==null?(JvmTypeReference)null:_head.getTypeReference();
    TypeReference _typeReference_1 = _compilationUnit.toTypeReference(_typeReference);
    return ((ParameterizedTypeReference) _typeReference_1);
  }
}
