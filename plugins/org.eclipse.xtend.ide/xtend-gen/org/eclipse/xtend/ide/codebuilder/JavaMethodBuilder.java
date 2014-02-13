/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class JavaMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder.Java {
  public boolean isValid() {
    boolean _and = false;
    boolean _isValid = super.isValid();
    if (!_isValid) {
      _and = false;
    } else {
      String _methodName = this.getMethodName();
      boolean _notEquals = (!Objects.equal(_methodName, null));
      _and = _notEquals;
    }
    return _and;
  }
  
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      boolean _isOverrideFlag = this.isOverrideFlag();
      if (_isOverrideFlag) {
        ISourceAppender _append = appendable.append("@Override");
        _append.newLine();
      }
      JvmVisibility _visibility = this.getVisibility();
      this.appendVisibility(appendable, _visibility, JvmVisibility.DEFAULT);
      boolean _isAbstractFlag = this.isAbstractFlag();
      if (_isAbstractFlag) {
        appendable.append("abstract ");
      }
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      List<JvmTypeParameter> _typeParameters = this.getTypeParameters();
      ISourceAppender _appendTypeParameters = this.appendTypeParameters(appendable, _typeParameters);
      LightweightTypeReference _returnType = this.getReturnType();
      ISourceAppender _appendType = this.appendType(_appendTypeParameters, _returnType, "void");
      ISourceAppender _append_1 = _appendType.append(" ");
      String _methodName = this.getMethodName();
      ISourceAppender _append_2 = _append_1.append(_methodName);
      ISourceAppender _appendParameters = this.appendParameters(_append_2);
      this.appendThrowsClause(_appendParameters);
      boolean _isAbstractFlag_1 = this.isAbstractFlag();
      if (_isAbstractFlag_1) {
        appendable.append(";");
      } else {
        this.appendBody(appendable, ";");
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
