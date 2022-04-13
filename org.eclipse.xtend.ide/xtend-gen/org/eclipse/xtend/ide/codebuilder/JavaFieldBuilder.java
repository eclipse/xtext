/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Java {
  @Override
  public boolean isValid() {
    return ((super.isValid() && (this.getFieldName() != null)) && (this.getFieldType() != null));
  }

  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      this.appendVisibility(appendable, this.getVisibility(), JvmVisibility.DEFAULT);
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      boolean _isFinalFlag = this.isFinalFlag();
      if (_isFinalFlag) {
        appendable.append("final ");
      }
      this.appendType(appendable, this.getFieldType(), "Object").append(" ").append(this.getFieldName());
      boolean _isFinalFlag_1 = this.isFinalFlag();
      if (_isFinalFlag_1) {
        this.appendDefaultValueLiteral(appendable.append(" = "), this.getFieldType(), "null");
      }
      _xblockexpression = appendable.append(";");
    }
    return _xblockexpression;
  }

  @Override
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }

  @Override
  public String getPrimitiveKindRepresentation(final Primitives.Primitive primitiveKind) {
    String _switchResult = null;
    if (primitiveKind != null) {
      switch (primitiveKind) {
        case Boolean:
          _switchResult = "false";
          break;
        default:
          String _simpleName = this.getFieldType().getSimpleName();
          String _plus = ("(" + _simpleName);
          _switchResult = (_plus + " 0");
          break;
      }
    } else {
      String _simpleName = this.getFieldType().getSimpleName();
      String _plus = ("(" + _simpleName);
      _switchResult = (_plus + " 0");
    }
    return _switchResult;
  }
}
