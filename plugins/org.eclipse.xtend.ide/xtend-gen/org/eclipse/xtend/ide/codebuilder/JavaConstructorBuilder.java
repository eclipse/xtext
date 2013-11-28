/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

@SuppressWarnings("all")
public class JavaConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder.Java {
  public ISourceAppender build(final ISourceAppender appendable) {
    JvmVisibility _visibility = this.getVisibility();
    ISourceAppender _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.PUBLIC);
    JvmDeclaredType _owner = this.getOwner();
    String _simpleName = _owner.getSimpleName();
    ISourceAppender _append = _appendVisibility.append(_simpleName);
    ISourceAppender _appendParameters = this.appendParameters(_append);
    ISourceAppender _appendThrowsClause = this.appendThrowsClause(_appendParameters);
    ISourceAppender _appendBody = this.appendBody(_appendThrowsClause, ";");
    return _appendBody;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
