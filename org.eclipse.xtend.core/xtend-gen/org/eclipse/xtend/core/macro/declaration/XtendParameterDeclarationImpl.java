/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;

@SuppressWarnings("all")
public class XtendParameterDeclarationImpl extends XtendAnnotationTargetImpl<XtendParameter> implements ParameterDeclaration {
  @Override
  public TypeReference getType() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getParameterType());
  }

  @Override
  public String getSimpleName() {
    return this.getDelegate().getName();
  }

  @Override
  public ExecutableDeclaration getDeclaringExecutable() {
    EObject _eContainer = this.getDelegate().eContainer();
    MemberDeclaration _xtendMemberDeclaration = this.getCompilationUnit().toXtendMemberDeclaration(((XtendMember) _eContainer));
    return ((ExecutableDeclaration) _xtendMemberDeclaration);
  }
}
