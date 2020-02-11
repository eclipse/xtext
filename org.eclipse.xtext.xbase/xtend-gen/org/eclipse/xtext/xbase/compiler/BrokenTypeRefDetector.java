/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * A visitor that detects broken type references. Returns <code>true</code> if a broken reference
 * was detected.
 */
@SuppressWarnings("all")
public class BrokenTypeRefDetector extends AbstractTypeReferenceVisitor.InheritanceAware<Boolean> {
  @Override
  protected Boolean handleNullReference() {
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean doVisitTypeReference(final JvmTypeReference it) {
    return Boolean.valueOf(((it.getType() == null) || it.getType().eIsProxy()));
  }
  
  @Override
  public Boolean doVisitCompoundTypeReference(final JvmCompoundTypeReference it) {
    return Boolean.valueOf(((this.doVisitTypeReference(it)).booleanValue() || IterableExtensions.<JvmTypeReference>exists(it.getReferences(), ((Function1<JvmTypeReference, Boolean>) (JvmTypeReference it_1) -> {
      return this.visit(it_1);
    }))));
  }
  
  @Override
  public Boolean doVisitParameterizedTypeReference(final JvmParameterizedTypeReference it) {
    return Boolean.valueOf(((this.doVisitTypeReference(it)).booleanValue() || IterableExtensions.<JvmTypeReference>exists(it.getArguments(), ((Function1<JvmTypeReference, Boolean>) (JvmTypeReference it_1) -> {
      return this.visit(it_1);
    }))));
  }
  
  @Override
  public Boolean doVisitWildcardTypeReference(final JvmWildcardTypeReference it) {
    final Function1<JvmTypeConstraint, Boolean> _function = (JvmTypeConstraint it_1) -> {
      return this.visit(it_1.getTypeReference());
    };
    return Boolean.valueOf(IterableExtensions.<JvmTypeConstraint>exists(it.getConstraints(), _function));
  }
}
