/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder.Xtend {
  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;

  @Override
  public boolean isValid() {
    return (super.isValid() && (this.getMethodName() != null));
  }

  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      String _xifexpression = null;
      boolean _isOverrideFlag = this.isOverrideFlag();
      if (_isOverrideFlag) {
        _xifexpression = "override ";
      } else {
        _xifexpression = "def ";
      }
      this.appendVisibility(appendable.append(_xifexpression), this.getVisibility(), JvmVisibility.PUBLIC);
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      boolean _isSynchronizedFlag = this.isSynchronizedFlag();
      if (_isSynchronizedFlag) {
        appendable.append("synchronized ");
      }
      this.appendTypeParameters(appendable, this.getTypeParameters());
      boolean _isAbstractFlag = this.isAbstractFlag();
      if (_isAbstractFlag) {
        this.appendType(appendable, this.getReturnType(), "void").append(" ");
      }
      this.appendThrowsClause(this.appendParameters(appendable.append(this.getMethodName())));
      boolean _isAbstractFlag_1 = this.isAbstractFlag();
      boolean _not = (!_isAbstractFlag_1);
      if (_not) {
        this.appendBody(appendable, "");
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }

  @Override
  public int getInsertOffset(final XtextResource resource) {
    return this._insertionOffsets.getNewMethodInsertOffset(this.getContext(), this.<XtendTypeDeclaration>findByFragment(resource, this.getXtendType()));
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
}
