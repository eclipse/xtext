/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
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
public class JavaInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder.Java {
  @Override
  public boolean isValid() {
    return (super.isValid() && (this.getInterfaceName() != null));
  }

  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    return this.appendVisibility(appendable, this.getVisibility(), JvmVisibility.DEFAULT).append("interface ").append(this.getInterfaceName()).append(" {").newLine().append("}");
  }

  @Override
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
