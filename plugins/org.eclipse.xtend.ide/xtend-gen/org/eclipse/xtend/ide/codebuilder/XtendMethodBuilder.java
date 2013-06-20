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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Xtend;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class XtendMethodBuilder extends AbstractMethodBuilder implements Xtend {
  @Inject
  private XtypeTypeReferenceSerializer typeRefSerializer;
  
  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;
  
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
      IAppendable _append = appendable.append("def ");
      JvmVisibility _visibility = this.getVisibility();
      this.appendVisibility(_append, _visibility, JvmVisibility.PUBLIC);
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      boolean _isAbstractFlag = this.isAbstractFlag();
      if (_isAbstractFlag) {
        JvmTypeReference _returnType = this.getReturnType();
        IAppendable _appendType = this.appendType(appendable, _returnType, "void");
        _appendType.append(" ");
      }
      String _methodName = this.getMethodName();
      IAppendable _append_1 = appendable.append(_methodName);
      List<JvmTypeReference> _parameterTypes = this.getParameterTypes();
      IAppendable _appendParameters = this.appendParameters(_append_1, _parameterTypes);
      IAppendable _appendDefaultBody = this.appendDefaultBody(_appendParameters, "");
      _xblockexpression = (_appendDefaultBody);
    }
    return _xblockexpression;
  }
  
  public int getInsertOffset() {
    EObject _context = this.getContext();
    XtendTypeDeclaration _xtendType = this.getXtendType();
    int _newMethodInsertOffset = this._insertionOffsets.getNewMethodInsertOffset(_context, _xtendType);
    return _newMethodInsertOffset;
  }
  
  public int getIndentationLevel() {
    return 1;
  }
  
  public XtendTypeDeclaration getXtendType() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendTypeDeclaration) _ownerSource);
  }
}
