/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendEnumerationDeclarationImpl extends XtendTypeDeclarationImpl<XtendEnum> implements EnumerationTypeDeclaration {
  public EnumerationValueDeclaration findDeclaredValue(final String name) {
    Iterable<? extends EnumerationValueDeclaration> _declaredValues = this.getDeclaredValues();
    final Function1<EnumerationValueDeclaration,Boolean> _function = new Function1<EnumerationValueDeclaration,Boolean>() {
      public Boolean apply(final EnumerationValueDeclaration value) {
        String _simpleName = value.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredValues, _function);
  }
  
  public Iterable<? extends EnumerationValueDeclaration> getDeclaredValues() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<EnumerationValueDeclaration>filter(_declaredMembers, EnumerationValueDeclaration.class);
  }
}
