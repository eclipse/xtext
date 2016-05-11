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
import org.eclipse.xtend.ide.codebuilder.AbstractClassBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendClassBuilder extends AbstractClassBuilder implements ICodeBuilder.Xtend {
  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;
  
  @Override
  public boolean isValid() {
    return ((super.isValid() && (!Objects.equal(this.getClassName(), null))) && Objects.equal(this.getVisibility(), JvmVisibility.PUBLIC));
  }
  
  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    ISourceAppender _append = appendable.append("class ");
    String _className = this.getClassName();
    ISourceAppender _append_1 = _append.append(_className);
    ISourceAppender _append_2 = _append_1.append(" {");
    ISourceAppender _newLine = _append_2.newLine();
    return _newLine.append("}");
  }
  
  @Override
  public int getInsertOffset(final XtextResource resource) {
    EObject _context = this.getContext();
    XtendTypeDeclaration _xtendType = this.getXtendType();
    XtendTypeDeclaration _findByFragment = this.<XtendTypeDeclaration>findByFragment(resource, _xtendType);
    return this._insertionOffsets.getNewTypeInsertOffset(_context, _findByFragment);
  }
  
  @Override
  public int getIndentationLevel() {
    return 0;
  }
  
  @Override
  public XtendTypeDeclaration getXtendType() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendTypeDeclaration) _ownerSource);
  }
}
