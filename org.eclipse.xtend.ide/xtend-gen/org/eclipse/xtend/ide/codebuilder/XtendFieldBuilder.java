/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Xtend {
  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;

  @Override
  public boolean isValid() {
    return (super.isValid() && (this.getFieldName() != null));
  }

  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      this.appendVisibility(appendable, this.getVisibility(), JvmVisibility.PRIVATE);
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      boolean _isFinalFlag = this.isFinalFlag();
      if (_isFinalFlag) {
        appendable.append("val ");
      }
      this.appendType(appendable, this.getFieldType(), "Object").append(" ").append(this.getFieldName());
      boolean _isFinalFlag_1 = this.isFinalFlag();
      if (_isFinalFlag_1) {
        this.appendDefaultValueLiteral(appendable.append(" = "), this.getFieldType(), "null");
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }

  @Override
  public int getInsertOffset(final XtextResource resource) {
    return this._insertionOffsets.getNewFieldInsertOffset(this.getContext(), this.<XtendTypeDeclaration>findByFragment(resource, this.getXtendType()));
  }

  @Override
  public int getIndentationLevel() {
    return 1;
  }

  @Override
  public XtendTypeDeclaration getXtendType() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendTypeDeclaration) _ownerSource);
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
          _switchResult = ("0 as " + _simpleName);
          break;
      }
    } else {
      String _simpleName = this.getFieldType().getSimpleName();
      _switchResult = ("0 as " + _simpleName);
    }
    return _switchResult;
  }
}
