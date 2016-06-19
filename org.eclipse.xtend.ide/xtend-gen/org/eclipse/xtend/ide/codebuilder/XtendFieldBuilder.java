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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

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
    return (super.isValid() && (!Objects.equal(this.getFieldName(), null)));
  }
  
  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      JvmVisibility _visibility = this.getVisibility();
      this.appendVisibility(appendable, _visibility, JvmVisibility.PRIVATE);
      boolean _isStaticFlag = this.isStaticFlag();
      if (_isStaticFlag) {
        appendable.append("static ");
      }
      LightweightTypeReference _fieldType = this.getFieldType();
      ISourceAppender _appendType = this.appendType(appendable, _fieldType, "Object");
      ISourceAppender _append = _appendType.append(" ");
      String _fieldName = this.getFieldName();
      _xblockexpression = _append.append(_fieldName);
    }
    return _xblockexpression;
  }
  
  @Override
  public int getInsertOffset(final XtextResource resource) {
    EObject _context = this.getContext();
    XtendTypeDeclaration _xtendType = this.getXtendType();
    XtendTypeDeclaration _findByFragment = this.<XtendTypeDeclaration>findByFragment(resource, _xtendType);
    return this._insertionOffsets.getNewFieldInsertOffset(_context, _findByFragment);
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
