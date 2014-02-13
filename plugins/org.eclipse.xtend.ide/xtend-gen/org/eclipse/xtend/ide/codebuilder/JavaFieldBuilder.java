/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class JavaFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Java {
  public boolean isValid() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _isValid = super.isValid();
    if (!_isValid) {
      _and_1 = false;
    } else {
      String _fieldName = this.getFieldName();
      boolean _notEquals = (!Objects.equal(_fieldName, null));
      _and_1 = _notEquals;
    }
    if (!_and_1) {
      _and = false;
    } else {
      LightweightTypeReference _fieldType = this.getFieldType();
      boolean _notEquals_1 = (!Objects.equal(_fieldType, null));
      _and = _notEquals_1;
    }
    return _and;
  }
  
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      JvmVisibility _visibility = this.getVisibility();
      this.appendVisibility(appendable, _visibility, JvmVisibility.DEFAULT);
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      LightweightTypeReference _fieldType = this.getFieldType();
      ISourceAppender _appendType = this.appendType(appendable, _fieldType, "Object");
      ISourceAppender _append = _appendType.append(" ");
      String _fieldName = this.getFieldName();
      ISourceAppender _append_1 = _append.append(_fieldName);
      _xblockexpression = _append_1.append(";");
    }
    return _xblockexpression;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
