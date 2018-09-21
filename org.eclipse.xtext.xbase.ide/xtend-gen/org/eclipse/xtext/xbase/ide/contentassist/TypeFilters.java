/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.base.Predicate;
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor;
import org.objectweb.asm.Opcodes;

@SuppressWarnings("all")
final class TypeFilters {
  public static final Predicate<ITypeDescriptor> NON_ABSTRACT = ((Predicate<ITypeDescriptor>) (ITypeDescriptor typeDesc) -> {
    return ((!TypeFilters.contains(typeDesc.getAccessFlags(), Opcodes.ACC_ABSTRACT)) && (!TypeFilters.contains(typeDesc.getAccessFlags(), Opcodes.ACC_INTERFACE)));
  });
  
  private static boolean contains(final int flags, final int code) {
    return ((flags & code) != 0);
  }
}
