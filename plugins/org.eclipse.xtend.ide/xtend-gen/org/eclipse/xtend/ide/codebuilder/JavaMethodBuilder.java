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
      JvmVisibility _visibility = this.getVisibility();
      this.appendVisibility(appendable, _visibility, JvmVisibility.DEFAULT);
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      JvmTypeReference _returnType = this.getReturnType();
      IAppendable _appendType = this.appendType(appendable, _returnType, "void");
      IAppendable _append = _appendType.append(" ");
      String _methodName = this.getMethodName();
      IAppendable _append_1 = _append.append(_methodName);
      List<JvmTypeReference> _parameterTypes = this.getParameterTypes();
      IAppendable _appendParameters = this.appendParameters(_append_1, _parameterTypes);
      IAppendable _append_2 = _appendParameters.append(" {");
      IAppendable _increaseIndentation = _append_2.increaseIndentation();
      IAppendable _newLine = _increaseIndentation.newLine();
      IAppendable _appendDefaultBody = this.appendDefaultBody(_newLine, ";");
      IAppendable _decreaseIndentation = _appendDefaultBody.decreaseIndentation();
      IAppendable _newLine_1 = _decreaseIndentation.newLine();
      IAppendable _append_3 = _newLine_1.append("}");
      _xblockexpression = (_append_3);
    }
    return _xblockexpression;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
