/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
public class XtendConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder.Xtend {
  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;

  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    return this.appendBody(this.appendThrowsClause(this.appendParameters(this.appendVisibility(appendable, this.getVisibility(), JvmVisibility.PUBLIC).append("new"))), "");
  }

  @Override
  public int getInsertOffset(final XtextResource resource) {
    return this._insertionOffsets.getNewConstructorInsertOffset(this.getContext(), this.<XtendTypeDeclaration>findByFragment(resource, this.getXtendType()));
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
