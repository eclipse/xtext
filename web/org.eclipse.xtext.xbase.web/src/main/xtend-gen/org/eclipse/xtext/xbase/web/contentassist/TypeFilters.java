/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.contentassist;

import com.google.common.base.Predicate;
import org.eclipse.xtext.xbase.web.scoping.ITypeDescriptor;
import org.objectweb.asm.Opcodes;

@SuppressWarnings("all")
final class TypeFilters {
  public final static Predicate<ITypeDescriptor> NON_ABSTRACT = new Predicate<ITypeDescriptor>() {
    @Override
    public boolean apply(final ITypeDescriptor typeDesc) {
      boolean _and = false;
      int _accessFlags = typeDesc.getAccessFlags();
      boolean _contains = TypeFilters.contains(_accessFlags, Opcodes.ACC_ABSTRACT);
      boolean _not = (!_contains);
      if (!_not) {
        _and = false;
      } else {
        int _accessFlags_1 = typeDesc.getAccessFlags();
        boolean _contains_1 = TypeFilters.contains(_accessFlags_1, Opcodes.ACC_INTERFACE);
        boolean _not_1 = (!_contains_1);
        _and = _not_1;
      }
      return _and;
    }
  };
  
  private static boolean contains(final int flags, final int code) {
    return ((flags & code) != 0);
  }
}
