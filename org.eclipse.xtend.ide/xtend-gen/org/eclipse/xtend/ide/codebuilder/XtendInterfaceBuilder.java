/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
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
public class XtendInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder.Xtend {
  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;

  @Override
  public boolean isValid() {
    return ((super.isValid() && (this.getInterfaceName() != null)) && Objects.equal(this.getVisibility(), JvmVisibility.PUBLIC));
  }

  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    return appendable.append("interface ").append(this.getInterfaceName()).append(" {").newLine().append("}");
  }

  @Override
  public int getInsertOffset(final XtextResource resource) {
    return this._insertionOffsets.getNewTypeInsertOffset(this.getContext(), this.<XtendTypeDeclaration>findByFragment(resource, this.getXtendType()));
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
