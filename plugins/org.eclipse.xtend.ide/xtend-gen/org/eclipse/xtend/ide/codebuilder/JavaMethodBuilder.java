/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Java;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public class JavaMethodBuilder extends AbstractMethodBuilder implements Java {
  @Inject
  private TypeReferenceSerializer typeRefSerializer;
  
  public boolean isValid() {
    boolean _and = false;
    boolean _isValid = super.isValid();
    if (!_isValid) {
      _and = false;
    } else {
      String _methodName = this.getMethodName();
      boolean _notEquals = (!Objects.equal(_methodName, null));
      _and = (_isValid && _notEquals);
    }
    return _and;
  }
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    IAppendable _xblockexpression = null;
    {
      boolean _isOverrideFlag = this.isOverrideFlag();
      if (_isOverrideFlag) {
        IAppendable _append = appendable.append("@Override");
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
      IAppendable _appendTypeParameters = this.appendTypeParameters(appendable, _typeParameters);
      JvmTypeReference _returnType = this.getReturnType();
      IAppendable _appendType = this.appendType(_appendTypeParameters, _returnType, "void");
      IAppendable _append_1 = _appendType.append(" ");
      String _methodName = this.getMethodName();
      IAppendable _append_2 = _append_1.append(_methodName);
      IAppendable _appendParameters = this.appendParameters(_append_2);
      IAppendable _appendThrowsClause = this.appendThrowsClause(_appendParameters);
      this.appendBody(_appendThrowsClause, ";");
      boolean _isAbstractFlag_1 = this.isAbstractFlag();
      if (_isAbstractFlag_1) {
        appendable.append(";");
      }
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
