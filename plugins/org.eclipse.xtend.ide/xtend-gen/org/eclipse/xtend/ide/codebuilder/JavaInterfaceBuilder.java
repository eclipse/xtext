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
import org.eclipse.xtend.ide.codebuilder.AbstractInterfaceBuilder;
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
    return (super.isValid() && (!Objects.equal(this.getInterfaceName(), null)));
  }
  
  @Override
  public ISourceAppender build(final ISourceAppender appendable) {
    JvmVisibility _visibility = this.getVisibility();
    ISourceAppender _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.DEFAULT);
    ISourceAppender _append = _appendVisibility.append("interface ");
    String _interfaceName = this.getInterfaceName();
    ISourceAppender _append_1 = _append.append(_interfaceName);
    ISourceAppender _append_2 = _append_1.append(" {");
    ISourceAppender _newLine = _append_2.newLine();
    return _newLine.append("}");
  }
  
  @Override
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
