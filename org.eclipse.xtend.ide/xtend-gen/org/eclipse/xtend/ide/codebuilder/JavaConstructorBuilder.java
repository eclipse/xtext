/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder.Java {
  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    return this.appendBody(this.appendThrowsClause(this.appendParameters(this.appendVisibility(appendable, this.getVisibility(), JvmVisibility.PUBLIC).append(this.getOwner().getSimpleName()))), ";");
  }

  @Override
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
