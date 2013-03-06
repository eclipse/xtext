/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Xtend;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class XtendFieldBuilder extends AbstractFieldBuilder implements Xtend {
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
      String _fieldName = this.getFieldName();
      boolean _notEquals = ObjectExtensions.operator_notEquals(_fieldName, null);
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
      this.appendVisibility(appendable, _visibility, JvmVisibility.PRIVATE);
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      JvmTypeReference _fieldType = this.getFieldType();
      IAppendable _appendType = this.appendType(appendable, _fieldType, "Object");
      IAppendable _append = _appendType.append(" ");
      String _fieldName = this.getFieldName();
      IAppendable _append_1 = _append.append(_fieldName);
      _xblockexpression = (_append_1);
    }
    return _xblockexpression;
  }
  
  public int getInsertOffset() {
    EObject _context = this.getContext();
    XtendTypeDeclaration _xtendType = this.getXtendType();
    int _newFieldInsertOffset = this._insertionOffsets.getNewFieldInsertOffset(_context, _xtendType);
    return _newFieldInsertOffset;
  }
  
  public int getIndentationLevel() {
    return 1;
  }
  
  public XtendTypeDeclaration getXtendType() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendClass) _ownerSource);
  }
}
