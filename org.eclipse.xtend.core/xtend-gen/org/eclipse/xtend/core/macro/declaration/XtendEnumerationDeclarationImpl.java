/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendEnumerationDeclarationImpl extends XtendTypeDeclarationImpl<XtendEnum> implements EnumerationTypeDeclaration {
  @Override
  public EnumerationValueDeclaration findDeclaredValue(final String name) {
    final Function1<EnumerationValueDeclaration, Boolean> _function = (EnumerationValueDeclaration value) -> {
      String _simpleName = value.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    return IterableExtensions.findFirst(this.getDeclaredValues(), _function);
  }

  @Override
  public Iterable<? extends EnumerationValueDeclaration> getDeclaredValues() {
    return Iterables.<EnumerationValueDeclaration>filter(this.getDeclaredMembers(), EnumerationValueDeclaration.class);
  }
}
